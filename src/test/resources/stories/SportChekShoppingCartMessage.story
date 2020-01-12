Meta:
@sportchek_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: User is able to see the shopping cart message

Given user opened site, using next url: 'https://www.sportchek.ca/'
When user moved the mouse to shopping cart
Then following the shopping cart message is displayed: 'YOUR SHOPPING CART IS CURRENTLY EMPTY.'