Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Parse by articles (title,body) on the site https://edition.cnn.com

Given user opened site 'https://edition.cnn.com'
When user search the site for next item: 'covid'
And user retrieved all articles to list with site
And user printed the text of each articles in the console with site
Then user parsed and printed the text of each article in the console with Jsoup library