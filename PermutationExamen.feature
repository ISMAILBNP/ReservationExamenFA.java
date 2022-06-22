@Feature
Feature: PermutationExamen

  @Permutationexamen
  Scenario: Permutation examen sur une journee
    Given je me connecte sur le front AE
    When Je selectionne mon planning
    And je selectionne une catPermis un departement, un centre et une date
    And je clique sur un premier creneau
    And Je clique sur permuter le candidat1
    And je selectionne la date du jour et le creneau du jour a permuter
    Then je clique sur permuter l'examen du jour

  Scenario: Permutation examen sur une semaine
    Given Je suis sur la page de planification creneau du BER
    When Je clique sur permuter le candidat2
    And je selectionne la date du semaine
    And je selectionne le creneau du semaine a permuter
    Then je clique sur permuter l'examen du semaine

  Scenario: Verfication de la permutation cote BER
    Given je me connecte sur le front BER
    When je clique sur mon premier creneau
    And je clique sur mon deuxieme creneau
    Then les deux creneaux on ete permutee avec succes

  Scenario: Verfication de la permutation cote maildev
    Given Je connecte sur mail dev
    When je selectionne le mail de la permutation de l examen du candidat1
    And je verifie les informations de la premiere permutation
    And  je selectionne le mail de la permutation de l examen du candidat2
    Then je verifie les informations de la deuxieme permutation