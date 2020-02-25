Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify calculate Contract size to Demo account type AUDCAD tool with 5 lot

Given user opened 'Trading Calculator Page' by url: 'WELTRADE_BASE_URL'
When user chooses 'Demo' account type
And user chooses AUDCAD tool
And user typed to search input: '5 Lot'
And user chooses 1:10 Leverage
And user clicks 'Calculate' button
Then following displayed Contract size with value: '500000 AUD'