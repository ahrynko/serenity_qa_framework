Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to create new Post to profile (DELETE + POST)

Given user removes Id to API Resources profile
And user creates new 'POST', using API to profile:
| name  | tel      | email                       |
| Borys | 80080020 | kipasurrun-8900@yopmail.com |
Then new POST should be created to profile

Scenario: Verify user is able to update existing Post  to profile (POST + PUT + GET)

Given user creates new 'POST', using API to profile:
| name | tel      | email                       |
| Ivan | 80080020 | kipasurrun-1200@yopmail.com |
When user update existing post to profile, using following data:
| name | tel      | email                   |
| Oleh | 80011111 | google-4500@yopmail.com |
Then current following post should be updated to profile

Scenario: Verify user is able to filter all Comments, by filter data ( 3 POST + GET (getByQueryParams))

Given user creates new 'POST', using API to profile:
| name | tel       | email            |
| Hans | 044545457 | test9999@ukr.net |
And user creates new 'POST', using API to profile:
| name  | tel    | email              |
| JAN I | 111111 | kip789@yopmail.com |
And user creates new 'POST', using API to profile:
| name  | tel    | email              |
| JAN I | 111111 | kip789@yopmail.com |

When user filters retrieved Prifile  by next filter params:
| tel    | email              |
| 111111 | kip789@yopmail.com |
Then each filtered POST should be contains only the following data:
| tel    | email              |
| 111111 | kip789@yopmail.com |