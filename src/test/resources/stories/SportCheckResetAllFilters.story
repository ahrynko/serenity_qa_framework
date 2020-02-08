Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Check the ability to reset all filters by clicking the Clear All button

Given user opened 'Alpine Skiing Page'
When user chooses 'TECNO PRO' filter brand at the product list
Then products are filtered by the specified filter: 'TECNO PRO'
And user clicks on the 'Clear All' button
Then all filters by product were reset
