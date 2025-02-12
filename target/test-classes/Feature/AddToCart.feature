Feature: BookBazzar Application Demo

  Scenario Outline: Add to Cart should be success
    Given user should be login by "<UserName>" and "<Password>"
    And user search a "<Book>"
    When user add the book in cart
    Then cart count will updated

    Examples: 
      | UserName   | Password  | Book                    |
      | 8667864738 | Yogesh123 | Pop Out Under the ocean |
      | 8667864738 | Yogesh123 | Pop Out Dinosaurs World |
@smoke
    Examples: 
      | UserName   | Password  | Book                     |
      | 8667864738 | Yogesh123 | STEM Activity Books-Math |
