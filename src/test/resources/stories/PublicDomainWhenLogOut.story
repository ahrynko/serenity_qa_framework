Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: verify the correct public domain when log out [KM]

Given user opened 'Authorization Page' by url: 'PROD_WELTRADE_CAB_LOGIN_URL'
When user tries to sign in to Weltrade site , using following info:
| email                   | password |
| olhahrynko767@gmail.com | 123qaz   |
And user closed the T2W banner
And user clicks 'Log out'
Then following current Url Page displayed: 'https://kh.weltrade.com/'