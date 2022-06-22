package fr.mi.rdvp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static fr.mi.rdvp.ConnexionFRSteps.dr;

public class ReservationExamenBer {
    @Given("Que je suis sur le planning")
    public void que_je_suis_sur_le_planning() {
        // Write code here that turns the phrase above into concrete actions
        String expectedText = "les plannings IPCSR";
        String actualText = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[1]/h2")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @When("Je selectionne un creneau")
    public void je_selectionne_un_creneau() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(dr, 70);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div[1]/ul/li[4]/div/div/div/div[4]/a[2]")));
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div[1]/ul/li[4]/div/div/div/div[4]/a[2]")).click();

    }

    @When("Je saisis le nom du candidat et je valide")
    public void je_saisis_le_nom_du_candidat_et_je_valide() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        //dr.findElement(By.xpath("//*[@id=\"ajout-candidat\"]")).sendKeys("INCFUXIGCX");
        /*dr.findElement(By.xpath("//*[@id=\"ajout-candidat\"]")).sendKeys(Keys.ENTER);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div[2]/div/form/button")).click();*/
        /*WebdrWait wait = new WebdrWait(dr, 70);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ajout-candidat\"]")));
        dr.findElement(By.xpath("//*[@id=\"ajout-candidat\"]")).sendKeys(Keys.ENTER);*/
        Thread.sleep(5000);
        dr.findElement(By.xpath("//*[@id=\"ajout-candidat\"]")).sendKeys("INCFUX");
        Thread.sleep(5000);
        dr.findElement(By.xpath("//*[@id=\"ajout-candidat\"]")).sendKeys(Keys.TAB);
        Thread.sleep(5000);
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);
    }

    @Then("Je visualise la prise en compte de mon examen")
    public void je_visualise_la_prise_en_compte_de_mon_examen() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        //dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div[1]/ul/li[4]/div/div/div/div[4]/a[2]")).click();
        Thread.sleep(2000);
        String expectedText = "KLYHDBA INCFUXIGCX";
        String actualText = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div[2]/div/div[5]/p")).getText();
        Assert.assertTrue(actualText.contains(expectedText));

        String expectedText1 = "000044024222";
        String actualText1 = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div[2]/div/div[5]/dl/dd[1]")).getText();
        Assert.assertTrue(actualText1.contains(expectedText1));

        String expectedText2 = "Jeudi 30/09/2021";
        String actualText2 = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div[2]/div/div[2]/p[1]")).getText();
        Assert.assertTrue(actualText2.contains(expectedText2));

        String expectedText3 = "16:30";
        String actualText3 = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div[2]/div/div[2]/p[2]")).getText();
        Assert.assertTrue(actualText3.contains(expectedText3));

    }

    @Given("Que je suis sur maildev")
    public void que_je_suis_sur_maildev() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        dr.get("https://admin:F7lf34Tl4CeXLIwz9hpC9ksfU@maildev.rie.recette.rdvp.programme-erpc.fr/");
        Thread.sleep(2000);
    }

    @When("Je cherche la convocation de mon candidat")
    public void je_cherche_la_convocation_de_mon_candidat() {
        // Write code here that turns the phrase above into concrete actions
        dr.findElement(By.xpath("//input[@type='text']")).sendKeys("INCFUXIGCX");
        dr.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.ENTER);

    }

    @When("Je clique sur l'email")
    public void je_clique_sur_l_email() {
        dr.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='incfuxigcx@talan.com'])[1]/preceding::span[1]")).click();
    }

    @Then("Je visualise l'email de convocation")
    public void je_visualise_l_email_de_convocation() {

        String expectedText = "Convocation";
        //String actualText = ConnexionFRSteps.dr.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[3]/table/tbody/tr[6]/td[2]")).getText();
        String actualText = dr.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='incfuxigcx@talan.com'])[1]/preceding::span[1]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));

    }

}
