FROM adoptopenjdk/openjdk11:jdk-11.0.9_11.1-alpine-slim

ENV MAX_RAM_PERCENTAGE=80 \
  ADDITIONAL_JAVA_FLAGS="" \
  JAVA_ARGS="" \
  DEBUG_ARGS="" \
  APPLICATION_ARGS=""

ADD ./infrastructure/application/build/libs/* /app/

WORKDIR /app

ENTRYPOINT java \
  -XX:+UseContainerSupport \
  -XX:MaxRAMPercentage=$MAX_RAM_PERCENTAGE \
  $ADDITIONAL_JAVA_FLAGS \
  $JAVA_ARGS \
  $DEBUG_ARGS \
  -jar ./*.jar \
  $APPLICATION_ARGS
