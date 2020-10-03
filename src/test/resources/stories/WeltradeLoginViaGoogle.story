Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to login via Google

Given user opened 'Authorization Page' by url: 'PROD_WELTRADE_CAB_LOGIN_URL'
When user clicks 'Login via Google' button
And user tries to login to Weltrade site via Google: 'tweltrade@gmail.com'
And user tries to login to Weltrade site: '11weltrade'
Then Weltrade cabinet logo displayed