Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Account Login"

Scenario: Forgot Password link
Given user is on login page
Then forgot your password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters username "gurupdas11@gmail.com"
And user enters password "Guru1234"
And user clicks on Login button
Then user home gets the title of the page
And Home page title should be "My Account"