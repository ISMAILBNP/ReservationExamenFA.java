@AnnulationExamenFA
Feature: AnnulationExmamenFA

  @AnnulationExamenFA_1
  Scenario: Annulation Examen FA
    Given Je me connecte sur le front ae
    When Je selectionne le planning
    And je selectionne une catPermis un departement, un centre, une date
    And je selectionne un examen
    Then je clic sur annuler l examen

  @AnnulationExamenFA_2
  Scenario: Verification mail dev annulation
    Given Je connecte sur mail dev
    When je selectionne le mail d annulation d examen
    Then je trouve les informations de l examen annule