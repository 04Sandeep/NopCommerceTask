Feature:

  Scenario: User is searching the products
  Given    User redirect to Home Page and go to signup page
  When     user enter valid login credentials
  Then     user searching the products
  And      verify the product
  And      user logout the page