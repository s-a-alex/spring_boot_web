FROM openjdk:8
COPY target/spring_boot_web-0.0.1-SNAPSHOT.jar /spring_boot_web.jar
ENTRYPOINT ["java","-jar","/spring_boot_web.jar"]