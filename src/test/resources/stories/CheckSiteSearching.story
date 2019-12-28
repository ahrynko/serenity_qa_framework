Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to search item using searchbar
Given user opens page using following link: 'https://www.sportmaster.ua/ru/'
When search for next item: 'ff'
Then following message is displayed : 'Поиск По запросу «ff» ничего не найдено'