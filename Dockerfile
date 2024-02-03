FROM openjdk:15-alpine
EXPOSE 9095
COPY manlib-0.0.1-SNAPSHOT.jar manlib.jar
CMD ["java", "-jar", "manlib.jar"]