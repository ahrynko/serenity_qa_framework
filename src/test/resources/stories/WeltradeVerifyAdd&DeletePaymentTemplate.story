Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Check the add payment template in Settings

Given user opened 'Authorization Page' by url: 'PROD_WELTRADE_CAB_LOGIN_URL'
When user clicks 'Login via Google' button
And user tries to login to Weltrade site via Google: 'olhahrynko767@gmail.com'
And user tries to login to Weltrade site: 'Werthrf77'
And user opened 'Settings Page Payment templates' by url: 'PROD_WELTRADE_CAB_LOGIN_URL'
And user closed the T2W banner
And user chooses QIWI Payment system with Purse number: '7999999999'
Then following success toast displayed on the page Payment templates: 'Payment instrument added'
And the template appeared in the list of added templates with the same information as when filling


Scenario: Check the delete payment template in Settings

Given user opened 'Authorization Page' by url: 'PROD_WELTRADE_CAB_LOGIN_URL'
When user clicks 'Login via Google' button
And user tries to login to Weltrade site via Google: 'olhahrynko767@gmail.com'
And user tries to login to Weltrade site: 'Werthrf77'
And user opened 'Settings Page Payment templates' by url: 'PROD_WELTRADE_CAB_LOGIN_URL'
And user closed the T2W banner
And user deleted QIWI Payment system template
Then following success toast displayed on the page Payment templates: 'Payment instrument deleted'
And the template was successfully deleted and does not appear in the list