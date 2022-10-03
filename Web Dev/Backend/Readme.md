
# Student Application

A SpringBoot Web based ***Student Application*** created with Java 11 integrated with In-Memory ***H2 Database***




## Installation

- Install JDK 11
- Install IntelliJ IDE
- ```` git clone https://github.com/Parvezi123/IOSD-BPIT-Hacktoberfest-2022.git ````
- Open the Project in IntelliJ with navigation as below path
  - ````'Web Dev/Backend/Java_SpringBoot_Application'````
- Don't worry about the Dependencies, In-Built maven will load all the dependencies for you


    
## Demo

- Run the SpringBoot Application, By default it will run in TomCat Server
- Open Browser and execute this URL 'http://localhost:9080/swagger-ui/index.html'

- There you can see my Existing exposed API's will be visible
  - with that create sample data in JSON Format and the Try Retriving the saved Data.

You can check the `controller/StudentController` class, 
- I have already created 2 API's   
  -  To Save Student Detail &nbsp; &nbsp; _/api/savestudent_
  -  To Retrieve Student List &nbsp; &nbsp;  _/api/allstudents_

***Note: Everytime you start the application your created will be erased Since, I used In-Memory H2-Database***



## Contributing

Contributions are always welcome!

Go to Controller `controller/StudentController` class, 
- Create API to Retrieve Student Record with StudentID with Get MethodRequest
  -  Keep the EndPoint as &nbsp; &nbsp; _/api/studentbyid_
- Create API to Delete Student Record with StudentID with Delete MethodRequest
  -  Keep the EndPoint as &nbsp; &nbsp; _/api/studentbyid_
- Based on the API, create logic for Service Layer as well

***Note:*** &nbsp; Same endpoint with Different MethodRequest will work




## 🚀 About Me
I'm a Software Developer Engineer in Siemens, Bengaluru...



## Authors

- [@Parvezi123](https://github.com/Parvezi123)


