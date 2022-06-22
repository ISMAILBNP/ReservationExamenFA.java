#Author: Djedidi Ismail

@Feature
Feature: Connexion sur le Front candidat
  En tant que candidat, je veux mauthentifier sur le front candidat

  @connexionCandidat
  Scenario: Connexion sur le Front candidat
    Given je veux me connecter a Rdv Permis en tant que candidat
    When je renseigne mon identifiant C
    And je renseigne mon mot de passe C
    And je clique sur le bouton Valider C
    Then mon nom est affiche en haut a gauche

