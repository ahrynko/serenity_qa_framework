Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to product filtration by brand

Given user opened Sportcheck site using following url: 'https://www.sportchek.ca/categories/shop-by-sport/alpine-skiing/ski-packages.html?lastVisibleProductNumber=22'
!-- When user chooses 'Filter By' product-listing
When user chooses 'ATOMIC' brand at the product list
Then products are only displayed with this brand: 'ATOMIC'