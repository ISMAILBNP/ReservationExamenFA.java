package fr.mi.rdvp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class PlanificationsessionsBER extends ConnexionFRSteps {
    @Given("je connecte sur le portail repartiteur")
    public void connect_portail_rep() throws InterruptedException {
        createBrowser();
        je_veux_me_connecter_a_Rdv_Permis_en_tant_que_repartiteur();
        je_renseigne_mon_identifiant();
        je_renseigne_mon_mot_de_passe();
        je_clique_sur_le_bouton_Valider();
    }

    @When("je selectionne le menu de planification des sessions")
    public void selection_menu_planification_sessions() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[2]/div/div[1]/button")).click();
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[2]/div/div[1]/div/ul/li[4]/a")).click();
    }

    @And("Je selectionne un inspecteur et un centre")
    public void je_selectionne_inspecteur_centre() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.id("select-inspecteur")).sendKeys("Carvalho Pepe");
        dr.findElement(By.id("select-inspecteur")).sendKeys(Keys.ENTER);
        dr.findElement(By.id("centres")).sendKeys("COLOMIERS B");
        dr.findElement(By.id("centres")).sendKeys(Keys.ENTER);
    }

    @And("je selectionne la tranche horaire de la session")
    public void je_selectionne_tranche_horaire() throws InterruptedException {
        Thread.sleep(2000);
        WebElement lastElement = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div[3]/section/div/div/div/div[5]/button[4]/div/div/div[1]"));
        int y = lastElement.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) dr;
        js.executeScript("window.scrollTo(0," + y + ")");
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div[3]/section/header/div/button[2]/i")).click();
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div[3]/section/div/div/div/div[5]/button[1]/div/div/div[1]")).click();
    }

    @And("j appuye sur le boutton planifier les sessions")
    public void je_appuye_boutton_planifier_sessions() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div[3]/div/div/button")).click();
    }

    @Then("les sessions sont crees dans le menu planifier les sessions")
    public void sessions_crees() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div[3]/section/div/div/div/div[5]/button[1]/div/div/div[1]")).click();
        Thread.sleep(3000);
        String expectedText = "CARVALHO Pepe";
        String actualText = dr.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/section/p/span[1]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));

        String expectedText2 = "vendredi 17\u002F09\u002F2021";
        String actualText2 = dr.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/section/p/span[2]")).getText();
        Assert.assertTrue(actualText2.contains(expectedText2));

        String expectedText3 = "COLOMIERS B";
        String actualText3 = dr.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/section/p/span[3]")).getText();
        Assert.assertTrue(actualText3.contains(expectedText3));
    }
}
