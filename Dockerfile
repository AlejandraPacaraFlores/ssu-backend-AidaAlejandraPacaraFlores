FROM gradle:8.5-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

# Esta línea debe estar aquí sí o sí
RUN chmod +x ./gradlew

RUN ./gradlew build -x test --no-daemon

# Paso 2: Crear la imagen ligera de producción
FROM eclipse-temurin:17-jre-alpine
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/*-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]