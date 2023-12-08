FROM jetty:10.0.17-jdk11


USER root
COPY ./target/DevOps-0.0.1-SNAPSHOT.war /var/lib/jetty/webapps/root.war
RUN mkdir /app
RUN chown -R jetty:jetty /app
RUN chmod 777 /app
USER jetty
