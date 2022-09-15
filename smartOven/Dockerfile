FROM openjdk:11
COPY ./target/smartOven-0.0.1-SNAPSHOT.jar /usr/app
WORKDIR /usr/src/app
RUN sh -c 'touch smartOven-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java", "-jar", "smartOven-0.0.1-SNAPSHOT.jar"]