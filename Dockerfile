FROM openjdk:8u171-alpine3.7
RUN apk --no-cache add curl
COPY target/hello-world-server*.jar hello-world-server.jar
EXPOSE 80/tcp
CMD java ${JAVA_OPTS} -jar hello-world-server.jar