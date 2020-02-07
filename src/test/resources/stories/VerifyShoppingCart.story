Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify empty Shopping Cart message

Given user opened 'Shopping Cart Page' by url: 'SPORTCHEK_BASE_URL'
Then following empty cart message displayed: 'Shopping cart is empty'
