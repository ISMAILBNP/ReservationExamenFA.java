@Prisesousmandat
Feature: Prise sous mandat
  Je veux prendre un candidat sous mandat sur le front auto ecole

  @prisemandat_part_1
  Scenario: Prise sous mandat
    Given Je me connecte sur le front auto ecole
    When je selectionne le menu mes candidats
    And j appuye sur le bouton prendre sous mandat
    And j insere le nom et le neph et cat permis
    And clic sur prendre sous mandat
    And j insere le mail
    And clic sur informer le candidat
    Then le candidat est pris sous mandat

  @prisemandat_part_2
  Scenario: Verifier la prise sous mandat sur maildev
    Given je me connecte sur maildev
    When je selectionne le mail de prise sous mandat
    Then je trouve les informations de la prise sous mandat