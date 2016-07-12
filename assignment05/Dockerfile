FROM maven:3-jdk-8
VOLUME /tmp
ADD . /
RUN apt-get -y update && apt-get install -y python-pip && pip install awscli && mvn -DskipTests clean package
CMD aws s3 cp $CONFIG_URL/application.properties target/application.properties && cd target/ && java -jar web-service-1.0-SNAPSHOT.jar