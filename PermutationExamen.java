package fr.mi.rdvp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static fr.mi.rdvp.ConnexionFRSteps.dr;


public class PermutationExamen extends ConnexionAutoEcole {


    @Given("je me connecte sur le front AE")
    public void je_me_connecte_sur_le_front_AE() {
        createBrowser();
        je_me_connecte_sur_le_front_ae();
    }

    @And("je clique sur un premier creneau")
    public void je_clique_sur_un_premier_creneau() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("/html/body/div[1]/div/main/div[3]/div/div/section[1]/ul/li/section/div/div/div[4]/button[1]")).click();
        Thread.sleep(2000);
    }

    @And("Je clique sur permuter le candidat1")
    public void je_clique_sur_permuter_le_candidat1() throws InterruptedException {
        dr.findElement(By.xpath("//div[@id='react-aria-modal-dialog']/div/section/section[3]/section/section/section/span")).click();
        Thread.sleep(2000);
    }

    @And("je selectionne la date du jour et le creneau du jour a permuter")
    public void je_selectionne_la_date_du_jour() throws InterruptedException {
        dr.findElement(By.name("exam")).click();
        Thread.sleep(2000);
        dr.findElement(By.xpath("//div[@id='react-aria-modal-dialog']/div/div/div[3]/footer/div/button")).click();
        Thread.sleep(2000);
    }

    @Then("je clique sur permuter l'examen du jour")
    public void je_clique_sur_permuter_l_examen_du_jour() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        dr.findElement(By.xpath("//div[@id='root']/div/header/div[3]/ul/li/div")).click();
        Thread.sleep(2000);
    }

    @Given("Je suis sur la page de planification creneau du BER")
    public void je_suis_sur_la_page_planificationBer() throws InterruptedException {
        //dr.findElement(By.xpath("//div[@id='root']/div/header/div[3]/ul/li/div")).click();
        Thread.sleep(2000);
    }

    @When("Je clique sur permuter le candidat2")
    public void je_clique_sur_permuter_le_candidat2() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div/section/ul/li/section/div/div/div[4]/button[2]/div/div")).click();
    }

    @And("je selectionne la date du semaine")
    public void je_selectionne_un_jour_de_la_semaine() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"react-aria-modal-dialog\"]/div/section/section[3]/section/section[1]/section/span")).click();

        dr.findElement(By.xpath("//*[@id=\"react-aria-modal-dialog\"]/div/div/div[2]/div[3]/div/button[3]")).click();
        String expectedText = "03/11";
        String actualText = dr.findElement(By.xpath("//*[@id=\"react-aria-modal-dialog\"]/div/div/div[2]/div[3]/div/button[3]/p/span")).getText();
        Assert.assertTrue(actualText.contains(expectedText));

        Thread.sleep(1000);
        dr.findElement(By.xpath("//*[@id=\"react-aria-modal-dialog\"]/div/div/div[2]/div[3]/div/button[5]")).click();

    }

    @And("je selectionne le creneau du semaine a permuter")
    public void je_selectionne_le_creneau_du_semaine_a_permuter() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"react-aria-modal-dialog\"]/div/div/div[2]/div[3]/table/tbody/tr/td[3]/p")).click();

    }

    @Then("je clique sur permuter l'examen du semaine")
    public void je_clique_sur_permuter_l_examen_de_la_semaine() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(2000);
        dr.findElement(By.name("exam")).click();
        dr.findElement(By.xpath("//*[@id=\"react-aria-modal-dialog\"]/div/div/div[3]/footer/div/button")).click();
    }

    @Given("je me connecte sur le front BER")
    public void je_me_connecte_sur_le_front_BER() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        dr.get("https://ber.rie.recette.rdvp.programme-erpc.fr");
        dr.findElement(By.xpath("//*[@id='username']")).sendKeys("testmailcd2910+dsr-5@gmail.com");
        dr.findElement(By.xpath("//*[@id='password']")).sendKeys("RDVPermis123!");
        dr.findElement(By.xpath("//*[@id='kc-login']")).click();
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/div/div[1]/div")).click();
        dr.findElement(By.xpath("//*[@id=\"filtres-inspecteurs\"]")).sendKeys("pepe");
        dr.findElement(By.xpath("//*[@id=\"filtres-inspecteurs\"]")).sendKeys(Keys.ENTER);
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[2]/form/div/div[2]/div/label[2]/span")).click();
        dr.findElement(By.xpath("//*[@id=\"filtres-date\"]")).click();
        dr.findElement(By.xpath("//*[@id=\"filtres-date\"]")).clear();
        dr.findElement(By.xpath("//*[@id=\"filtres-date\"]")).sendKeys("04/11/2021");
        dr.findElement(By.xpath("//*[@id=\"filtres-date\"]")).sendKeys(Keys.ENTER);
    }

    @When("je clique sur mon premier creneau")
    public void je_clique_sur_mon_premier_creneau() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(2000);
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div/ul/li[2]/div/div/div/div[4]/a/div/div[2]")).click();

    }

   /* @And("Je verifie ma premiere permutation effectuee")
    public void je_verifie_ma_premiere_permutation_effectuee() {
        // Write code here that turns the phrase above into concrete actions
        String expectedText = "BFZMDFNT";
        String actualText =  dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div[2]/div/div[5]/p")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }*/

    @And("je clique sur mon deuxieme creneau")
    public void je_clique_sur_mon_deuxieme_creneau() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(2000);
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div/ul/li[2]/div/div/div/div[4]/a[3]/div/div")).click();
    }

    /*@And("je verifie ma deuxieme permutation effectuee")
    public void je_verifie_ma_deuxieme_permutation_effectuee() {
        // Write code here that turns the phrase above into concrete actions
        String expectedText1 = "BFZMDFNT";
        String actualText1 = dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div[2]/div/div[5]/p")).getText();
        Assert.assertTrue(actualText1.contains(expectedText1));
    }*/

    @Then("les deux creneaux on ete permutee avec succes")
    public void les_deux_creneaux_on_ete_permutee_avec_succes() {
        // Write code here that turns the phrase above into concrete actions
        String expectedText2 = "INNOVATION CONDUITE";
        String actualText2 = dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div[2]/div/div[7]/p")).getText();
        Assert.assertTrue(actualText2.contains(expectedText2));
    }
    @When("je selectionne le mail de la permutation de l examen du candidat1")
    public void je_selectionne_le_mail_de_la_permutation_de_l_examen_du_candidat1() throws InterruptedException {
        Thread.sleep(5000);
        dr.findElement(By.xpath("//input[@type='text']")).sendKeys("BFZMDFNT");
        dr.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.ENTER);
        dr.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[1]/a")).click();
    }

    @When("je verifie les informations de la premiere permutation")
    public void je_verifie_les_informations_de_la_premiere_permutation() throws InterruptedException {
        Thread.sleep(2000);
        String expectedText = "L\u0027horaire de votre passage \u00e0 l\u0027examen du permis de conduire a chang\u00E9";
        String actualText = dr.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='teste109997@gmail.com'])[1]/preceding::span[1]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @When("je selectionne le mail de la permutation de l examen du candidat2")
    public void je_selectionne_le_mail_de_la_permutation_de_l_examen_du_candidat2() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//input[@type='text']")).clear();
        dr.findElement(By.xpath("//input[@type='text']")).sendKeys("SFCDGR");
        dr.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.ENTER);
        dr.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[1]/a")).click();
    }

    @Then("je verifie les informations de la deuxieme permutation")
    public void je_verifie_les_informations_de_la_deuxieme_permutation() throws InterruptedException {
        Thread.sleep(2000);
        String expectedText = "L\u0027horaire de votre passage \u00e0 l\u0027examen du permis de conduire a chang\u00E9";
        String actualText = dr.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='teste109992@gmail.com'])[1]/preceding::span[1]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }
}