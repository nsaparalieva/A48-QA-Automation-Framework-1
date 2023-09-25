import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {

    @Test(testName = "Check updating profile's name")
    public void renameProfileTest() throws InterruptedException {
        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        WebElement passwordField = getDriver().findElement(By.cssSelector("input[type='password']"));
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));

        clickToElement(emailField);
        sendKeysToElement(emailField, "demo@class.com");
        clickToElement(passwordField);
        sendKeysToElement(passwordField, "te$t$tudent");
        clickToElement(loginButton);
        Thread.sleep(5000);

        WebElement avatar = getDriver().findElement(By.cssSelector(".avatar"));
        clickToElement(avatar);

        WebElement inputProfileName = getDriver().findElement(By.cssSelector("#inputProfileName"));
        clickToElement(inputProfileName);
        String newName = generateName();
        sendKeysToElement(inputProfileName, newName);

        WebElement currentPasswordField = getDriver().findElement(By.cssSelector("#inputProfileCurrentPassword"));
        clickToElement(currentPasswordField);
        sendKeysToElement(currentPasswordField, "te$t$tudent");
        WebElement saveButton = getDriver().findElement(By.cssSelector(".btn-submit"));
        clickToElement(saveButton);

        getDriver().navigate().refresh();
        Thread.sleep(5000);

        inputProfileName = getDriver().findElement(By.cssSelector("#inputProfileName"));
        Assert.assertEquals(inputProfileName.getText(), newName);
    }
}
