@feature
Feature: declaration formateurs BER

  @declarationformateurs
  Scenario: declaration de formateurs BER
    Given Je connecte sur le font repartiteur
    When je selectionne le menu gerer les auto ecoles
    And j insere l id aurige de l'auto ecole
    And j'appuye sur le boutton modifier le nombre de formateurs
    And je declare le departement et le nombre de formateurs de l'auto ecole
    And j appuye sur le boutton valider les modifications
    And je declare le nombre de formateurs pour une nouvelle auto ecole
    And je selectionne le menu suivre lactivite
    And je change le coefficient formateur
    Then le coefficient formateur est change

  @declarationformateursAE
  Scenario: declaration de formateurs AE
    Given Je connecte sur le font autoecole
    When je selectionne le menu mes capacites de reservation
    Then je declare le departement et le nombre de formateurs pour la premiere fois