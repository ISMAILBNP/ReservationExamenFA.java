package fr.mi.rdvp;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConnexionCandidat {
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

    //@Given("je veux me connecter a Rdv Permis en tant que candidat")
    public void je_veux_me_connecter_a_Rdv_Permis_en_tant_que_candidat() {
        // Write code here that turns the phrase above into concrete actions
        dr.get("https://candidat.web.recette.rdvp.programme-erpc.fr/");
    }

    //@When("je renseigne mon identifiant C")
    public void je_renseigne_mon_identifiant_C() {
        // Write code here that turns the phrase above into concrete actions

        dr.findElement(By.id("username")).sendKeys("QOXOBOPIUVMN@talan.com");

    }

    //@When("je renseigne mon mot de passe C")
    public void je_renseigne_mon_mot_de_passe_C() {
        // Write code here that turns the phrase above into concrete actions
        dr.findElement(By.id("password")).sendKeys("ktY5ePlVG98ZRr[8");
    }

    //@When("je clique sur le bouton Valider C")
    public void je_clique_sur_le_bouton_Valider_C() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(60000);
        dr.findElement(By.id("kc-login")).click();

    }

    //@Then("mon nom est affiche en haut a gauche")
    public void mon_nom_est_affiche_en_haut_a_droite_C() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(6000);
        String expectedText = "Bienvenue LYYC QOXOBOPIUVMN";
        String actualText = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[1]/div/div/p")).getText();
        Assert.assertEquals("Login not successful", expectedText, actualText);
    }
}
