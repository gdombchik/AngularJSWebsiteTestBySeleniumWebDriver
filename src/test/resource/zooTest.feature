Feature:  To test the high level functionality of the Zoo site

Background:  
	Given I am on the zoo site

@tagForZoo
Scenario:  To populate the contact form
	When I click on "Contact"
	#And I enter "Name test" into the name field
	#And I enter "Address test" into the address field 
	#And I enter "Postcode test" into the postcode field
	#And I enter "Email test"  into the email field
	And I populate the form
	    | Field | Value                    |
      | name  | Name test         |
      | address | Address test |
      | postcode | Postcode test |
      | email | Email test |
	And I submit the contact form
	Then I check I am on the confirmation page
	And I close the browser