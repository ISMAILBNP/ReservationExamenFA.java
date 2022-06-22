package fr.mi.rdvp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class RevocationMandat extends ConnexionCandidat {

    @Given("Je me connecte au F candidat")
    public void connecting_candidat() throws InterruptedException {
        createBrowser();
        je_veux_me_connecter_a_Rdv_Permis_en_tant_que_candidat();
    }

    @When("J insere mes identifiants")
    public void indetifiants() throws InterruptedException {
        Thread.sleep(3000);
        dr.findElement(By.id("username")).sendKeys("pfd@gmail.com");
        dr.findElement(By.id("password")).sendKeys("GyAhKWn170agWf~5");
        Thread.sleep(60000);
        dr.findElement(By.id("kc-login")).click();
    }

    @And("J appuye sur le boutton supprimer mon mandat")
    public void supprimer_mandat() throws InterruptedException {
        Thread.sleep(3000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div[2]/div[2]/div[2]/button")).click();
    }

    @Then("j appuye sur le boutton oui je supprime mon mandat")
    public void oui_supprimer_mandat() throws InterruptedException {
        Thread.sleep(3000);
        dr.findElement(By.xpath("//*[@id=\"react-aria-modal-dialog\"]/div/div[4]/button[2]")).click();
        Thread.sleep(5000);
    }

    @Given("je me connecte sur maildev revoc mandat")
    public void connecte_maildev_revoc() throws InterruptedException {
        dr.get("https://admin:F7lf34Tl4CeXLIwz9hpC9ksfU@maildev.rie.recette.rdvp.programme-erpc.fr/");
        Thread.sleep(2000);
    }

    @When("je selectionne le mail de revocation de mandat candidat")
    public void selectionne_mail_mandat_revoc() {
        dr.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[1]/a")).click();

    }

    @And("je trouve les informations de ma revocation de mandat candidat")
    public void verifier_informations_mail_revoc() throws InterruptedException {
        Thread.sleep(2000);
        String expectedText = "R\u00e9vocation du mandat d\u0027inscription \u00e0 l\u0027examen pratique par le candidat";
        String actualText = dr.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='testmailcd2910+ae-03119150@gmail.com'])[1]/preceding::span[1]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @Then("je trouve les informations de ma revocation de mandat candidat ae")
    public void verifier_informations_mail_revoc_ae() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[2]/a/span[1]")).click();
        Thread.sleep(2000);
        String expectedText = "R\u00e9vocation du mandat d\u0027inscription \u00e0 l\u0027examen pratique par le candidat";
        String actualText = dr.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='pfd@gmail.com'])[1]/preceding::span[1]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }


}