# Manual

### 0. util


*Создать папку ***util**** *c файлами:*

*[LoggingUtils.java](https://github.com/asachiyigor/aqa_report_portal_1/blob/c5b10d32a289921a6fa28a455f964a7953c9f222/src/test/java/ru/netology/util/LoggingUtils.java)*

*[ScreenShooterReportPortalExtension.java](https://github.com/asachiyigor/aqa_report_portal_1/blob/c5b10d32a289921a6fa28a455f964a7953c9f222/src/test/java/ru/netology/util/ScreenShooterReportPortalExtension.java)*


### 1.    ***build.gradle***

*Добавить*

+ Логгеры
```
    implementation 'com.epam.reportportal:logger-java-logback:5.1.1'
    implementation 'ch.qos.logback:logback-classic:1.2.11'
    implementation 'com.epam.reportportal:logger-java-log4j:5.1.4'
    compileOnly 'log4j:log4j:1.2.17'
    implementation 'org.apache.logging.log4j:log4j-api:2.17.2'
    implementation 'org.apache.logging.log4j:log4j-core:2.17.2'
```

+ Настройки расширения и уровень логирования
```
    systemProperty 'junit.jupiter.extensions.autodetection.enabled', true
    testLogging.showStandardStreams = true
```

---

### 2.  ***resources***

*Добавить файлы* 

*[log4j2.xml](https://github.com/asachiyigor/aqa_report_portal_1/blob/c5b10d32a289921a6fa28a455f964a7953c9f222/src/test/resources/log4j2.xml)*

*[logback.xml](https://github.com/asachiyigor/aqa_report_portal_1/blob/c5b10d32a289921a6fa28a455f964a7953c9f222/src/test/resources/logback.xml)*

*[reportportal.properties - пустой](https://github.com/asachiyigor/aqa_report_portal_1/blob/c5b10d32a289921a6fa28a455f964a7953c9f222/src/test/resources/reportportal.properties)*


*Создать папки META-INF/services/*, добавить в нее файл:

*[org.junit.jupiter.api.extension.Extensio](https://github.com/asachiyigor/aqa_report_portal_1/blob/c5b10d32a289921a6fa28a455f964a7953c9f222/src/test/resources/META-INF/services/org.junit.jupiter.api.extension.Extension)*
### 3. docker-compose.yml
Добавить *[файл](https://github.com/asachiyigor/aqa_report_portal_1/blob/c5b10d32a289921a6fa28a455f964a7953c9f222/docker-compose.yml)*


---
### 4. Запуск сборки командой 
```
*docker-compose -p reportportal up -d --force -recreate*
```
### 5.  Открыть браузер *localhost:8080*

*Логин и пароль на пользователя*
```
login: superadmin
password : erebus
```
Из профиля пользователя добавить данные в [reportportal.properties](https://github.com/asachiyigor/aqa_report_portal_1/blob/c5b10d32a289921a6fa28a455f964a7953c9f222/src/test/resources/reportportal.properties)

---

### 6. Запускаем тесты! :see_no_evil:
