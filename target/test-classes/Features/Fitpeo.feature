Feature: Interacting with the Revenue Calculator on FitPeo Homepage

  Scenario: Adjusting the Revenue Calculator and verifying total recurring reimbursement
    Given I navigate to the FitPeo Homepage
    When I navigate to the Revenue Calculator Page
    And I scroll down to the Slider section
    #And I adjust the slider to set its value to 820
    When I click on the text field and enter the value 560
    #Then the slider's position should be updated to reflect the value "560"
    #And I select the checkboxes for "CPT-99091", "CPT-99453", "CPT-99454", and "CPT-99474"
    #Then the header displaying "Total Recurring Reimbursement for all Patients Per Month" should show "$110700"
    #And User closes the browser
    