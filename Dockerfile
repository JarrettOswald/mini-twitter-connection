FROM openjdk:17.0.1-jdk-slim
COPY /mini-twitter-service/target/mini-twitter-service-*.jar /usr/local/lib/service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/service.jar"]