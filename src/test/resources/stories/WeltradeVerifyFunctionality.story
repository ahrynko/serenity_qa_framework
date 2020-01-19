Meta:
@weltrade_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify Weltrade site title in personal area cabinet

Given user opened Weltrade site, by following url: 'https://www.weltrade.com/'
When user clicks 'Login' button
And user tries to sign in to Weltrade site , using following info:
| email         | password |
| test_uk@bk.ru | 123qaz   |

Then user retrieved Weltrade site title
And retrieved Weltrade site title value should be: 'Personal area controls - WELTRADE'