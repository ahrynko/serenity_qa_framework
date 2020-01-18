Meta:'Your password must be 8-40 characters long.'
@sportchek_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to see the error messages in registration form

Given user opened page using following url: 'https://www.sportchek.ca/'
Given user clicks Sign In/Create Account button
Given user clicks Register Now button
When user typed one character in each input field: 'w'
Then following message is displayed in Email input field: 'Please enter your email address in this format: name@example.com'
Then following message is displayed in Confirm Email input field: 'Please enter your email address in this format: name@example.com'
Then following message is displayed in Password input field:
Then following message is displayed in Confirm Password input field: 'Your password must be 8-40 characters long.'