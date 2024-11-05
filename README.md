# payment-gateway

**Project Structure**

* **Controller**: Handle HTTP requests for debit and credit transactions.

* **Service Layer**: Use Factory and Chain of Responsibility patterns for processing transactions.

* **Model**: Represent transaction details.

* **JUnit Tests**: Test the behavior of APIs and service logic.

Sample postman object: 

POST : http://localhost:8080/api/credit/process

{

"senderAccountNo": "345",

"receiverAccountNo": "123",

"name": "Supun",

"amount": 50000,

"overseas" : true,

"passportNumber": "123456"

}