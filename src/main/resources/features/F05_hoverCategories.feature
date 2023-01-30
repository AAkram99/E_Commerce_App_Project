@smoke
  Feature:
    Scenario:
      When user hovers on random main category
      And user hovers on random sub category
      And get text of the subCategory
      And click on it
      Then Assert that the page title is the same text you get from subCategory
