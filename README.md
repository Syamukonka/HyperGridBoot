# HyperGrid (Electricity Billing System)
<hr/> 

## Spring Boot Application

This application is built using the __SpringBoot__ Framework. It is a **_RESTful_** application that provides a simple ***API*** for interacting with data in the backend via **_CRUD_** operations.
***HyperGrid*** is the name I have given to this Electricity Billing System project. It simulates the billing process and various viewing interfaces of a Power Supply company. You can test the RESTful API
using PostMan or Insomnia. <br/>

The Front-end of this appplication is available on [HyperGrid Front-End](https://github.com/Syamukonka/hyper-grid-client) <br/> 


<hr/>

### Programming Features
1. <b> Database </b> 
    <ul>
        <li> JPA Repository </li>
        <li> MySql </li>
    </ul>
2. <b> Spring Boot </b>
     <ul>
         <li> RestControllers </li>
         <li> Exception Handling </li>
         <li> SpringBoot Testing </li>
         <li> Application Properties </li>
     </ul>
3.  <b> Advanced Java</b>
     <ul> 
         <li> Streams </li>
         <li> Collections </li>
     </ul>


### Application Feature
1. Add customer
2. Update a customer
3. Delete a customer
4. View a customer
5. Search customers _(By name, id, category)_
6. Admin Login
7. Business Statistics
8. Make payment
9. View Transactions

## Packages and Classes

### 1. Entity package
This package Contains ORM classes, all mapping to the respective database tables
1. ### `Customer` <br/>
   Annotated with `@Entity`. It is the Object mapped to the  `customer table` of the relational database.
2. ### `Admin` <br/>
   Another __Entity__,this one is mapped to the `admin table` in the database. It represents an admin user.
3. ### `Transaction` <br/>
   Also an __Entity__,this one is mapped to the `transaction table` in the database. All transactions made for customers are recorded in the transaction table.
4. ### `ErrorMessage` <br/>
   This class is not related to the Database in any way, it is rather a Class of objects that we will be returning as error-message bodies. So this will help to display error responses with appropriate messages. 
5. ### `Stats` <br/>
   This entity represents some calculated statistics that need to be returned in the body of an HTTP response. 



### 2. Controllers package
This package includes classes annotated with `@RestController`, they used to serve the client requests via a REST endpoint.
1. ### `CustomerController` <br/>
   Handles all requests related customer operations such as requests to `search`,`add`, `delete`, `view`, `edit/update`.
2. ### `LoginController` <br/>
   Handles the login request, by transferring the login data to the `AdminService` with performs authentication and verification.
2. ### `TransactionController` <br/>
   Handles all requests to read past transactions and also for making new payments.


### 3. Services package
This package contains the classes for Database management, using the `javax.persistence` API, backed with __Hibernate__ framework.
1. ### `CustomerServiceImpl` <br/>
   Defines service logic that is required beyond simple CRUD operations.
2. ### `AdminServiceImpl` <br/>
   Defines operations for fetching admin users. This is mainly used to perform authentication.
3. ### `TransactionServiceImpl` <br/>
   Defines some service logic that prepares transactional data before writing to the database or sending back to the requester.


### 4. Repository Package
This package contains interfaces that extend the `JpaRepository`. They each specify the entity they represent and by doing so, the various CRUD operation methods are generated for those entities.
this package include
1. ### `AdminRepository`
2. ### `CustomerRepository`
3. ### `TransactionRepository`


### 5. Exception Package
For the sake of preventing server crashes and also returning meaningful error responses to the client side, exception handling is used. 
1. ### `ResponseEntityExceptionHandler` 
   provided by Spring Framework helps us to handle exceptions in a very robust way. It can prevent the application from crushing while sending back meaningful error messages and suggestions.
2. ### `CustomerNotFoundException` 
   is thrown when a requested customer is not found in the database.
3. ### `InvalidCustomerDetailsException` 
   is thrown when a request involving a customer is made with invalid data, or missing fields.  


### 6. Service Layer Test

This package, containers test classes for the service layer.
1. ### `AdminServiceTest`<br/>
   Testing the login behaviour, to assert correct results.
2. ### `CustomerServiceTest` <br/>
   Testing for customer service methods, making sure the expected behaviour is retained.  


<hr/>

_www.syamukonka.com_