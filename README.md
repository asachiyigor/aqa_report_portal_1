# Manual

### 0. util


*Создать папку ***util**** *c файлами:*





### 1.    ***build.gradle***

*Добавить*

+ Добавить логгеры
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
*Создать папки "META-INF/services/"*, добавить в нее файл: ***org.junit.jupiter.api.extension.Extension***
```


```
*Добавить файл* ***log4j2.xml***
```


```
*Добавить файл* ***logback.xml***
```


```
*Добавить файл* ***reportportal.properties***
```


```
---
### 3. docker-compose.yml
*Добавить файл*


---
### 4. Запуск командой ***docker-compose -p reportportal up -d --force -recreate***


---