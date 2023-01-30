@smoke
 Feature: F08_Wishlist | Adding products to wishlist
   Scenario: user could click on heart button to add product to the wishlist
     When user clicks on heart button of product
     Then success message is displayed with green background

     Scenario: user could see the added products in the wishlist
       When user clicks on heart button of product
       And user clicks on wishlist button on top of home page
       Then the added product should be found in the wishlist