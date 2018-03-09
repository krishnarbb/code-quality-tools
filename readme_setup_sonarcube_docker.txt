Sonar Cube docker : https://hub.docker.com/_/sonarqube/

docker pull sonarqube

The server is started this way:

$ docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube
By default you can login as admin with password admin, see authentication.

To analyse a project:

Sonar cube analysed : sample projects
https://github.com/SonarSource/sonar-scanning-examples/tree/master/sonarqube-scanner-maven

mvn clean install sonar:sonar

