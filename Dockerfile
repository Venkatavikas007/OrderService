FROM openjdk:17-jdk-slim
WORKDIR /app
EXPOSE 8080
COPY target/orderservice-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
