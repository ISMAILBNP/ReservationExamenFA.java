package fr.mi.rdvp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class AnnulationExamenFA extends ConnexionAutoEcole {

    @Given("Je me connecte sur le front ae2")
    public void connexion_ae_2() {
        createBrowser();
        je_me_connecte_sur_le_front_ae();
    }

    @When("Je selectionne le planning")
    public void selection_mon_planning_annul() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[2]/div/a[2]")).click();

    }

    @And("je selectionne une catPermis un departement, un centre, une date")
    public void selection_information_annul() {
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/div/div[1]/div/label[2]")).click();
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/div/div[2]/div/div/div[1]/div[1]")).click();
        Actions keyDown = new Actions(dr);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.RETURN)).perform();
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/div/div[3]/div/div/div[1]")).click();
        Actions keysDown = new Actions(dr);
        keysDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.RETURN)).perform();
        dr.findElement(By.xpath("//*[@id=\"date-debut\"]")).clear();
        dr.findElement(By.xpath("//*[@id=\"date-debut\"]")).sendKeys("04/11/2021");
    }

    @And("je selectionne un examen")
    public void selection_dun_creneau() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div/section[1]/ul/li/section/div/div/div[4]/button/div/div[1]")).click();
    }

    @Then("je clic sur annuler l examen")
    public void annul_examen() throws InterruptedException {
        Thread.sleep(3000);
        dr.findElement(By.xpath("//*[@id=\"react-aria-modal-dialog\"]/div/section/section[3]/footer/div/button")).click();
        Thread.sleep(3000);
        dr.findElement(By.xpath("//*[@id=\"react-aria-modal-dialog\"]/div/section/footer/div/section/button[2]")).click();
    }


    @Given("Je connecte sur mail dev")
    public void connecte_maildev_annul() throws InterruptedException {
        dr.get("https://admin:F7lf34Tl4CeXLIwz9hpC9ksfU@maildev.rie.recette.rdvp.programme-erpc.fr/");
        Thread.sleep(2000);
    }

    @When("je selectionne le mail d annulation d examen")
    public void selectionne_mail_examen_annul() {
        dr.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[1]/a")).click();
    }

    @Then("je trouve les informations de l examen annule")
    public void verifier_informations_mail_examen_annule() throws InterruptedException {
        Thread.sleep(5000);
        String expectedText = "Annulation de votre convocation \u00e0 l\u0027examen pratique du permis de conduire";
        String actualText = dr.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='teste190299d720@gmail.com'])[1]/preceding::span[1]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }
}

