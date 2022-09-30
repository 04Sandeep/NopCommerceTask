Feature:

  Scenario:  User is buying the product
    Given    User goes to NopCommerce website
    When     user enter their valid login credentials
    Then     user adding the products to cart
    And      verify the buy product
    And      user will logout the page