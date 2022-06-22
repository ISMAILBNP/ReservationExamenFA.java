@Feature
Feature: Publication_Creneaux
  En tant que inspecteur
  Je veux pouvoir connecter sur mon profil
  Afin de publier des creneaux dispo AE, indisponible, dispo CL

  @connexion
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

  @creneaux
  Scenario: verification creneaux
    Given Que je suis sur le planning de l'inspecteur selectionne
    When  Je clique sur un creneau de la journee inspecteur
    And Je passe le creneau au statut indisponible
    And Je choisis un autre creneau et je le rend disponible CL
    Then Je visualise le planning avec les different types de creneaux

  @publication
  Scenario: publication creneaux
    Given Que je suis sur le planning de l'inspecteur selectionne
    When  Je clique sur le bouton rendre visible
    Then Je visualise le libelle du bouton est passe a visible