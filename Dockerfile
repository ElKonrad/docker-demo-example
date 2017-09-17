FROM anapsix/alpine-java:8_jdk

WORKDIR /app/codebase

ADD . ./

RUN ./mvnw clean package

RUN bash -c 'cp target/demo-example-0.0.1-SNAPSHOT.jar ../app.jar'

WORKDIR /app

RUN bash -c 'rm -rf codebase'

RUN bash -c 'touch app.jar'

ENV app_name = 'Demo example app'

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]