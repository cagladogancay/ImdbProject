Feature: Seçilen filmin bilgilerinin doğrulanması

  Scenario: Menüden Bulunan Filmle Arama Çubuğu Üzerinden Bulunan Film Özellikleri Aynı Olmalıdır
    Given "https://www.imdb.com" adresine gidilir
    When Arama çubuğunun sol tarafında bulunan Menü butonuna basılır
    And   Award & Events başlığı altında bulunan Oscars butonuna basılır
    And   “Event History” başlığı altında 1929 değeri seçilir
    And    “Honorary Award” başlığı altında “Caz Mugannisi” seçilir
    Then   Director ismi "Alan Crosland"
    And    Writer ismi "Samson Raphaelson"
    And    Stars  ismileri "Al Jolson"