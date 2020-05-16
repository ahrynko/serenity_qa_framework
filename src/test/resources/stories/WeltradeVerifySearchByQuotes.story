Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Check the ability to search by quotes on the site https://ru.weltrade.com/tools/quotes/

Given user opened 'Currency Quotes Page' by url: 'WELTRADE_PUB_QUOTES_URL'
When user retrieved quotes to list with site
And user executed Rest Request with the same quotes.json
Then compared two List with site and With Rest Request