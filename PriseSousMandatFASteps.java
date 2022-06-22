package fr.mi.rdvp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PriseSousMandatFASteps extends ConnexionAutoEcole {


    @Given("Je me connecte sur le front auto ecole")
    public void connexion() {
        createBrowser();
        je_me_connecte_sur_le_front_ae();
    }

    @When("je selectionne le menu mes candidats")
    public void je_selectionne_le_menu_mes_candidats() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[2]/div/a[3]")).click();
    }

    @And("j appuye sur le bouton prendre sous mandat")
    public void jappuye_sur_le_bouton_prendre_sous_mandat() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div/a")).click();
    }

    @And("j insere le nom et le neph et cat permis")
    public void jinsere_le_nom_et_le_neph_et_cat_permis() {
        dr.findElement(By.xpath("//*[@id=\"nom-candidat\"]")).sendKeys("EYYPYDBLJQAY");
        dr.findElement(By.xpath("//*[@id=\"neph-candidat\"]")).sendKeys("011034300339");
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/div/div/div[3]/div/label[2]/span")).click();
    }

    @And("clic sur prendre sous mandat")
    public void click_prendre_sous_mandat() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/div/div/button")).click();
    }

    @And("j insere le mail")
    public void jinsere_le_mail() {
        dr.findElement(By.xpath("//*[@id=\"email-candidat\"]")).sendKeys("testef9349cfa5h@gmail.com");
    }

    @And("clic sur informer le candidat")
    public void informer_candidat() throws InterruptedException {
        Thread.sleep(5000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/div/div[2]/button")).click();
    }

    @Then("le candidat est pris sous mandat")
    public void pris_sous_mandat() throws InterruptedException {
        Thread.sleep(5000);
        String expectedText = "Le candidat a bien \u00e9t\u00e9 ajout\u00e9 sous mandat.";
        String actualText = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/div/div[2]/p[1]")).getText();
        System.out.println(expectedText);
        System.out.println(actualText);
        Assert.assertTrue("erreur prise sous mandat", expectedText.contains(actualText));

    }

    @Given("je me connecte sur maildev")
    public void connecte_maildev() throws InterruptedException {
        dr.get("https://admin:F7lf34Tl4CeXLIwz9hpC9ksfU@maildev.rie.recette.rdvp.programme-erpc.fr/");
        Thread.sleep(2000);
    }

    @When("je selectionne le mail de prise sous mandat")
    public void selectionne_mail() {
        dr.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[1]/a")).click();

    }

    @Then("je trouve les informations de la prise sous mandat")
    public void verifier_informations_maildev() throws InterruptedException {
        Thread.sleep(5000);
        String expectedText = "Prise sous mandat par votre auto-\u00e9cole";
        String actualText = dr.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='testef9349cfa5h@gmail.com'])[1]/preceding::span[1]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }
}