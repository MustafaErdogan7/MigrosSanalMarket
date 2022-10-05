@cases
Feature: Sanalmarket


  @peachProductsPageCase
  Scenario: Sanalmarket - Peach Page
    Given Go to 'https://www.migros.com.tr'
    Then Do screen settings
    Then Set current location
    Then Search text and Submit
    Then Select two brands randomly
    Then Click last product on product page
    Then Go to cart
    Then Compare products