
<div id="header" align="center">
  <img src="https://messenge.ru/wp-content/uploads/2020/04/TBS_Robot.jpg)" width="100"/>
</div>

<div id="badges" align="center">
  <a href="https://t.me/HabrGB_Bot">
    <img src="https://img.shields.io/badge/Telegrambot-blue?style=for-the-badge&logo=telegram&logoColor=white" alt="Telegram Badge"/>
  </a>
</div>

<h1 align="center">
  Telegram bot "TelehabrBot"
</h1>


Simple Telegram bot on Java / Spring Boot

Bot for knowledge sharing in the format of a system of thematic collective blogs
(called hubs) with elements of a news bot, created to publish news, analytical articles,
thoughts.

## Application launch:

- You need to be a registered Telegram user to start using it

- Following tools are required:
  - JDK openjdk:11
  - Spring-boot-maven-plugin
  - Spring-boot 2.7.3
  - Telegrambots 6.1.0
  - PostgreSQL 14.5

- Install [Docker](https://docs.docker.com/desktop/)

- Use command line:
    ```js 
    git clone https://github.com/AlexeySapunov/TeamDevelopment.git 
    ```
  
- Run [start.sh](https://github.com/AlexeySapunov/TeamDevelopment/blob/master/start.sh); ${...} substitute the desired value from [Dockerfile](https://github.com/AlexeySapunov/TeamDevelopment/blob/master/Dockerfile)
    ```js 
    bash start.sh ${BRANCH_NAME} DB_USERNAME=${DB_USERNAME} DB_PASSWORD=${DB_PASSWORD} DB_NAME=${DB_NAME} DB_PORT=${DB_PORT} APP_PORT=${APP_PORT} 
    ```

- Go to the link: [![Telegram Badge](https://img.shields.io/badge/-telehabrBot-blue?style=flat&logo=Telegram&logoColor=white)](https://t.me/HabrGB_Bot)
  and click /start.

## Application launch:

- You need to be a registered Telegram user to start using it

- Following tools are required:
  - JDK openjdk:11
  - Spring-boot 2.7.3
  - Telegrambots 6.1.0
  - PostgreSQL 14.5

- Use command line:
    ```js 
    git clone https://github.com/AlexeySapunov/TeamDevelopment.git 
    ```
- Configure the postgresql database per [properties](https://github.com/AlexeySapunov/TeamDevelopment/blob/master/TelegramBot/src/main/resources/application.properties) 

- Run [docker-compose](https://github.com/AlexeySapunov/TeamDevelopment/blob/master/docker-compose.yaml)

- go to the link: [![Telegram Badge](https://img.shields.io/badge/-telehabrBot-blue?style=flat&logo=Telegram&logoColor=white)](https://t.me/HabrGB_Bot)
and click /start.

More detailed instructions and navigation on the functionality of the bot in the menu /help.

- To stop the app run [stop.sh](https://github.com/AlexeySapunov/TeamDevelopment/blob/master/stop.sh)

---

### :hammer_and_wrench: Languages and Tools :

<div>
  <img src="https://github.com/devicons/devicon/blob/master/icons/java/java-original-wordmark.svg" title="Java" alt="Java" width="40" height="40"/>&nbsp;
  <img src="https://github.com/devicons/devicon/blob/master/icons/spring/spring-original-wordmark.svg" title="Spring" alt="Spring" width="40" height="40"/>&nbsp;
  <img src="https://github.com/devicons/devicon/blob/master/icons/docker/docker-original-wordmark.svg" title="Docker" alt="Docker" width="40" height="40"/>&nbsp;
  <img src="https://github.com/devicons/devicon/blob/master/icons/postgresql/postgresql-original-wordmark.svg" title="Postgresql" alt="Postgresql" width="40" height="40"/>&nbsp;
  <img src="https://3dnews.ru/assets/external/illustrations/2021/02/26/1033659/1.jpg" title="TelegramApi" alt="TelegramApi" width="40" height="40"/>&nbsp;
</div>
