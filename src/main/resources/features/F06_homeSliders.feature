@smoke
  Feature: F06_homeSliders | clicking on product slider redirecting user to the product page
    Scenario Outline: user could go to product page when click on its slider
      When user clicks on slider <number>
      Then assert that the page link is equal to "<link>" as actual link
      Examples:
        | number | link |
      |  0      |https://demo.nopcommerce.com/galaxy-s22-ultra|
      |    1    |https://demo.nopcommerce.com/iphone-14-pro|

