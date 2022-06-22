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

public class ReservationExamenCL extends ConnexionCandidat {


    @Given("Je connecte sur le front candidat")
    public void connect() throws InterruptedException {
        createBrowser();
        je_veux_me_connecter_a_Rdv_Permis_en_tant_que_candidat();
        je_renseigne_mon_identifiant_C();
        je_renseigne_mon_mot_de_passe_C();
        je_clique_sur_le_bouton_Valider_C();
    }


    @When("je clic sur le boutton reserver un examen")
    public void je_clic_boutton_reserver_examen() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div[2]/div[1]/div[2]/div/a")).click();
    }

    @And("j insere le numero du departement")
    public void insert_numero_departement() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/form/div[1]/div/div/div/div[1]/div[1]")).click();
        dr.findElement(By.xpath("//*[@id=\"id-departement-autocomplete\"]")).sendKeys("031");
        dr.findElement(By.xpath("//*[@id=\"id-departement-autocomplete\"]")).sendKeys(Keys.ENTER);
    }

    @And("j appuye sur le boutton rechercher")
    public void jappuye_boutton_rechercher() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/form/button")).click();
    }

    @And("je clique sur un centre")
    public void click_sur_un_centre() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section/div[2]/button/div/h3")).click();
    }

    @And("je clique sur un creneau d examen")
    public void clic_examen_cl() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section/div[2]/label[1]/div/div")).click();
    }

    @And("j appuye sur le boutton poursuivre la reservation")
    public void poursuivre_reservation() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section/div[3]/footer/section/a")).click();
    }

    @And("j insere le nom,prenom,neph,date de delivrence")
    public void insert_nom_prenom_neph_date_de_delivrance() throws InterruptedException {
        Thread.sleep(5000);
        dr.findElement(By.xpath("//*[@id=\"nom-accompagnateur\"]")).click();
        dr.findElement(By.xpath("//*[@id=\"nom-accompagnateur\"]")).sendKeys("testauto");
        dr.findElement(By.xpath("//*[@id=\"nom-accompagnateur\"]")).sendKeys(Keys.TAB);
        dr.findElement(By.xpath("//*[@id=\"pr\u00e9nom\u002Daccompagnateur\"]")).sendKeys("auto");
        dr.findElement(By.xpath("//*[@id=\"pr\u00e9nom\u002Daccompagnateur\"]")).sendKeys(Keys.TAB);
        dr.findElement(By.xpath("//*[@id=\"neph\u002Daccompagnateur\"]")).sendKeys("232343454565");
        dr.findElement(By.xpath("//*[@id=\"neph\u002Daccompagnateur\"]")).sendKeys(Keys.TAB);
        dr.findElement(By.xpath("//*[@id=\"date\u002Daccompagnateur\"]")).sendKeys("10/02/1980");
    }

    @And("j appuye sur poursuivre la reservation")
    public void poursuivre_la_reservation() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[3]/footer/a")).click();
    }

    @And("je coche les deux cases")
    public void cocher_deux_cases() throws InterruptedException {
        Thread.sleep(2000);

        WebElement lastElement = dr.findElement(By.xpath("//*[@id=\"confirmation\u002Dvehicule\u002Ddouble\u002Dcommande\"]"));
        int y = lastElement.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) dr;
        js.executeScript("window.scrollTo(0," + y + ")");

        Thread.sleep(3000);
        dr.findElement(By.xpath("//*[@id=\"confirmation\u002Daccompagnateur\u002Dpresent\"]")).click();
        dr.findElement(By.xpath("//*[@id=\"confirmation\u002Dvehicule\u002Ddouble\u002Dcommande\"]")).click();
    }

    @Then("j appuye sur confirmer la reservation")
    public void confirmer_res() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div[5]/form/div[3]/footer/button")).click();
    }

    @Given("je me connecte sur maildev CL")
    public void connecte_maildev_cl() throws InterruptedException {
        dr.get("https://admin:F7lf34Tl4CeXLIwz9hpC9ksfU@maildev.rie.recette.rdvp.programme-erpc.fr/");
        Thread.sleep(2000);
    }

    @When("je selectionne le mail de reservation d'examen CL")
    public void selectionne_mail_examen() {
        dr.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[1]/a")).click();

    }

    @Then("je trouve les informations de mon examen CL")
    public void verifier_informations_mail_examen() throws InterruptedException {
        Thread.sleep(2000);
        String expectedText = "Convocation \u00e0 l\u0027examen pratique du permis de conduire";
        String actualText = dr.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='qoxobopiuvmn@talan.com'])[1]/preceding::span[1]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));

    }
}