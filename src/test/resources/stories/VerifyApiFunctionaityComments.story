Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to create new Post to comments (DELETE + POST)

Given user removes Id to API Resources
And user creates new 'POST', using API:
| body                | author      | gender |
| Hello Hillel School | Alex Hrynko | M      |
Then new POST should be created

Scenario: Verify user is able to update existing Post  to comments (POST + PUT + GET)

Given user creates new 'POST', using API:
| body                                 | author    | gender |
| Learning Python Programming Language | Mark Lutz | M      |
When user update existing post to comments, using following data:
| body                               | author       | gender |
| Learning Java Programming Language | Kathy Sierra | W      |
Then current following post should be updated

Scenario: Verify user is able to filter all Comments, by filter data ( 3 POST + GET (getByQueryParams))

Given user creates new 'POST', using API:
| body         | author     | gender |
| Das sind wir | Ihrem Haus | W      |
And user creates new 'POST', using API:
| body                                                                    | author               | gender |
| Verbringen Sie und Ihre Familie herrliche Sommertage im schönen Allgäu. | FERIENDOMIZIL MÜLLER | M      |
And user creates new 'POST', using API:
| body                                                                    | author               | gender |
| Verbringen Sie und Ihre Familie herrliche Sommertage im schönen Allgäu. | FERIENDOMIZIL MÜLLER | M      |

When user filters retrieved Comments  by next filter params:
| body                                                                    | gender |
| Verbringen Sie und Ihre Familie herrliche Sommertage im schönen Allgäu. | M      |
Then each filtered POST should contains only the following data:
| body                                                                    | gender |
| Verbringen Sie und Ihre Familie herrliche Sommertage im schönen Allgäu. | M      |
