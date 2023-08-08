FROM openjdk:19
COPY ./target/eshop-1.0-SNAPSHOT.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java","-jar","/tmp/eshop-1.0-SNAPSHOT.jar"]