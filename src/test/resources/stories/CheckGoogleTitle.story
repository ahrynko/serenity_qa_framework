Narrative:

In order to verify Google site
As a user
I want to see Google main page opened correctly

Scenario: Verify Google main page title

Given user opens Google site, using following link https://www.google.com
When register new user with next data:
|name |mail        |phone  |age|
|Tania|t11@mail.com|2244455|22 |

Then the site opened with next title <expectedUrl>
And 'Google'label should be displayed

Examples:
| siteUrl                  | expectedUrl |
| https://www.google.com   | Google      |
| https://www.google.com   | Google_1    |