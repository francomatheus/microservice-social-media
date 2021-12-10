FROM gradle:7.3.1-jdk11-alpine as builder
COPY . .
RUN gradle clean bootJar

FROM openjdk:11.0-jdk-slim
WORKDIR /src
COPY --from=builder /app/build/libs/*.jar /src/app.jar
ENV JAVA_OPT=" -XX:+UseG1GC -XX:MaxHeapFreeRatio=70 "
EXPOSE 8081
CMD ["java", "-jar", "$JAVA_OPT", "app.jar"]