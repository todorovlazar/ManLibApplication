FROM openjdk:15-alpine
EXPOSE 9095
COPY manlib-0.0.1-SNAPSHOT.jar manlib.jar
COPY /src/main/resources/application.properties /app/application.properties
CMD ["java", "-jar", "manlib.jar"]