FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD target/BVTP_Transactions-1.0.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
