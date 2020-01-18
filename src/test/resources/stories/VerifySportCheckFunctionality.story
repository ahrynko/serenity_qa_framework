Meta:
@sportchek_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: User is able to see the burger menu items

Given user opened site using next url: 'https://www.sportchek.ca/'
When user clicks burger menu button
Then following menu items are displayed: 'Deals & Features, Men, Women, Kids, Footwear, Gear, Electronics, Jerseys & Fan Wear, Vitamins & Supplements, Brand'

Scenario: Verify errors displayed during user sign out with incorrect data

Given user opened site using next url: 'https://www.sportchek.ca/'
When user clicks 'Sign In' button
And user clicks 'Register Now' button
And user tries to sign up, using following info:
| email | confirmEmail | password | confirmPassword |
| xx    | xx           | yy       | yy              |

Then following error displayed:
{transformer=FROM_LANDSCAPE}
| email           | 'Please enter your email address in this format: name@example.com' |
| confirmEmail    | 'Please enter your email address in this format: name@example.com' |
| password        | 'Your password must be 8-40 characters long.'                      |
| confirmPassword | 'Your password must be 8-40 characters long.'                      |