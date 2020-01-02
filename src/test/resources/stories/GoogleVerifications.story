Meta:
@google_tests

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify Google site title

Given user opened following url: 'https://www.google.com.ua/'
When user retrieved site title
Then retrieved title value should be: 'Google'