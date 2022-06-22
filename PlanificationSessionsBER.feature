@Feature
Feature: Planification sessions BER

  @PlanificationsessionsBER
  Scenario: Planifications sessions BER
    Given je connecte sur le portail repartiteur
    When je selectionne le menu de planification des sessions
    And Je selectionne un inspecteur et un centre
    And je selectionne la tranche horaire de la session
    And j appuye sur le boutton planifier les sessions
    Then les sessions sont crees dans le menu planifier les sessions