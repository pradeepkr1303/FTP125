#!/bin/bash -ex
set -ex
cd restservice/leavemanager/
/var/lib/jenkins/apache-maven-3.5.2/bin/mvn package -Dbuild.number=${BUILD_NUMBER}
cd ../integration-test
/var/lib/jenkins/apache-maven-3.5.2/bin/mvn package -DskipTests
cd ../../webui/lm-app
# Here we run the jasmine test
npm install
ng lint --type-check
ng test --watch false
ng build
cp ../../restservice/leavemanager/target/FTP125-0.0.1-${BUILD_NUMBER}.war ./FTP125.war
cd ..
tar -cvzf lm-app.zip lm-app/*
cd lm-app/dist
jar -uvf ../FTP125.war *
cd ../../../build
cp ../webui/lm-app/FTP125.war .
cp ../webui/lm-app.zip .
cp ../restservice/integration-test/target/FTP125-integration-tests-1.0-test-sources.jar .
cp ../database/database.* .
tar -cvzf FTP125-${BUILD_NUMBER}.tar.gz FTP125.war FTP125-integration-tests-1.0-test-sources.jar lm-app.zip database.* *.sh
echo TAR_FILE=FTP125-${BUILD_NUMBER}.tar.gz > build.properties
/usr/local/bin/aws s3 cp FTP125-${BUILD_NUMBER}.tar.gz s3://com.hexaware.builds.ftp/