PRE REQUISITE:
1. Java 8
2. Selenium Webdriver
3. Chrome Browser
4. Eclipse

FRAMEWORK DESIGN:
3 DIFFERENT PACKAGES ARE USED :

1. Helper → Contains reusable classes and methods
   1.1 Base Class → I have used TestNG annotations for the common functions like Login/Logout.
   1.2 Generic Class → All reusable components that can be used any web application projects
   
2. Page Object → Contains all the objects and methods related to the pages in the application
   
3. Test Cases → I have designed a method which is more generic and can be used to validate all the apple products available in the website and it is accessible. 
