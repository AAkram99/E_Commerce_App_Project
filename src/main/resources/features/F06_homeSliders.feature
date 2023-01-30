@smoke
  Feature:
    Scenario Outline: test the two sliders on the home page
      When user clicks on slider <number>
      Then assert that the page link is equal to "<link>" as actual link
      Examples:
        | number | link |
      |  0      |https://demo.nopcommerce.com/galaxy-s22-ultra|
      |    1    |https://demo.nopcommerce.com/iphone-14-pro|

