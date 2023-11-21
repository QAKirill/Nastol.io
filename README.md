# Проект по автоматизации тестовых сценариев для <a href="https://nastol.io" target="blank">Nastol.io</a>
## :pushpin: Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#jenkins)
- [Пример Allure-отчета](#allure)
- [Интеграция с Allure TestOps](#TestOps)
- [Уведомления в Telegram с использованием бота](#telega)
- [Видео примера запуска тестов в Selenoid](#Видео-запуска-тестов-в-Selenoid)

## :computer: Использованный стек технологий

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="attach/Logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="attach/Logo/Java.svg">
<img width="6%" title="Selenide" src="attach/Logo/Selenide.svg">
<img width="6%" title="Selenoid" src="attach/Logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="attach/Logo/Allure_Report.svg">
<img width="5%" title="Allure TestOps" src="attach/Logo/AllureTestOps.svg">
<img width="6%" title="Gradle" src="attach/Logo/Gradle.svg">
<img width="6%" title="JUnit5" src="attach/Logo/JUnit5.svg">
<img width="6%" title="GitHub" src="attach/Logo/GitHub.svg">
<img width="6%" title="Jenkins" src="attach/Logo/Jenkins.svg">
<img width="6%" title="Telegram" src="attach/Logo/Telegram.svg">
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide. 
- В качестве сборщика был использован - <code>Gradle</code>.  
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота. 
- Осуществлена интеграция с <code>Allure TestOps</code>

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## :arrow_forward: Запуск автотестов

### Запуск тестов из терминала
```
gradle clean test
```
При запуске из Jenkins job, тесты запустятся удаленно в <code>Selenoid</code>.

Также можно переопределить параметры запуска:

```
clean
remote_test
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DremoteDriverUrl=https://user1:1234@${REMOTE_DRIVER_URL}/wd/hub
```
## <img name="jenkins" src="attach/Logo/Jenkins.svg" title="Jenkins" width="4%"/> <a href="https://jenkins.autotests.cloud/job/NastolioUIAutotests" target="blank">Сборка в Jenkins</a>

<p align="center">
<img title="Jenkins Build" src="attach/Reports/JenkinsBuild.png">
</p>

### Параметры сборки

* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По-умолчанию - <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты. По-умолчанию - <code>100.0</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По-умолчанию - <code>1920x1080</code>.
* <code>REMOTE_DRIVER_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.

## <img name="allure" src="attach/Logo/Allure_Report.svg" title="Allure Report" width="4%"/> <a href="https://jenkins.autotests.cloud/job/NastolioUIAutotests/4/allure" target="_blank">Пример Allure-отчета</a>

### Overview

<p align="center">
<img title="Allure Overview" src="attach/Reports/allureReport.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="attach/Reports/ResultTest.png">
</p>

## <img name="TestOps" src="attach/Logo/AllureTestOps.svg" title="Allure TestOps" width="4%"/> <a href="https://allure.autotests.cloud/launch/32251" target="_blank">Интеграция с Allure TestOps</a>

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
Результат выполнения автотестов отображается в <code>Allure TestOps</code>
На Dashboard в <code>Allure TestOps</code> отображена статистика пройденных тестов.

<p align="center">
<img title="Allure TestOps DashBoard" src="attach/Reports/allureAutotestCloud.png">
</p>

## <img name="telega" width="4%" style="vertical-align:middle" title="Telegram" src="attach/Logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="attach/Reports/notification.png">
</p>

## Видео запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.  
<p align="center">
<img name="video" title="Selenoid Video" src="attach/Reports/video.gif" width="550" height="350"  alt="video">   
</p>
