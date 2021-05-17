FROM openjdk:8-alpine
WORKDIR /app/localstorage/bin
EXPOSE 9090
COPY ./target/*.jar $WORKDIR
ENTRYPOINT ["java","-jar","callerservice.jar"]
