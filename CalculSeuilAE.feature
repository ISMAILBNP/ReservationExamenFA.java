@feature
Feature: Calcul seuil AE

  @CalculSeuilAE
  Scenario: Calcul seuil AE
    Given Je connecte sur le font ae
    When je selectionne le planning de mon ae
    And je selectionne une date
    And je rajoute un creneau a mon panier
    And le seuil formateur est atteint
    And je supprime l'examen du panier
    Then le seuil n'est plus atteint