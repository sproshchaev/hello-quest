# hello-quest
### Javarush Servlet Project

Простой текстовый квест на Java с использованием сервлетов, JSP и JSTL.

## Технологии
- Java 11
- Maven
- Servlet API 4.0
- JSP 2.3
- JSTL 1.2
- Tomcat 9

## Запуск проекта

### Вариант 1: С использованием Maven плагина Tomcat (без установки Tomcat)

Это самый простой способ для быстрого запуска:

#### Шаг 1: Добавьте плагин в pom.xml

Добавьте в раздел `<build><plugins>` вашего `pom.xml`:

```xml
<plugin>
    <groupId>org.apache.tomcat.maven</groupId>
    <artifactId>tomcat7-maven-plugin</artifactId>
    <version>2.2</version>
    <configuration>
        <port>8080</port>
        <path>/HelloQuest</path>
    </configuration>
</plugin>
```

#### Шаг 2: Запустите через Maven в IntelliJ IDEA

1. Откройте вкладку **Maven** справа (View → Tool Windows → Maven)
2. Разверните проект `HelloQuest` → **Plugins** → **tomcat7**
3. Дважды кликните на **tomcat7:run**

#### Шаг 3: Откройте в браузере

Перейдите по адресу:  
🔗 **http://localhost:8080/HelloQuest/hello**

### Вариант 2: Через терминал/командную строку

1. Убедитесь, что Maven установлен:
```bash
mvn -v
```

2. Перейдите в корневую директорию проекта (где находится pom.xml)

3. Выполните команду:
```bash
mvn tomcat7:run
```

### Вариант 3: С установленным Tomcat 9

Если у вас установлен Tomcat 9:

1. **Соберите WAR-файл:**
```bash
mvn clean package
```

2. **Скопируйте файл** `target/HelloQuest.war` в директорию `webapps` вашего Tomcat

3. **Запустите Tomcat** и перейдите по адресу:  
   🔗 **http://localhost:8080/HelloQuest/hello**

## Структура проекта

```
HelloQuest/
├── src/
│   └── main/
│       ├── java/com/example/quest/
│       │   ├── HelloServlet.java     # Приветственный сервлет
│       │   └── GameServlet.java      # Логика игры
│       ├── webapp/
│       │   ├── index.jsp             # Главная страница
│       │   ├── result.jsp            # Страница результата
│       │   └── WEB-INF/
│       │       └── web.xml           # Дескриптор развертывания
│       └── resources/
├── pom.xml                           # Конфигурация Maven
└── README.md                         # Эта инструкция
```

## Как играть

1. **Начало игры:** Откройте http://localhost:8080/HelloQuest/hello
2. **Выбор действия:** Вам будет предложен выбор - принять или отклонить вызов НЛО
3. **Результат:** В зависимости от выбора вы получите победу или поражение
4. **Повтор:** Можно начать игру заново

## Особенности реализации

✅ **Maven проект** с правильно настроенными зависимостями  
✅ **Сервлеты** для обработки HTTP запросов  
✅ **JSP + JSTL** для отображения страниц  
✅ **Хранение данных в сессии** (результат игры)  
✅ **Возможность начать игру заново**  
✅ **Tomcat 9** для запуска и тестирования

## Устранение неполадок

### Ошибка 404
- Убедитесь, что Tomcat запущен (порт 8080)
- Проверьте контекстный путь: должен быть `/HelloQuest`

### Плагин не найден
- Обновите зависимости Maven: в IntelliJ нажмите **Maven → Reload Project**
- Или выполните в терминале: `mvn clean install`

### Порт 8080 занят
- Измените порт в конфигурации плагина:
```xml
<port>8081</port>
```
- Тогда адрес будет: http://localhost:8081/HelloQuest/hello

## Для разработчиков

### Добавление новых вопросов
1. Создайте новый JSP файл в `webapp/`
2. Добавьте обработку в `GameServlet.java`
3. Обновите логику переходов между вопросами

### Тестирование
```bash
mvn test
```

---

## Контакты

Проект создан в рамках курса **JavaRush Module 3: Java Professional**.
