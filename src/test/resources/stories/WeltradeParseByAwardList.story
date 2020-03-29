Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Parse by articles (title,body) on the site https://www.weltrade.com

Given user opened 'Our Awards' by url: 'WELTRADE_BASE_URL'
When user retrieved all awards to list with site
And user parsed and printed the text of each award articles in the console with Jsoup library
And user printed the text of each award articles in the console with site
Then user compared two List with site and with Jsoup library
