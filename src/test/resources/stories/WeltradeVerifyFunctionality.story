Meta:
@weltrade_tests

Narrative:
As a user
Verify errors displayed during user sign out with incorrect dataI want to perform an action
So that I can achieve a business goal

Scenario: Verify Weltrade site title in personal area cabinet (modify)

Given user opened Weltrade site, by following url: 'https://www.weltrade.com/'
When user clicks 'Login' button
And user tries to sign in to Weltrade site , using following info:
| email         | password |
| test_id@bk.ru | 123qaz   |

Then user retrieved Weltrade site title
And retrieved Weltrade site title value should be: 'Personal area controls - WELTRADE'


Scenario: Verify errors displayed during user sign up with incorrect data (modify)

Given user opened Weltrade site, by following url: 'https://www.weltrade.com/'
When user clicks 'Registration' button
And user tries to sign up to Weltrade  site , using following info:
| firstName | lastName | email | phoneNumber |
|           |          |       |             |

Then following errors displayed to site Weltrade:
| firstNameError  | lastNameError   | emailError      | phoneNumberError |
| Fill this field | Fill this field | Fill this field | Fill this field  |
