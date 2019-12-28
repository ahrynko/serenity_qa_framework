Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: User is able to search the tickets by criteria
Given user opens site: 'https://www.fly.com/'
When user is searching for tickets by next criteria
| From                          | To                    | Direction | date          |
| Kiev, Ukraine - Borispol Intl | Adana, Turkey - Adana | Roundtrip | 20, May, 2019 |
Then system is in a different state