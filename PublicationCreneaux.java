package fr.mi.rdvp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static fr.mi.rdvp.ConnexionFRSteps.dr;

public class PublicationCreneaux {
    @Given("Que je suis sur le menu d'inspecteur dans le menu deroulant")
    public void que_je_suis_sur_le_menu_d_inspecteur_dans_le_menu_deroulant() {

        String expectedText = "les plannings IPCSR";
        String actualText = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[1]/h2")).getText();
        Assert.assertTrue(actualText.contains(expectedText));

        /*dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div/ul/li/div/div/div/div[4]/a[4]/div")).click();
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div[2]/div/div[4]/div/div/label/span/span")).click();
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div/ul/li/div/div/div/div[4]/a[5]/div/div")).click();
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div/ul/li/div/div/div/div[4]/a[6]/div/div[2]")).click();
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div[2]/div/div[4]/div/div/label[3]/span/span")).click();
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div/ul/li/div/div/div/div[4]/a[7]/div/div")).click();
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div[2]/div/div[4]/div/div/label[3]/span/span")).click();
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div/header/ul/li[4]/button")).click();
        dr.close();*/
    }

    @When("Je selectionne mon inspecteur")
    public static void je_selectionne_mon_inspecteur() {
        // Write code here that turns the phrase above into concrete actions
        dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/form/div/div[1]/div")).click();
        dr.findElement(By.xpath("//*[@id=\"filtres-inspecteurs\"]")).sendKeys("pepe");
        dr.findElement(By.xpath("//*[@id=\"filtres-inspecteurs\"]")).sendKeys(Keys.ENTER);
    }

    @When("Je choisis le type de categorie de permis")
    public void je_choisis_le_type_de_categorie_de_permis() {
        // Write code here that turns the phrase above into concrete actions

        dr.findElement(By.xpath("//div[@id='root']/div/main/div[2]/form/div/div[2]/div/label[2]/span")).click();

    }
    @When("Je saisis la date et je clique sur entree")
    public void je_saisis_la_date_et_je_clique_sur_entree() {
        // Write code here that turns the phrase above into concrete actions
            dr.findElement(By.xpath("//*[@id=\"filtres-date\"]")).click();
            dr.findElement(By.xpath("//*[@id=\"filtres-date\"]")).clear();
            dr.findElement(By.xpath("//*[@id=\"filtres-date\"]")).sendKeys("30/09/2021");
            dr.findElement(By.xpath("//*[@id=\"filtres-date\"]")).sendKeys(Keys.ENTER);
    }

    @Then("Je visualise le planning de l inspecteur a une date donnee")
    public void je_visualise_le_planning_de_l_inspecteur_a_une_date_donnee() {
        String expectedText = "30";
        String actualText = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div[1]/header/div[2]/div/div[4]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));

    }

    @Given("Que je suis sur le planning de l'inspecteur selectionne")
    public void que_je_suis_sur_le_planning_de_l_inspecteur_selectionne() {
        // Write code here that turns the phrase above into concrete actions
        String expectedText = "Pepe CARVALHO";
        String actualText = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div[1]/header/div[1]/h4")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @When("Je clique sur un creneau de la journee inspecteur")
    public void je_clique_sur_un_creneau_de_la_journee_inspecteur() {
        // Write code here that turns the phrase above into concrete actions
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div/ul/li/div/div/div/div[4]/a[4]/div")).click();
    }

    @When("Je passe le creneau au statut indisponible")
    public void je_passe_le_creneau_au_statut_indisponible() {
        // Write code here that turns the phrase above into concrete actions
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div[2]/div/div[4]/div/div/label/span/span")).click();
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div/ul/li/div/div/div/div[4]/a[5]/div/div")).click();
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div/ul/li/div/div/div/div[4]/a[6]/div/div[2]")).click();

    }

    @When("Je choisis un autre creneau et je le rend disponible CL")
    public void je_choisis_un_autre_creneau_et_je_le_rend_disponible_CL() {
        // Write code here that turns the phrase above into concrete actions
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div[2]/div/div[4]/div/div/label[3]/span/span")).click();
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div/ul/li/div/div/div/div[4]/a[7]/div/div")).click();
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div[2]/div/div[4]/div/div/label[3]/span/span")).click();
    }

    @Then("Je visualise le planning avec les different types de creneaux")
    public void je_visualise_le_planning_avec_les_different_types_de_creneaux() {
        // Write code here that turns the phrase above into concrete actions
        String expectedText = "Indispo";
        String actualText = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div[1]/ul/li[1]/div/div/div/div[4]/a[4]/div/div[2]")).getText();
        Assert.assertEquals(expectedText, actualText);

        String expectedText0 = "Dispo AE";
        String actualText0 = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div[1]/ul/li[1]/div/div/div/div[4]/a[3]/div/div[2]")).getText();
        Assert.assertEquals(expectedText, actualText);

        String expectedText1 = "Dispo CL";
        String actualText1 = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div[1]/ul/li[1]/div/div/div/div[4]/a[6]/div/div[2]")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @When("Je clique sur le bouton rendre visible")
    public void je_clique_sur_le_bouton_rendre_visible() {
        // Write code here that turns the phrase above into concrete actions
        dr.findElement(By.xpath("//div[@id='root']/div/main/div[3]/div/div/header/ul/li[4]/button")).click();
    }

    @Then("Je visualise le libelle du bouton est passe a visible")
    public void je_visualise_le_libelle_du_bouton_est_passe_A_visible() {
        // Write code here that turns the phrase above into concrete actions
        String expectedText = "Visible";
        String actualText = dr.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[3]/div/div[1]/header/ul/li[4]/button")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
}
