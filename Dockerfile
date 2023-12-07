FROM jetty:10.0.17-jdk11

USER root

# make shared directories and change ownership to jetty
RUN mkdir /app
RUN chown -R jetty:jetty /app
RUN chmod 777 /app

USER jetty