package fr.mi.rdvp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class ReservationExamenFA extends ConnexionAutoEcole {

    @Given("Je me connecte sur le front ae")
    public void connexion() {
        createBrowser();
        je_me_connecte_sur_le_front_ae();
    }

    @When("Je selectionne mon planning")
    public void selection_mon_planning() throws InterruptedException {
        Thread.sleep(10000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[2]/div/a[2]")).click();

    }

    @And("je selectionne une catPermis un departement, un centre et une date")
    public void selection_information() {
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/div/div[1]/div/label[2]")).click();
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/div/div[2]/div/div/div[1]/div[1]")).click();
        dr.findElement(By.id("codeD\u00e9partement")).clear();
        dr.findElement(By.id("codeD\u00e9partement")).sendKeys("31");
        dr.findElement(By.id("codeD\u00e9partement")).sendKeys(Keys.ENTER);
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[2]/form/div/div[3]/div/div/div")).click();
        dr.findElement(By.id("centre-examen")).clear();
        dr.findElement(By.id("centre-examen")).sendKeys("COLO");
        dr.findElement(By.id("centre-examen")).sendKeys(Keys.ENTER);
        dr.findElement(By.id("date-debut")).clear();
        dr.findElement(By.id("date-debut")).sendKeys("04/11/2021");
        dr.findElement(By.id("date-debut")).sendKeys(Keys.ENTER);


        /*Actions keyDown = new Actions(dr);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.RETURN)).perform();
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/div/div[3]/div/div/div[1]")).click();
        Actions keysDown = new Actions(dr);
        keysDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.RETURN)).perform();
        dr.findElement(By.xpath("//*[@id=\"date-debut\"]")).clear();
        dr.findElement(By.xpath("//*[@id=\"date-debut\"]")).sendKeys("30/09/2021");*/

    }

    @And("je clic sur un creneau")
    public void selection_dun_creneau() throws InterruptedException {
        Thread.sleep(10000);
        //dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div/section[1]/ul/li/section/div/div/div[1]/label[1]/div/div[2]")).click();
        dr.findElement(By.xpath("//*[contains(text(),'Disponible')]")).click();
    }

    @And("j insere le neph")
    public void insert_neph() throws InterruptedException {
        Thread.sleep(3000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div/section[2]/section/form/ul/li/ul/li/section/ul/li/div/div/div/div/div/div[1]")).click();
        Thread.sleep(3000);
        dr.findElement(By.xpath("/html/body/div/div/main/div[3]/div/div/section[2]/section/form/ul/li/ul/li/section/ul/li[1]/div/div/div/div/div/div[1]/div[2]/div/input")).sendKeys("030275110300");
        Thread.sleep(3000);
        dr.findElement(By.xpath("/html/body/div/div/main/div[3]/div/div/section[2]/section/form/ul/li/ul/li/section/ul/li[1]/div/div/div/div/div/div[1]/div[2]/div/input")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

    }

    @Then("l examen est reserve")
    public void examen_reserve() throws InterruptedException {
        Thread.sleep(3000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div/section[2]/section/form/footer/button")).click();
    }

    @Given("je connecte sur maildev")
    public void connecte_maildev() throws InterruptedException {
        dr.get("https://admin:F7lf34Tl4CeXLIwz9hpC9ksfU@maildev.rie.recette.rdvp.programme-erpc.fr/");
        Thread.sleep(2000);
    }

    @When("je selectionne le mail de reservation d examen")
    public void selectionne_mail_examen() {
        dr.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[1]/a")).click();

    }

    @Then("je trouve les informations de l examen")
    public void verifier_informations_mail_examen() throws InterruptedException {
        Thread.sleep(2000);
        String expectedText = "Convocation \u00e0 l\u0027examen pratique du permis de conduire";
        String actualText = dr.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='testingauto1@gmail.com'])[1]/preceding::span[1]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }
}

