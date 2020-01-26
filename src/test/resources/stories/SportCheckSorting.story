Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to sort the product

Given user opened Sportcheck site using following url: 'https://www.sportchek.ca/categories/shop-by-sport/alpine-skiing/ski-packages.html?lastVisibleProductNumber=22'
When user chooses 'Rating High to Low' in dropdown SORT BY
Then products are sorted by the number of stars