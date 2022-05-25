Map pipelineVariables = preparePipelineVariables(
    runTestsOnBuild: false,

    applications: [
        'infrastructure:application': '<autogenerate>'
    ],
    libraries: [
        
    ]
)

final String APP_VERSION = pipelineVariables['versions']['infrastructure:application']

pipeline {
    agent {
        kubernetes {
            inheritFrom 'default'
            defaultContainer 'jdk'
            yamlFile '.jenkins/agent.yaml'
            workspaceVolume dynamicPVC(accessModes: 'ReadWriteOnce', requestsSize: "5Gi", storageClassName: 'fast')
        }
    }

    options {
        timeout(time: 1, unit: 'HOURS')
    }

    stages {
        stage('build') {
            steps {
                gradleDoBuild pipelineVariables
            }
        }

        stage('tests') {
            steps {
                doTestTask additionalBuildArguments: 'jacocoRootReport'
            }
            post {
                always {
                    gradlePublishBuildReports()
                }
            }
        }
        
        stage('Feature Tests') {
            steps {
                script {
                    prepareTestContainersEnv()
                }
                container('rootless-docker') {
                    doTestTask additionalBuildArguments: ':infrastructure:application:runFeatureTests'
                }
            }
        }
        
        stage('sonarqube') {
            steps {
                gradleDoSonarqube pipelineVariables
            }
        }

        stage('upload') {
            steps {
                gradleParallelUpload pipelineVariables
            }
        }

        stage('build Docker image') {
            steps {
                doDockerImage imageName: 'english-words-helper',
                    version: APP_VERSION
            }
        }

        stage('build Helm chart') {
            steps {
                doHelm projectName: 'english-words-helper',
                    defaultImageTag: APP_VERSION,
                    chartVersion: APP_VERSION,
                    doPatchIngress: false
            }
        }

        stage('deploy to k8s') {
            steps {
                doArgoCD projectName: 'english-words-helper',
                        chartVersion: APP_VERSION,
                        valueFiles: ["values.yaml"]
            }
        }
    }
}
