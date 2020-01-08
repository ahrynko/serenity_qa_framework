Meta:
@sportmaster_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to search item using searchbar

Given user opens page using following link: 'https://www.sportmaster.ua/'
When search for next item: 'fff'
Then following message is displayed : 'Пошук За запитом «fff» нічого не знайдено'