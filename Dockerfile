# Etapa de construcción
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /alumno
COPY src ./src
COPY pom.xml ./pom.xml
RUN mvn clean package

# Etapa de ejecución
FROM openjdk:17.0.2-jdk
VOLUME /tmp
COPY --from=build /alumno/target/alumno-0.0.1-SNAPSHOT.jar alumno.jar
EXPOSE 8098
ENTRYPOINT ["java","-jar","alumno.jar"]