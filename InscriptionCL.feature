#Author: Djedidi Ismail

@feature
Feature: Creation compte candidat libre

  @connexionCand
  Scenario: Se Rendre Sur La Page Authentication Candidat
    Given Je connecte au front candidat
    When je clique sur le boutton dinscription
    Then Je suis sur la page de creation dun compte candidat libre

  @CreationCompteCL
  Scenario Outline: Creation Compte CL
    Given je suis sur la page de creation de compte CL
    When je saisis le "<nom>", le "<neph>" et l"<adresseEmail>"
    Then je clique sur valider
      Examples:
        |nom|neph|adresseEmail|
        |AADQELFIYY|111134301630|AADQELFIYY@talan.Com|
        |AACWVQFCHQT|100730100052|AACWVQFCHQT@talan.Com|

  @recupExcel
  Scenario: Recuperer un fichier excel avec les jeux des données
    Given je charge le fichier "jeuxdonnees.csv"
    When je selectionne le "nom", le "neph" et l"adresseEmail"
    And je vais dans la page de creation de compte CL
    Then je valide mon form avec les données recuperees

  @VerifMail
  Scenario: Verifier la creation de compte sur maildev
    Given je me connecte sur le site de maildev
    When je selectionne le mail de creation de compte
    Then je verifie les informations de l inscription candidat