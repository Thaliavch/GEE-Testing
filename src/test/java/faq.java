
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Objects;

public class Main {
    private static void travelTo(WebElement click, WebDriver driver, String origPage) throws InterruptedException {
        click.click();
        Thread.sleep(2000);
        driver.get(origPage);
    }
    private static void switchWindow(WebDriver driver) throws InterruptedException{
        //System.out.println(driver.getWindowHandle());
        String mainWindowHandle = driver.getWindowHandle();
        if (driver.getWindowHandles().size() > 1) {
            for (String windowHandle : driver.getWindowHandles()) {
                //System.out.println(windowHandle);
                //System.out.println("a");
                if (!windowHandle.equals(mainWindowHandle)) {
                    //System.out.println(driver.getWindowHandle());
                    //System.out.println("Switched");
                    driver.switchTo().window(windowHandle);
                    //System.out.println(driver.getWindowHandle());
                    // Handle actions in the new tab
                    Thread.sleep(3000);
                    // Close the new tab and switch back to the main window
                    driver.switchTo().window(mainWindowHandle);
                    //driver.close();
                    break;
                }
            }
        }
        //System.out.println("---");
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://earthengine.google.com/");
        driver.manage().window().maximize();
        List<WebElement> tabs = driver.findElements(By.className("tab"));
        int found = -1;
        for(int i=0;i<tabs.size();i++){
            if(Objects.equals(tabs.get(i).getText(), "FAQ"))
                found = i;
        }
        tabs.get(found).click();
        Thread.sleep(1000);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        String origPage = driver.getCurrentUrl();
        for(int i=12;i<38;i++){
            if(links.get(i).getText() != null) {
                travelTo(links.get(i), driver, origPage);
                switchWindow(driver);
                links = driver.findElements(By.tagName("a"));
            }
        }
        driver.close();
    }
}