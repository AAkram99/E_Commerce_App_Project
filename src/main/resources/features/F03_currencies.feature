@smoke
  Feature: F03_currencies | The Euro symbol appears beside the price when Euro is selected from  currencies list
    Scenario: Euro could be selected form currencies list
      When select Euro currency from the dropdown list on the top left of home page
      Then verify Euro Symbol (€) is shown on the four products displayed in Home page