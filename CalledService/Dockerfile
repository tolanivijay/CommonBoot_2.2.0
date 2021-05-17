FROM openjdk:8-alpine
WORKDIR /app/localstorage/bin
EXPOSE 9091
COPY ./target/*.jar $WORKDIR
ENTRYPOINT ["java","-jar","calledservice.jar"]
