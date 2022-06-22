@ReservationExamenFA
Feature: ReservationExamenFA

  @ReservationExamenFA_1
  Scenario: Reservation examen fa
    Given Je me connecte sur le front ae
    When Je selectionne mon planning
    And je selectionne une catPermis un departement, un centre et une date
    And je clic sur un creneau
    And j insere le neph
    Then l examen est reserve

  @ReservationExamenFA_2
  Scenario: Verification maildev reservaton examen
    Given je connecte sur maildev
    When je selectionne le mail de reservation d examen
    Then je trouve les informations de l examen
