# Dockerfile

# Java 17作為基礎
FROM openjdk:17-jdk-slim

# 複製JAR文件到容器內的指定路徑
COPY target/timeclock-0.0.1-SNAPSHOT.jar /app/timeclock-0.0.1-SNAPSHOT.jar

# 指定工作目錄
WORKDIR /app

# 運行容器
CMD ["java", "-jar", "timeclock-0.0.1-SNAPSHOT.jar"]
