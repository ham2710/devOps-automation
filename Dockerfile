FROM openjdk:8
EXPOSE 8080
ADD target/hibernate_demo.jar hibernate_demo.jar
ENTRYPOINT [ "java", "-jar", "/hibernate_demo.jar " ]