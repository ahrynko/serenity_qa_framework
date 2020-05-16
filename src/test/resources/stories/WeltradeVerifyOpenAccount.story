Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to open new Premium trade account

Given user opened 'Authorization Page' by url: 'DEV_WELTRADE_CAB_LOGIN_URL'
When user tries to sign in to Weltrade site , using following info:
| email         | password |
| test_uk@bk.ru | 123qaz   |
And user closed the T2W banner
And user opened 'New Account Page'
And user opened new Premium trade account
Then new Premium trade account opened with correct params