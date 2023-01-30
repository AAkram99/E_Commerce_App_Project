@smoke
  Feature:F04_search | user could use search feature with different inputs
    Scenario Outline: user could search using product name
      When user enter "<ProductName>" as search parameter
      And user clicks on search button
      Then verify that the search page is opened and result contains the "<ProductName>" word
      Examples:
        |ProductName|
        |book|
        |laptop|
        |nike|



    Scenario Outline: user could search using sku
      When user enter "<sku>" as search parameter
      And user clicks on search button
      And user clicks on the product in search page
      Then verify that the sku in the product page is the same "<sku>" you entered
      Examples:
        |sku|
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|