@ReservationExamenCL
Feature: Reservation Examen CL

  @ReservationExamenCL_part_1
  Scenario: ReservationExamenCL
    Given Je connecte sur le front candidat
    When je clic sur le boutton reserver un examen
    Then j insere le numero du departement
    And j appuye sur le boutton rechercher
    And je clique sur un centre
    And je clique sur un creneau d examen
    And j appuye sur le boutton poursuivre la reservation
    And j insere le nom,prenom,neph,date de delivrence
    And j appuye sur poursuivre la reservation
    And je coche les deux cases
    Then j appuye sur confirmer la reservation

  @prisemandat_part_2
  Scenario: Verifier la reservation examen CL sur maildev
    Given je me connecte sur maildev CL
    When je selectionne le mail de reservation d'examen CL
    Then je trouve les informations de mon examen CL