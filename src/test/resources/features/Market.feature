Feature: Product Search and Add to Cart


  @Functionality1227
  Scenario: User searches for a product and adds it to the cart
    Given user launched website
    When User searches for "Tomato" in the search bar
    Then User should see "Tomato" in the product list
    When User adds the product to the cart
    Then The cart should display 1 item

  @Functionality271227
  Scenario: User increases product quantity before adding to the cart
    Given user launched website
    When User searches for "Cucumber" in the search bar
    And User increases the quantity to 3
    And User adds the product to the cart
    Then The cart should display 3 item


