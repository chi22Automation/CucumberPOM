

Feature: Login to SalesForse application  I want to use this template for my feature file

  
  Scenario: Login with valid UserName and Valid Password
  
    Given User is on the login Page
    When user enters"cc@techarch.com" into username field
    When user enters"selenium1" into password field
    When user click on login button
   
    Then verify page title "Home Page ~ Salesforce - Developer Edition"
   

 
 Scenario: Login with valid UserName and clear Password
  
    Given User is on the login Page
    When user enters"cc@techarch.com" into username field
    When user enters "" into password field
    When user click on login button
   
    Then verify error message "Please enter your password."