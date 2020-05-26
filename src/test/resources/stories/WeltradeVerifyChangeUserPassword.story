Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to change user password in Settings

Given user opened 'Authorization Page' by url: 'PROD_WELTRADE_CAB_LOGIN_URL'
When user tries to sign in to Weltrade site , using following info:
| email                   | password |
| olhahrynko767@gmail.com | 123qaz   |
And user closed the T2W banner
And user opened 'Settings Page'
And user opened 'Settings Page Authorization' by url: 'PROD_WELTRADE_CAB_LOGIN_URL'
And user tries to typed passwords, using following info:
| validPassword | newPassword | repeatNewPassword |
| 123qaz        | IS5FyJgv    | IS5FyJgv          |
Then following success toast displayed on the page Settings: 'Password changed'

