Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to search of the nearest none-existent store

Given user opened page Sportcheck site using following url: 'https://www.sportchek.ca/'
When user clicks 'Choose store now' button
And user typed the one store, in modal input field:
| store |
| ROME  |

Then following error displayed at modal choose input: 'We're sorry, there are no stores near your location. Please try reentering location'
