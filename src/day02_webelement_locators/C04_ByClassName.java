package day02_webelement_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_ByClassName {

    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //2- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        //3- arama kutusuna phone yazip aratin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //4- Category bolumunde 8 element oldugunu test edin
        List<WebElement> categoryElementList = driver.findElements(By.className("panel-list"));

        //5- Category isimlerini yazdirin
        // System.out.println(categoryElementList);
        // listemiz WebElement'lerden olusuyor ve WebElement'ler direk yazdirilamaz

        for (WebElement each: categoryElementList
        ) {
            System.out.println(each.getText());
        }


        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}