Meta:
@weltrade_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to change the city in Settings

Given user opened 'Authorization Page' by url: 'DEV_WELTRADE_CAB_LOGIN_URL'
When user tries to sign in to Weltrade site , using following info:
| email                | password |
| mtuser30@hotmail.com | 8ZO3JHC1 |
And user closed the T2W banner
And user opened 'Settings Page'
And user changed the city random
Then following success toast displayed: 'Operation completed'


Scenario: Verify user is able to see the error message in Personal data

Given user opened 'Authorization Page' by url: 'DEV_WELTRADE_CAB_LOGIN_URL'
When user tries to sign in to Weltrade site , using following info:
| email                | password |
| mtuser30@hotmail.com | 8ZO3JHC1 |
And user closed the T2W banner
And user opened 'Settings Page'
And user typed several character in city input field: '@#$%^&*'
Then following message is displayed in City input field: 'Use Latin or Cyrillic to enter the city. Apostrophe, hyphen and space can be used.'


Scenario: Verify the “Save” button is inactive

Given user opened 'Authorization Page' by url: 'DEV_WELTRADE_CAB_LOGIN_URL'
When user tries to sign in to Weltrade site , using following info:
| email                | password |
| mtuser30@hotmail.com | 8ZO3JHC1 |
And user closed the T2W banner
And user opened 'Settings Page'
And user typed 51 characters in city input field:
| city                                                |
| IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII |
Then the 'Save' button is inactive
And the 'Save' button is inactive with the introduction of spaces:
| city |
|      |