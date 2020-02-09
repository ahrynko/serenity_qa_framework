Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify the possibility of adding product to shopping cart

Given user opened 'Columbia Boys' Sandy Shores Boardshort' by url: 'SPORTCHEK_BASE_URL'
When user chooses (random) size
And user clicks 'Add To Cart' button
Given user opened 'Shopping Cart Page' by url: 'SPORTCHEK_BASE_URL'
Then the product your added is in the shopping cart