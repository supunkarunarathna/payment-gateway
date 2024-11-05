# payment-gateway

**Project Structure**

* **Controller**: Handle HTTP requests for debit and credit transactions.

* **Service Layer**: Use Factory, Chain of Responsibility and Builder(TransactionResponse) patterns for processing transactions.

* **Model**: Represent transaction details.

* **JUnit Tests**: Test the behavior of APIs and service logic.
* Used H2 Database as an In-Memory Database in Spring Boot

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