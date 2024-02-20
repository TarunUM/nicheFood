FROM openjdk:18-alpine
WORKDIR /app
COPY *.jar /app/
EXPOSE 8080
ENTRYPOINT ["java","-jar","*-jar"]