Meta:
@sportchek_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: User is able to see the predictive search list

Given user opened site, using url: 'https://www.sportchek.ca/'
When user typed to search for next item: 'Nike'
Then retrieved item at list contains the word: 'NIKE'