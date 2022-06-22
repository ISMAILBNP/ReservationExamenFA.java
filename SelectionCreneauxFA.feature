@SelectioncréneauxFA
Feature: SelectioncreneauxFA

  @SelectionCreneauxFA_1
  Scenario: SelectionCreneauxFA
    Given Je me connecte sur le front auto ecole1
    When Je selectionne le menu mon planning
    And je selectionne une catPermis, un departement, un centre et une date
    And je clique sur un creneaux
    Then je vois le creneau disponible AE