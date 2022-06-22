@tag
Feature: Connexion sur le Front repartiteur
  En tant que repartiteur, je veux mauthentifier sur le front repartiteur

  @connexionFR
  Scenario: Connexion sur le Front repartiteur
    Given je veux me connecter a Rdv Permis en tant que repartiteur
    When je renseigne mon identifiant
    And je renseigne mon mot de passe
    And je clique sur le bouton Valider
    Then mon nom est affiche en haut a droite