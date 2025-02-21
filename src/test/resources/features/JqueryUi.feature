Feature: Different Functonality test


  Background:
    Given user launched website

  @Functionality
  @Functionality1
  Scenario: Verify user is able drag and drop

    And user Drags and drops

  @Functionality
  @Functionality2
  Scenario: Verify user is able Resize
    And user Resize


  @Functionality
  @Functionality3
  Scenario Outline: Verify user is able to select dates from calendar
    And user selects Date from calendar "<Date>" and "<Year>" and "<Month>
    Examples:
      | Date | Year | Month |
      | 19   | 2026 | May     |
      | 25   | 2027 | March |

  @Functionality
    @Functionality4
  Scenario: Verify user is able to select dates from calendar using datatable
    And user selects Date from calendar using datatable
      | Date | Year | Month |
      | 20   | 2025 | June  |
      | 27   | 2026 | March |

