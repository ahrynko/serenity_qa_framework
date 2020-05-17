Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to delete new Premium trade account

Given user opened 'Authorization Page' by url: 'DEV_WELTRADE_CAB_LOGIN_URL'
When user tries to sign in to Weltrade site , using following info:
| email                | password |
| mtuser30@hotmail.com | 8ZO3JHC1 |
And user closed the T2W banner
And user opened 'New Account Page'
And user opened new Premium trade account
And user opened 'Accounts Page' by url: 'DEV_WELTRADE_CAB_LOGIN_URL'
And user closed the T2W banner
And user tries to reset filter the trade accounts
And user deleted new Premium trade account
Then following message to accounts information displayed: 'You do not have any trading accounts'
