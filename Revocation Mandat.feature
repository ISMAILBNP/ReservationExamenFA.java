@RevocationMandat
Feature: Revocation mandat

  @RevocationMandat_1
  Scenario: Revocation mandat
    Given Je me connecte au F candidat
    When J insere mes identifiants
    And J appuye sur le boutton supprimer mon mandat
    Then j appuye sur le boutton oui je supprime mon mandat

  @Revocationmandat_2
  Scenario: Verifier la revocation de mandat sur maildev
    Given je me connecte sur maildev revoc mandat
    When je selectionne le mail de revocation de mandat candidat
    And je trouve les informations de ma revocation de mandat candidat
    Then je trouve les informations de ma revocation de mandat candidat ae