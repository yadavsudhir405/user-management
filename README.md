# user-management
* This is the module assignement during wokshop at ThoughtWorks happend on 5-May-2016 to 6-May-2016
* This assignement implements user-management micro-service using Spring Boot application.
# System-Requirements
* Jre 1.8 installed
* Intellij-Ide or eclipse installed.
# Project-Setup
* Clone or Download this project.
* Import as Maven project to your workspace.
* Run UserManagementApplication.java as Java Application, that's it..User-management service application would start listening to port 9999
# Test Application using curl or Any rest-client such as Postman
* This application handles creating user,groups and mapping users to group,updating user etc..CRUD on User and Group
* Reports on Users such listing all users to particular group.

# List of few end-points with test data:
* http://localhost:9999/groups with GET list all groups
* http://localhost:9999/groups with POST save Group,
 Request Body:
 {
   "name":"Admin"
 }

 Expected Response:
 {
 "id": 1,
 "name": "Admin"
 }
 * localhost:9999/users with GET list all users
 * localhost:9999/users/ with POST
 Request Body:
 ```json
{
  "firstName":"Jhon",
  "lastName":"Smith"
 }
```
 

 Expected Response:
 {
 "firstName": "Jhon",
 "lastName": "Smith",
 "id": 1,
 "group": null
}
