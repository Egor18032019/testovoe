# testovoe

Прописать в application.properties настройки БД

Стандартный запуск
* mvn clean package
* java -jar target/demo-0.0.1-SNAPSHOT.jar
Пример запросов:
###

GET http://localhost:8080/computers

###

POST http://localhost:8080/computers/add
Content-Type: application/json

{
"serialNumber": 22,
"producerType": 22,
"price": 22,
"balance": 11,
"formComputer": "Desk"
}

GET http://localhost:8080/displays

###

POST http://localhost:8080/displays/add
Content-Type: application/json

{
"serialNumber": 22,
"producerType": 22,
"price": 22,
"balance": 11,
"diagonal": 22
}