Feature: Başarılı film aramasının yapılması

  Scenario: The Jazz Singer film araması
    Given "https://www.imdb.com/" adresine gidilir
    When  Arama çubuğuna "The Jazz Singer" yazılır.
    And Sonuçlar arasında gelen The Jazz Singer tıklanır.
    Then   Director ismi "Alan Crosland"
    And    Writer isimleri
      | Samson Raphaelson |
      | Alfred A. Cohn    |
    And    Stars  isimleri
      | Al Jolson  |
      | May McAvoy |