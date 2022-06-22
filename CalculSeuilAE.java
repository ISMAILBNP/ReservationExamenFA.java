package fr.mi.rdvp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CalculSeuilAE extends ConnexionAutoEcole {

    @Given("Je connecte sur le font ae")
    public void connexion() {
        createBrowser();
        je_me_connecte_sur_le_front_ae();
    }

    @When("je selectionne le planning de mon ae")
    public void selection_mon_planning() throws InterruptedException {
        Thread.sleep(10000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[2]/div/a[2]")).click();

    }

    @And("je selectionne une date")
    public void selection_information() {
        dr.findElement(By.xpath("//*[@id=\"date-debut\"]")).clear();
        dr.findElement(By.xpath("//*[@id=\"date-debut\"]")).sendKeys("04/10/2021");

    }

    @And("je rajoute un creneau a mon panier")
    public void selection_dun_creneau() throws InterruptedException {
        Thread.sleep(10000);
        dr.findElement(By.xpath("//*[contains(text(),'Disponible')]")).click();
    }

    @And("le seuil formateur est atteint")
    public void seuil_atteint() throws InterruptedException {
        Thread.sleep(2000);
        String expectedText = "0 place restante";
        String actualText = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div/section[2]/div/div/p[1]/span")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @And("je supprime l'examen du panier")
    public void sup_exam() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div/section[2]/section/form/ul/li/ul/li/section/ul/li/div/button/i")).click();
    }

    @Then("le seuil n'est plus atteint")
    public void seuil_non_atteint() throws InterruptedException {
        Thread.sleep(2000);
        String expectedText = "0 place restante";
        String actualText = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div/section[2]/div/div/p[1]/span")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }
}