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

Scenario: Verify errors displayed during user sign out with incorrect data, using Examples

Given user opened site using next url: 'https://www.sportchek.ca/'
When user clicks 'Sign In' button
And user clicks 'Register Now' button
And user tries to sign up, using following info:
| email        | confirmEmail        | password        | confirmPassword        |
| <emailParam> | <confirmEmailParam> | <passwordParam> | <confirmPasswordParam> |

Then following error displayed:
{transformer=FROM_LANDSCAPE}
| emailError           | <emailError>           |
| confirmEmailError    | <confirmEmailError>    |
| passwordError        | <passwordError>        |
| confirmPasswordError | <confirmPasswordError> |

Examples:
| emailParam | confirmEmailParam | passwordParam | confirmPasswordParam | emailError                                                       | confirmEmailError                                                | passwordError                               | confirmPasswordError                        |
| xx         | xx                | yy            | yy                   | Please enter your email address in this format: name@example.com | Please enter your email address in this format: name@example.com | Your password must be 8-40 characters long. | Your password must be 8-40 characters long. |
| e@exe      | name@example.om   | qaz           | qaz                  | Please enter your email address in this format: name@example.com | Email addresses must match.                                      | Your password must be 8-40 characters long. | Your password must be 8-40 characters long. |