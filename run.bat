@echo off
echo Building...
cd C:\projects\onesoft-pos
mvn clean package -DskipTests
echo Deploying...
del C:\Users\dell\Downloads\OnesoftwareInstall\apache-tomcat-10.1.52\webapps\onesoft-pos.war
rmdir /s /q C:\Users\dell\Downloads\OnesoftwareInstall\apache-tomcat-10.1.52\webapps\onesoft-pos
copy target\onesoft-pos.war C:\Users\dell\Downloads\OnesoftwareInstall\apache-tomcat-10.1.52\webapps\
echo Done!
pause