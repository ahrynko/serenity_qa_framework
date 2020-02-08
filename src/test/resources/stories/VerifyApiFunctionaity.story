Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify user is able to create new Post

Given user creates new 'Post', using API:
| title              | author               | age |
| Hello From JBehave | Test Automation User | 30  |
Then new post should be created
