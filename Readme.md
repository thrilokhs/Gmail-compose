 # Focus area - Gmail Compose
 
 PRE REQUISITE:
1. Java 8
2. Selenium Webdriver
3. Chrome Browser
4. Eclipse
5. TestNG

NOTE - Gmail has RESTRICTIONS to sign in if the browser is launched with selenium. 
 As a workaround, I have used to login to a app that supports "login With Google" to create a google session and later launch the gmail home page directly.  
 
 Compose features available:
 - Adding emails in To, Cc and Bcc
 - Adding Attachments
 - Scheduling emails to next week
 - Verifying email delivery 
 - Select text font for email body (I noticed a defect in gmail where the initial font selection is not applied) 
 - Error verification while sending a mail without an email id
 

FRAMEWORK DESIGN:
There are 3 DIFFERENT PACKAGES ARE USED :
 1. Helper → Contains reusable classes and methods
   1.1 Base Class → I have used TestNG annotations for the common functions like Login/Logout and initiating the Chrome Driver.
   1.2 Generic Class → All reusable components that can be used any web application projects. It is predominantly used to identify the webelements and to perform      the action until the condition is met for a max of 15 secs.
    2. Page Object → Contains all the objects and methods related to the pages in the application
   2.1 -> GmailLogin --> Contains the webelements present during the Login Navigation process
   2.2 -> GmailDashboard --> Contains the webelements present on the Gmail landing page/ Dashboard.
   2.3 --> GmailCompose --> Contains the webelements present on the Compose page. More focus is given in this area for this project
   
 3. Test Cases → I have designed methods which predominatly covers the different test cases that occur during composing and sending an email

