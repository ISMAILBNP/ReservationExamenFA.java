package fr.mi.rdvp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class PermutationInspecteurs extends ConnexionFRSteps {
    @Given("Je me connecte sur le front BER")
    public void connecting_portail_rep() throws InterruptedException {
        createBrowser();
        je_veux_me_connecter_a_Rdv_Permis_en_tant_que_repartiteur();
        je_renseigne_mon_identifiant();
        je_renseigne_mon_mot_de_passe();
        je_clique_sur_le_bouton_Valider();
    }

    @When("je selectionne l'inspecteur et la date")
    public void je_selectionne_inspecteur_date() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("/html/body/div/div/main/div[2]/form/div/div[1]/div/div/div[1]/div[2]/div/input")).sendKeys("Pepe Carvalho");
        dr.findElement(By.xpath("/html/body/div/div/main/div[2]/form/div/div[1]/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
        dr.findElement(By.xpath("//*[@id=\"filtres-date\"]")).clear();
        dr.findElement(By.xpath("//*[@id=\"filtres-date\"]")).sendKeys("04/10/2021");
    }

    @And("je clique sur l'icone de l'inspecteur")
    public void je_selectionne_tranche_horaire() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div[1]/header/ul/li[3]/section/button/i")).click();
    }

    @And("je selectionne l'inspecteur avec qui je veux permuter")
    public void selection_inspecteur_a_planifier() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"react-aria-modal-dialog\"]/div/div/div[2]/section/div[3]/label/span/div")).click();
    }

    @And("je valide la permutation")
    public void valider_permutation() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"react-aria-modal-dialog\"]/div/div/div[3]/footer/div/button")).click();
    }

    @Then("les inspecteurs sont permutes")
    public void inspecteurs_valides() throws InterruptedException {
        Thread.sleep(2000);
        String expectedText = "Les journ\u00e9es d\u0027examen pour le 06/10/2021 de Pepe CARVALHO et UWFMDB AYXPOLSXAE ont bien \u00e9t\u00e9 permut\u00e9es.";
        String actualText = dr.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[3]/ul/li/div/div")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }
}