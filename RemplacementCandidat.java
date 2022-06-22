package fr.mi.rdvp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class RemplacementCandidat extends ConnexionAutoEcole {

    @And("je selectionne un examen a remplacer")
    public void selection_dun_creneau_a_remplacer() throws InterruptedException {
        Thread.sleep(5000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div/section[1]/ul/li/section/div/div/div[4]/button/div/div[1]")).click();
    }

    @And("je clic sur remplacer le candidat")
    public void remplacer_examen() throws InterruptedException {
        Thread.sleep(3000);
        dr.findElement(By.xpath("//*[@id=\"react-aria-modal-dialog\"]/div/section/section[3]/section/section[2]/section/span")).click();

    }

    @And("J insere le NEPH du nouveau candidat")
    public void neph_candidat_remplacant() throws InterruptedException {
        Thread.sleep(3000);
        dr.findElement(By.xpath("/html/body/div[2]/div/div/div/div/section/section[3]/div/div/div/div/div[1]/div[2]/div/input")).sendKeys("170475100848");
        Thread.sleep(2000);
        dr.findElement(By.xpath("/html/body/div[2]/div/div/div/div/section/section[3]/div/div/div/div/div[1]/div/div/input")).sendKeys(Keys.ENTER);
    }

    @And("j appuye sur le bouton remplacer le candidat")
    public void remp_candidat() throws InterruptedException {
        Thread.sleep(3000);
        dr.findElement(By.xpath("//*[@id=\"react-aria-modal-dialog\"]/div/div/footer/div/button")).sendKeys(Keys.ENTER);
    }

    @Then("le candida est remplace")
    public void candidat_remplace() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div/section[1]/ul/li/section/div/div/div[4]/button/div/div[1]")).click();
        Thread.sleep(2000);
        String expectedText = "170475100848";
        String actualText = dr.findElement(By.xpath("//*[@id=\"react-aria-modal-dialog\"]/div/section/section[2]/div[2]/dl/dd[1]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));

    }

    @When("je selectionne le mail de l annulation de l examen du candidat remplace")
    public void selectionne_mail_examen_canceled() {
        dr.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[2]/a/span[1]")).click();
    }

    @And("je verifie les informations de l annulation")
    public void verifier_informations_mail_examen_canceled() throws InterruptedException {
        Thread.sleep(5000);
        String expectedText = "Annulation de votre convocation \u00e0 l\u0027examen pratique du permis de conduire";
        String actualText = dr.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='teste19049cf520@gmail.com'])[1]/preceding::span[1]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @And("je selectionne le mail de la convocation du candidiat remplacant")
    public void selectionne_mail_examen_conv() {
        dr.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[1]/a/span[1]")).click();
    }

    @Then("je verifie les informations de la convocation")
    public void verifier_informations_mail_examen_conv() throws InterruptedException {
        Thread.sleep(5000);
        String expectedText = "Convocation \u00e0 l\u0027examen pratique du permis de conduire";
        String actualText = dr.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='teste19089cd520@gmail.com'])[1]/preceding::span[1]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }
}

