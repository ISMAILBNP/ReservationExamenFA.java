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

public class Declarationformateurs extends ConnexionFRSteps {

    @Given("Je connecte sur le font repartiteur")
    public void connect_portail_rep() throws InterruptedException {
        createBrowser();
        je_veux_me_connecter_a_Rdv_Permis_en_tant_que_repartiteur();
        je_renseigne_mon_identifiant();
        je_renseigne_mon_mot_de_passe();
        je_clique_sur_le_bouton_Valider();
    }

    @When("je selectionne le menu gerer les auto ecoles")
    public void menu_gerer_ae() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[2]/div/div[2]/button")).click();
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[2]/div/div[2]/div/ul/li[1]/a")).click();
    }

    @And("j insere l id aurige de l'auto ecole")
    public void insert_id_aurige_ae() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.id("rechercher-auto-ecole")).sendKeys("03119150");
        Thread.sleep(2000);
        dr.findElement(By.id("rechercher-auto-ecole")).sendKeys(Keys.ENTER);
    }

    @And("j'appuye sur le boutton modifier le nombre de formateurs")
    public void appuye_boutton_modifier_nombre_formateurs() throws InterruptedException {
        Thread.sleep(2000);
        WebElement lastElement = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[3]/div/section/section[1]/div/h3"));
        int y = lastElement.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) dr;
        js.executeScript("window.scrollTo(0," + y + ")");
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[3]/div/section/section[1]/div/button")).click();
    }

    @And("je declare le departement et le nombre de formateurs de l'auto ecole")
    public void declaration_departement_nb_formateurs() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("/html/body/div/div/main/div/div[3]/div/section/section[1]/div/form/table/tbody/tr[1]/td[1]/div/div/div/div/div[1]/div[2]/div/input")).sendKeys("031");
        dr.findElement(By.xpath("/html/body/div/div/main/div/div[3]/div/section/section[1]/div/form/table/tbody/tr[1]/td[1]/div/div/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
        dr.findElement(By.xpath("/html/body/div/div/main/div/div[3]/div/section/section[1]/div/form/table/tbody/tr[1]/td[2]/input")).clear();
        dr.findElement(By.xpath("/html/body/div/div/main/div/div[3]/div/section/section[1]/div/form/table/tbody/tr[1]/td[2]/input")).sendKeys("1,1");
        dr.findElement(By.xpath("/html/body/div/div/main/div/div[3]/div/section/section[1]/div/form/table/tbody/tr[1]/td[2]/input")).clear();
        dr.findElement(By.xpath("/html/body/div/div/main/div/div[3]/div/section/section[1]/div/form/table/tbody/tr[1]/td[2]/input")).sendKeys("1");
    }

    @And("j appuye sur le boutton valider les modifications")
    public void valider_les_modifications() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[3]/div/section/section[1]/div/form/button")).click();
    }

    @And("je declare le nombre de formateurs pour une nouvelle auto ecole")
    public void dec_nouvelle_ae() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.id("rechercher-auto-ecole")).sendKeys("01100610");
        Thread.sleep(2000);
        dr.findElement(By.id("rechercher-auto-ecole")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement lastElement = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[3]/div/section/section[1]/div/h3"));
        int y = lastElement.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) dr;
        js.executeScript("window.scrollTo(0," + y + ")");
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[3]/div/section/section[1]/div/button")).click();
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[3]/div/section/section[1]/div/form/table/tbody/tr[2]/td/button/div/span")).click();
        Thread.sleep(2000);
        dr.findElement(By.xpath("/html/body/div/div/main/div/div[3]/div/section/section[1]/div/form/table/tbody/tr[1]/td[1]/div/div/div/div/div[1]/div[2]/div/input")).sendKeys("034");
        dr.findElement(By.xpath("/html/body/div/div/main/div/div[3]/div/section/section[1]/div/form/table/tbody/tr[1]/td[1]/div/div/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
        dr.findElement(By.xpath("/html/body/div/div/main/div/div[3]/div/section/section[1]/div/form/table/tbody/tr[1]/td[2]/input")).clear();
        dr.findElement(By.xpath("/html/body/div/div/main/div/div[3]/div/section/section[1]/div/form/table/tbody/tr[1]/td[2]/input")).sendKeys("1,1");
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[3]/div/section/section[1]/div/form/button")).click();


    }

    @And("je selectionne le menu suivre lactivite")
    public void suivre_activite() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[2]/div/a[2]")).click();
    }

    @And("je change le coefficient formateur")
    public void changer_coefficient_formateurs() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div[1]/section/ul/li/div/div/div/button")).click();
        dr.findElement(By.xpath("/html/body/div/div/main/div[3]/div[1]/section/ul/li/div/form/div[1]/input")).clear();
        dr.findElement(By.xpath("/html/body/div/div/main/div[3]/div[1]/section/ul/li/div/form/div[1]/input")).sendKeys("1");
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div[1]/section/ul/li/div/form/div[2]/button[2]")).click();
    }

    @Then("le coefficient formateur est change")
    public void coefficient_formateurs() throws InterruptedException {
        Thread.sleep(2000);
        String expectedText = "1";
        String actualText = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div[1]/section/ul/li/div/div/dl/dd")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @Given("Je connecte sur le font autoecole")
    public void connecting_to_ae() throws InterruptedException {
        dr.get("https://pro.web.recette.rdvp.programme-erpc.fr/");
        dr.findElement(By.xpath("//*[@id='username']")).sendKeys("hhddd@gmail.com");
        dr.findElement(By.xpath("//*[@id='password']")).sendKeys("RDVPermis123!");
        Thread.sleep(60000);
        dr.findElement(By.xpath("//*[@id='kc-login']")).click();
    }

    @When("je selectionne le menu mes capacites de reservation")
    public void menu_capacite_reservation() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[1]/div/div/div/button/i[2]")).click();
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/header/div[1]/div/div/div/div/ul/li/div[1]/a/p")).click();
    }

    @Then("je declare le departement et le nombre de formateurs pour la premiere fois")
    public void dep_for_ae() throws InterruptedException {
        Thread.sleep(2000);
        dr.findElement(By.xpath("/html/body/div/div/main/div[3]/div/section/form/table/tbody/tr[1]/td[1]/div/div/div/div/div/div/div/input")).sendKeys("11");
        dr.findElement(By.xpath("/html/body/div/div/main/div[3]/div/section/form/table/tbody/tr[1]/td[1]/div/div/div/div/div/div/div/input")).sendKeys(Keys.ENTER);
        dr.findElement(By.xpath("/html/body/div/div/main/div[3]/div/section/form/table/tbody/tr[1]/td[2]/input")).sendKeys("2");
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/section/form/button")).click();
        Thread.sleep(2000);
        dr.findElement(By.xpath("//*[@id=\"react-aria-modal-dialog\"]/div/div/div[2]/footer/div/section/button[2]/span")).click();
    }

}
