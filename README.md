# Momenton Code Challenge

This is a code challenge application for Momenton. It retrieves employee data stored in an in-memory database (hsql), and then prints it in hierarchy format on the console.


|Jamie |  | |
|---|---|---|
| |Alan|  |
| |  | Martin|
| |  | Alex|
| |Steve|  |
| |  | David|


The application uses Spring Boot framework and Java 8, following common practices in Spring community.  

|Class | Description |
|---|---|
|EmployeeService |The key service to convert tabular data into hierarchy data  |
|EmployeeRepository | Data access object, using JPA | 
|Employee|Data model|
|SystemUtil|An utility class to print the converted hierarchy data on console|
|EmployeeServiceTest| Test EmployeeService with 3 test cases, using Mockito|

3 scenarios has been tested, using JUnit and Mockito
- Case 1: normal case, provided in the code challenge instruction
- Case 2: Two employees with no manager
- Case 3: One employee with invalid manager id