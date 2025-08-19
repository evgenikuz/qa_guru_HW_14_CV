# Проект по автоматизации тестовых сценариев для [Вкусвилл](https://vkusvill.ru)
## :pushpin: Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Запуск тестов из терминала](#arrow_forward-запуск-тестов-из-терминала)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Пример Allure-отчета](#пример-allure-отчета)
- [Уведомления в Telegram с использованием бота](#уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

## :computer: Использованный стек технологий

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="imgForRM/icons/Intelij_IDEA.svg">
<img width="6%" title="Java" src="imgForRM/icons/Java.svg">
<img width="6%" title="Selenide" src="imgForRM/icons/Selenide.svg">
<img width="6%" title="Selenoid" src="imgForRM/icons/Selenoid.svg">
<img width="6%" title="Allure Report" src="imgForRM/icons/Allure_Report.svg">
<img width="6%" title="Gradle" src="imgForRM/icons/Gradle.svg">
<img width="6%" title="JUnit5" src="imgForRM/icons/JUnit5.svg">
<img width="6%" title="GitHub" src="imgForRM/icons/GitHub.svg">
<img width="6%" title="Jenkins" src="imgForRM/icons/Jenkins.svg">
<img width="6%" title="Telegram" src="imgForRM/icons/Telegram.svg">
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide.
- В качестве сборщика был использован - <code>Gradle</code>.
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://selenoid.autotests.cloud/).
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## :arrow_forward: Запуск автотестов

### Запуск тестов
Запуск тестов выполняется при помощи Gradle-скрипта:
```
gradle clean test
```
При необходимости также можно переопределить параметры запуска

```
clean test 
-Dbrowser=${BROWSER} 
-Dversion=${VERSION}
-Dresolution=${RESOLUTION} 
-Dselenoid_url=${SELENOID_URL} 
```

### Параметры сборки

* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По-умолчанию - <code>chrome</code>.
* <code>VERSION</code> – версия браузера, в которой будут выполняться тесты. По-умолчанию - <code>100.0</code>.
* <code>RESOLUTION</code> – размер окна браузера, в котором будут выполняться тесты. По умолчанию <code>1980x1080</code>.
* <code>SELENOID_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.

## <img src="imgForRM/icons//Jenkins.svg" title="Jenkins" width="4%"/> Сборка в Jenkins
<p align="center">
<img title="Jenkins Build" src="imgForRM/screenshots/JenkinsBuild.png">
</p>

## <img src="imgForRM/icons//Allure_Report.svg" title="Allure Report" width="4%"/> Пример Allure-отчета
### Overview

<p align="center">
<img title="Allure Overview" src="imgForRM/screenshots/allureReport.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="imgForRM/screenshots/ResultTest.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="imgForRM/icons/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram Notifications" src="imgForRM/screenshots/tgalert.png">
</p>

## Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="imgForRM/screenshots/video.gif">
</p>