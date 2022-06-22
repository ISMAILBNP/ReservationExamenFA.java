#Author: Djedidi Ismail

@Feature
Feature: Réservation examen

  En tant que inspecteur

  Je veux pouvoir connecter sur mon profil FR

  Afin de réserver des examens

  @connexionFR
  Scenario: Connexion sur le Front repartiteur
    Given je veux me connecter a Rdv Permis en tant que repartiteur
    When je renseigne mon identifiant
    And je renseigne mon mot de passe
    And je clique sur le bouton Valider
    Then mon nom est affiche en haut a droite

  @selection
  Scenario: Selection d'inspecteur
    Given Que je suis sur le menu d'inspecteur dans le menu deroulant
    When  Je selectionne mon inspecteur
    And Je choisis le type de categorie de permis
    And Je saisis la date et je clique sur entree
    Then Je visualise le planning de l inspecteur a une date donnee

  @réservation
  Scenario: reserver un examen
    Given Que je suis sur le planning
    When  Je selectionne un creneau
    And Je saisis le nom du candidat et je valide
    Then Je visualise la prise en compte de mon examen

#  @VérificationRéservationSurAE
#  Scenario: Vérfier la réservation sur AE
#    Given Que je suis sur la page de connexion AE
#    When  Je saisis l'adresse email, le mdp et je valide
#    And Je selectionne la categorie de permis et jy vais sur le jour de reservation
#    Then Je visualise la prise en compte de mon examen sur le planning AE

  @CheckMailDev
  Scenario: Verifier l'email de convocation d'examen
    Given Que je suis sur maildev
    When  Je cherche la convocation de mon candidat
    And Je clique sur l'email
    Then Je visualise l'email de convocation
    