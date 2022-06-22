@RemplacementCandidat
Feature: RemplacementCandidat

  @RemplacementCandidat_1
  Scenario: Remplacement Candidat
    Given Je me connecte sur le front ae
    When Je selectionne le planning
    And je selectionne une catPermis un departement, un centre, une date
    And je selectionne un examen a remplacer
    And je clic sur remplacer le candidat
    And J insere le NEPH du nouveau candidat
    And j appuye sur le bouton remplacer le candidat
    Then le candida est remplace

  @RemplacementCandidat_2
  Scenario: Verification mail remplacement
    Given Je connecte sur mail dev
    When je selectionne le mail de l annulation de l examen du candidat remplace
    And je verifie les informations de l annulation
    And  je selectionne le mail de la convocation du candidiat remplacant
    Then je verifie les informations de la convocation