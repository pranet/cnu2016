FROM maven:3-jdk-8
VOLUME /tmp
RUN git clone -b assignment04a https://github.com/phantom002/cnu2016.git
RUN cd cnu2016/assignment04 && apt-get -y update && apt-get install -y python-pip && pip install awscli && mvn package
CMD cd cnu2016/assignment04 aws s3 cp $S3_HOME/application.properties target/application.properties && java -jar target/web-service-1.0-SNAPSHOT.jar --spring.config.location=/target/application.properties