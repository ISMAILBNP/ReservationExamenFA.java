package fr.mi.rdvp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class SelectionCreneauxFASteps extends ConnexionAutoEcole {

    @Given("Je me connecte sur le front auto ecole1")
    public void connexion() {
        createBrowser();
        je_me_connecte_sur_le_front_ae();
    }

    @When("Je selectionne le menu mon planning")
    public void selection_mn_planning() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[2]/div/a[2]")).click();

    }

    @And("je selectionne une catPermis, un departement, un centre et une date")
    public void selection_info() {
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/div/div[1]/div/label[2]")).click();
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/div/div[2]/div/div/div[1]/div[1]")).click();
        Actions keyDown = new Actions(dr);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.RETURN)).perform();
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/div/div[3]/div/div/div[1]")).click();
        Actions keysDown = new Actions(dr);
        keysDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.RETURN)).perform();
        dr.findElement(By.xpath("//*[@id=\"date-debut\"]")).clear();
        dr.findElement(By.xpath("//*[@id=\"date-debut\"]")).sendKeys("27/08/2021");

    }

    @And("je clique sur un creneaux")
    public void selection_creneau() throws InterruptedException {
        Thread.sleep(2000);
        //dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div/section[1]/ul/li/section/div/div/div[1]/label[1]/div/div[2]")).click();
        dr.findElement(By.xpath("//*[contains(text(),'Disponible')]")).click();
    }

    @Then("je vois le creneau disponible AE")
    public void voir_creneaux_dispo() {
        String expectedText = "Disponible";
        String actualText = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div/section[1]/ul/li/section/div/div/div[1]/label[1]/div/div[2]")).getText();
        Assert.assertTrue("Creneau non disponible", expectedText.equals(actualText));
        dr.quit();
    }
}