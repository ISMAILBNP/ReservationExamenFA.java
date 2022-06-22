package fr.mi.rdvp;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConnexionAutoEcole {
    protected static WebDriver dr;

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

    protected void je_me_connecte_sur_le_front_ae() {
        dr.get("https://pro.web.recette.rdvp.programme-erpc.fr/");
        dr.findElement(By.xpath("//*[@id='username']")).sendKeys("testmailcd2910+ae-03119150@gmail.com");
        dr.findElement(By.xpath("//*[@id='password']")).sendKeys("RDVPermis123!");
        sleepThread();
        dr.findElement(By.xpath("//*[@id='kc-login']")).click();
    }

    private void sleepThread() {
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void fermer_navigateur() {
        dr.quit();
    }
}
