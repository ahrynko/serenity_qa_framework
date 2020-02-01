Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to sort the product

Given user opened 'Alpine Skiing Page'
When user clicks Sort By dropdown
And user clicks 'Rating High to Low' in SORT BY dropdown
Then products are sorted by the number of stars