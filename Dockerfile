# Dockerfile

# 使用官方的Java 17映像作為基礎
FROM openjdk:17-jdk-slim

# 複製JAR文件到容器內的指定路徑
COPY timeclock-0.0.1-SNAPSHOT.jar /app/timeclock-0.0.1-SNAPSHOT.jar

# 指定工作目錄
WORKDIR /app

# 定義容器啟動時運行的命令
CMD ["java", "-jar", "timeclock-0.0.1-SNAPSHOT.jar"]