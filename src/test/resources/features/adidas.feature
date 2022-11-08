
@adidas
  Feature: User should be able to add and delete items to and from the cart

    Scenario: User should be able to place an order and delete items from the cart
      Given User navigates to the home page
      Then User navigates to the "Laptops" section and clicks on "Sony vaio i5"
      And User clicks on Add to cart and accepts the pop up confirmation
      And User navigates back to the home page and to the "Laptops" sections again and clicks on "Dell i7 8gb"
      And User clicks Add to cart and accepts pop up confirmation
      And User navigates to Cart section and deletes "Dell i7 8gb" from cart
      And User enters "Ostap Koziak" to name
      And User enters "Canada" to country
      And user enters "Toronto" to city
      And User enters "1111222233334444" to cardNumber
      And User enters "03" to month
      And User enters "2024" to year
      And Click on Purchase
      And Capture and log purchase Id and Amount.
      And Assert purchase amount equals expected.
      Then User clicks Ok




