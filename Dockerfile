FROM tomcat

COPY target/classwork_oris-1.0.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD["catalina.sh", "run"]