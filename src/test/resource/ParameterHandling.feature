Feature:  To check that main tutorial course pages have loaded in TheTestRoom.com

@ParameterHandling
Scenario Outline:  To check that the links on the main page has loaded
Given I navigate to TheTestRoom.com
When I navigate to <link> page
Then The <title> should be visible
Then Display random data
|v1|v2|
|first name|John|
|last name|Doe|
	
    Examples: 
      | link | title |
      #Test 1
      | Java WebDriver Tutorial | Java WebDriver Tutorial - The Test Room |
      #Test 2
      | Java Cucumber Tutorial | Java Cucumber Tutorial - The Test Room |