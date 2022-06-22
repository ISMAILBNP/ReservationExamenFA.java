@PermutationInspecteurs
Feature: Permutation Inspecteurs

  @permutationinspecteurs
  Scenario: Permutation Inspecteurs
    Given Je me connecte sur le front BER
    When je selectionne l'inspecteur et la date
    And je clique sur l'icone de l'inspecteur
    And je selectionne l'inspecteur avec qui je veux permuter
    And je valide la permutation
    Then les inspecteurs sont permutes