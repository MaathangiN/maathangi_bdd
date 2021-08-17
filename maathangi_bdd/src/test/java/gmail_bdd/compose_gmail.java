package gmail_bdd;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class compose_gmail {
    WebDriver driver = null;

    @Given("user visits gmail webpage")
    public void user_visits_gmail_webpage() {
        System.setProperty("webDriver.chrome.driver","/Users/maathangi_narayan/Desktop/cucumber_bdd/maathangi_bdd/src/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.navigate().to("https://mail.google.com");
        driver.manage().window().maximize();

    }
    @Given("enters username {string} and password as {string} to login successfully")
    public void enters_username_and_password_as_to_login_successfully(String username, String password) {

        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(username, Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(password,Keys.ENTER);


    }
    @When("email is composed and sent to abc@incubyte.com with subject {string} and body {string}")
    public void email_is_composed_and_sent_to_abc_incubyte_com_with_subject_and_body(String subject, String body) {
        //click compose button
        driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Enter To address
        driver.findElement(By.xpath("/html/body/div[24]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/form/div[1]/table/tbody/tr[1]/td[2]/div/div/textarea")).sendKeys("maathu1412@gmail.com");
        //Enter Subject
        driver.findElement(By.xpath("/html/body/div[24]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/form/div[3]/div/input")).sendKeys(subject);
        //Enter mail body
        driver.findElement(By.xpath("/html/body/div[24]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[1]/div[2]/div[1]/div/table/tbody/tr/td[2]/div[2]/div")).sendKeys(body);
        //Click send
        driver.findElement(By.xpath("/html/body/div[24]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[1]/div/div[2]/div[1]")).click();

    }
    @Then("last sent email appears in the sent box with subject {string}")
    public void last_sent_email_appears_in_the_sent_box_with_subject(String subject) {
        //Open sent box
        driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div/div[1]/div[1]/div/div[4]/div/div/div[2]")).click();
        //Check the subject of the last message matches the subject we sent
        Assert.assertEquals(subject,driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div[4]/div[2]/div/table/tbody/tr/td[5]/div/div/div[2]/span")).getText());

    }
}
