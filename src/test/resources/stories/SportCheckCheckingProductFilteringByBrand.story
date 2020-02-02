Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to product filtration by brand

Given user opened 'Alpine Skiing Page'
When user chooses 'ATOMIC' brand at the product list
Then products are only displayed with this brand: 'ATOMIC'