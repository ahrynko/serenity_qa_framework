Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Check the ability to search by articles on the site https://edition.cnn.com

Given user opened site 'https://edition.cnn.com'
When user search the site for next item: 'China'
And user retrieved items to list with site
And user executed Rest Request with the same word
Then compared two List with site and Rest Request