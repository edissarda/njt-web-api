FROM maven:3.6.3-jdk-8 as build
WORKDIR /app
COPY . .
RUN mvn package

FROM openjdk:8-jre-slim
WORKDIR /app
COPY --from=build /app/target/WebApi-api.jar app.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","app.jar"]