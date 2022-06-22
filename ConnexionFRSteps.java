package fr.mi.rdvp;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConnexionFRSteps {
    protected static WebDriver dr;

    //@Before
    protected void createBrowser() {
        String Os = System.getProperty("os.name").toLowerCase();
        System.out.println(Os.indexOf("win"));
        if (Os.indexOf("win") >= 0) {
            System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
        } else if (Os.indexOf("mac") >= 0) {
            System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");

        } else if (Os.indexOf("nix") >= 0 || Os.indexOf("nux") >= 0 || Os.indexOf("aix") >= 0) {
            System.setProperty("webdriver.gecko.driver", "./driver/geckodriver");

        } else {
            System.out.println("Your OS is not supported!!");
        }
        if (dr == null)
            dr = new FirefoxDriver();
    }

    //@Given("je veux me connecter a Rdv Permis en tant que repartiteur")
    public void je_veux_me_connecter_a_Rdv_Permis_en_tant_que_repartiteur() {
        dr.get("https://ber.rie.recette.rdvp.programme-erpc.fr");
    }

    //@When("je renseigne mon identifiant")
    public void je_renseigne_mon_identifiant() {
        dr.findElement(By.xpath("//*[@id='username']")).sendKeys("testmailcd2910+dsr-5@gmail.com");
    }

    //@And("je renseigne mon mot de passe")
    public void je_renseigne_mon_mot_de_passe() {
        dr.findElement(By.xpath("//*[@id='password']")).sendKeys("RDVPermis123!");
    }

    //@And("je clique sur le bouton Valider")
    public void je_clique_sur_le_bouton_Valider() {

        dr.findElement(By.xpath("//*[@id='kc-login']")).click();
    }

    //@Then("mon nom est affiche en haut a droite")
    public void mon_nom_est_affiche_en_haut_a_droite() throws InterruptedException {
        Thread.sleep(6000);
        String expectedText = "NOM5";
        String actualText = dr.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[1]/div/div/p/span[2]")).getText();
        Assert.assertEquals("Login not successful", expectedText, actualText);
    }
}