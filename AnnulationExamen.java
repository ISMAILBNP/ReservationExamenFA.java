package fr.mi.rdvp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AnnulationExamen extends ConnexionFRSteps {
    @Given("je suis sur le planning")
    public void connect_portail_repartiteur() throws InterruptedException {
        createBrowser();
        je_veux_me_connecter_a_Rdv_Permis_en_tant_que_repartiteur();
        je_renseigne_mon_identifiant();
        je_renseigne_mon_mot_de_passe();
        je_clique_sur_le_bouton_Valider();
    }

    @When("Je selectionne un creneau reserve")
    public void je_selectionne_un_creneau_reserve() {
        // Write code here that turns the phrase above into concrete actions
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div[1]/ul/li[4]/div/div/div/div[4]/a[2]")).click();
    }

    @And("Je clique sur annuler")
    public void je_clique_sur_annuler() throws InterruptedException {
        Thread.sleep(3000);

        WebElement lastElement = dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div[2]/div/button/span"));
        int y = lastElement.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) dr;
        js.executeScript("window.scrollTo(0," + y + ")");

        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div[2]/div/button/span")).click();
        Thread.sleep(3000);
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div[2]/div/button/span")).click();

    }

    @Then("l'examen est annule et le creneau redevient indispo")
    public void l_examen_est_annule_et_le_creneau_redevient_indispo() {
        // Write code here that turns the phrase above into concrete actions
        dr.findElement(By.xpath("//div[@id='root']/div/header/div[3]/ul/li/div")).click();

        String expectedText = "Annulation enregistr";
        String actualText = dr.findElement(By.xpath("//div[@id='root']/div/header/div[3]/ul/li/div")).getText();
        Assert.assertTrue(actualText.contains(expectedText));

        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div[2]/div/div[4]/div/div/label/span/span")).click();
        String expectedText1 = "Indisponible";
        String actualText1 = dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div[2]/div/div[4]/div/div/label/span/span")).getText();
        Assert.assertTrue(actualText1.contains(expectedText1));
    }

    @Given("je me connecte sur maildev BER")
    public void connecte_maildev_cl() throws InterruptedException {
        dr.get("https://admin:F7lf34Tl4CeXLIwz9hpC9ksfU@maildev.rie.recette.rdvp.programme-erpc.fr/");
        Thread.sleep(2000);
    }

    @When("je selectionne le mail de reservation d'examen BER")
    public void selectionne_mail_examen() {
        dr.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[1]/a")).click();

    }

    @And("je trouve les informations de mon examen BER AE")
    public void verifier_informations_mail_examen_AE() throws InterruptedException {
        Thread.sleep(2000);
        String expectedText = "Annulation d\u0027un examen pratique du permis de conduire";
        String actualText = dr.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='testmailcd2910+ae-03119150@gmail.com'])[1]/preceding::span[1]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @Then("je trouve les informations de mon examen BER Candidat")
    public void verifier_informations_mail_examen_Can() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[2]/a/span[1]")).click();
        Thread.sleep(2000);
        String expectedText = "Annulation de votre convocation \u00e0 l\u0027examen pratique du permis de conduire";
        String actualText = dr.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ffgffff@gmail.com'])[1]/preceding::span[1]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }
}
