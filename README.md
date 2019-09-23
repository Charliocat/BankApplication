# BANK APPLICATION

Simple Bank application to simulate transactions between bank accounts

## Requirements
- Java 8+ : [JDK 8]
- Maven 3.5.4+ : [Maven]

## Getting Started
1. Download or clone the repository
2. Open it with Intellij IDEA
3. Build & Run it using maven

## Testing
* There is only one Unit test for class [BankOperations]
* Once it is running it can be tested using the integration test in class TransferAgentTest
* To manually test it you can call the endpoint localhost:8080/transfer-agent/transfer with a POST request containing the following body:
     ```json
    {
        "from_account" : {
            "swift" : "<bank_swift>",
            "account_id ": "<account_id>"
        },
        "to_account" : {
            "swift" : "<bank_swift>",
            "account_id" : "<account_id>"
        },
        "amount" : "<amount>"
    }
    ```
    

## Q&A
* How would you improve your solution? What would be the next steps?
    * First of all I would implement a real repository using jpa's entitys and querys to ensure data consistency and integrity.
    * Another improvement related to the previous point is that each bank should have access only to their own accounts and customers only.
    * Also I would implement a logger so the errors wouldn't get lost during runtime.
    * In the class BankOperations method newTransaction, I calculate a Random number to check if the transactions is successful. I would change the order in which that is done and create a new method to commit the transaction.

* After implementation, is there any design decision that you would have done different?
    * Besides the repository part, I think that implement the Transfer package using a decorator pattern would give more flexibility when creating new types of transfer.


* How would you adapt your solution if transfers are not instantaneous?
    * I would use a callback interface when calling to the transaction operation so it would wait for the response.

[JDK 8]: https://jdk.java.net/8/
[Maven]: https://maven.apache.org/install.html
[BankOperations]: impl/src/test/java/com/bankmanager/bank/BankOperationsTest.java
