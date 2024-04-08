FROM #{eclipse-temurin_17_alpine}#
LABEL version="#{Build.BuildNumber}#"  description=""
EXPOSE 8080
COPY LiteThinking.jar app.jar
ENV JAVA_OPTS="-XX:+UseContainerSupport -Djava.security.egd=file:/dev/./urandom"
USER #{eclipse-temurin_17_alpine-user}#
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]