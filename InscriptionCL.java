package fr.mi.rdvp;

import io.cucumber.core.gherkin.vintage.internal.gherkin.ast.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InscriptionCL extends ConnexionCandidat {

    @Given("Je connecte au front candidat")
    public void connecting() throws InterruptedException {
        createBrowser();
        je_veux_me_connecter_a_Rdv_Permis_en_tant_que_candidat();
    }

    @When("je clique sur le boutton dinscription")
    public void je_clique_sur_le_boutton_dinscription() throws InterruptedException {
        Thread.sleep(3000);
        dr.findElement(By.xpath("//*[@id=\"bloc-inscription-candidat\"]/a")).click();

    }

    @Then("Je suis sur la page de creation dun compte candidat libre")
    public void je_suis_sur_la_page_de_creation_dun_compte_candidat_libre() {
        WebDriverWait wait = new WebDriverWait(dr, 70);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nom-candidat\"]")));

        String actualText = dr.findElement(By.xpath("/html/body/div[1]/main/div/section/h2")).getText();
        String Text = "Inscription candidat libre";
        Assert.assertEquals(Text, actualText);

    }

    @Given("je suis sur la page de creation de compte CL")
    public void je_suis_sur_la_page_de_creation_de_compte_CL() {
        // Write code here that turns the phrase above into concrete actions

        String name = dr.findElement(By.xpath("//*[@id=\"nom-candidat\"]")).getText();
        String nom = "";
        Assert.assertEquals(nom, name);
        Assert.assertEquals(nom, name);

        String neph = dr.findElement(By.xpath("//*[@id=\"neph-candidat\"]")).getText();
        String id = "";
        Assert.assertEquals(id, neph);

        String email = dr.findElement(By.xpath("//*[@id=\"email-candidat\"]")).getText();
        String adresse = "";
        Assert.assertEquals(adresse, email);
    }

    @When("je saisis le {string}, le {string} et l{string}")
    public void je_saisis_le_nom_le_neph_et_l_adresse_email(String nom, String neph, String adresseEmail) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        dr.findElement(By.xpath("//*[@id=\"nom-candidat\"]")).sendKeys(nom);
        dr.findElement(By.xpath("//*[@id=\"neph-candidat\"]")).sendKeys(neph);
        dr.findElement(By.xpath("//*[@id=\"email-candidat\"]")).sendKeys(adresseEmail);

        Thread.sleep(2000);
    }

    @Then("je clique sur valider")
    public void je_clique_sur_valider() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"__next\"]/main/div/section/section/form/button")).click();

        Thread.sleep(5000);
    }

    @Given("je me connecte sur le site de maildev")
    public void je_me_connecte_sur_le_site_de_maildev() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        dr.get("https://admin:F7lf34Tl4CeXLIwz9hpC9ksfU@maildev.rie.recette.rdvp.programme-erpc.fr/");
        Thread.sleep(2000);
    }

    @When("je selectionne le mail de creation de compte")
    public void je_selectionne_le_mail_de_creation_de_compte() {
        dr.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[1]/a")).click();

    }

    @Then("je verifie les informations de l inscription candidat")
    public void je_verifie_les_informations_de_l_inscription_candidat() throws InterruptedException {
        Thread.sleep(2000);
        String expectedText = "Minist\u00e8re de l\u0027Int\u00e9rieur : cr\u00e9ation de votre compte Permis de Conduire";
        String actualText = dr.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='cvt90@talan.com'])[1]/preceding::span[1]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }
}

