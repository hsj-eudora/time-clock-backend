# TimeClock Project's backend

## 環境要求

- Docker
- Docker Compose

## 複製下載此專案

1. 請複製或下載此專案目錄底下所有資料(第一次)。
2. 第一次成功運行後，後續僅需更新jar檔。

## 程式指令

於專案目錄下執行以下指令：

1. 第一次啟動建立
   sh
   docker-compose up --build

2. 第二次之後運行(更新Jar)
   ※更新前請確定容器已停止

   sh
   docker cp [放置Jar檔的絕對路徑] [docker運行app的容器ID]:/app/timeclock-0.0.1-SNAPSHOT.jar
   例如:docker cp D:/0.claire/claire/20240714/timeclock/target/timeclock-0.0.1-SNAPSHOT.jar d19c85b691aeab626669986288dacafa8d765744a3d6ff26fb72eac21a6b245b:/app/timeclock-0.0.1-SNAPSHOT.jar (重建app-更新jar檔)
   
   docker-compose up (啟動) 

## 確認是否成功

於網址列輸入http://localhost:8080/

或是開啟POSTMAN傳送API