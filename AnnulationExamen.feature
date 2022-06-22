#Author: Djedidi Ismail

@Feature
Feature: Annulation examen

  En tant que inspecteur

  Je veux pouvoir connecter sur mon profil FR

  Afin d'annuler des examens

  @Annulation
  Scenario: Annuler un examen
    Given je suis sur le planning
    When  Je selectionne un creneau reserve
    And Je clique sur annuler
    Then l'examen est annule et le creneau redevient indispo

  @Maildev_annulation_ber
  Scenario: Verifier la reservation examen BER sur maildev
    Given je me connecte sur maildev BER
    When je selectionne le mail de reservation d'examen BER
    And je trouve les informations de mon examen BER AE
    Then je trouve les informations de mon examen BER Candidat