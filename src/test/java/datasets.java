//feel free to replace chrome with edge


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
//import java.util.Objects;
import org.openqa.selenium.JavascriptExecutor;

public class Main {
    // copied code that switches a window
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
                    //driver.switchTo().window(mainWindowHandle);
                    //driver.close();
                    break;
                }
            }
        }
        //System.out.println("---");
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver","C:\\Users\\hates\\Desktop\\stuff\\classes\\cen4072\\drivers\\msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        // browser
        //driver.get("https://www.google.com/");
        driver.get("https://earthengine.google.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        List<WebElement> buttons = driver.findElements(By.className("tab"));
        //System.out.println(buttons.size());
        buttons.get(1).click();
        switchWindow(driver);
        buttons = driver.findElements(By.className("button"));
        //System.out.println(buttons.size());
        buttons.get(1).click();
        List<WebElement> TextBox = driver.findElements(By.tagName("input"));
        //System.out.print(TextBox.size());
        int found = -1;
        for(int i=0;i<TextBox.size();i++) {
            if(Objects.equals(TextBox.get(i).getAttribute("data-label"), "datasets-filter"))
                found = i;
        }
        TextBox.get(found).sendKeys("fishing");
        Thread.sleep(1000);
        List<WebElement> results = driver.findElements(By.tagName("a"));
        for(int i=0;i<results.size();i++) {
            if(Objects.equals(results.get(i).getAttribute("data-category"), "ee-data-catalog")) {
                results.get(i).click();
                break;
            }
        }
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        buttons = driver.findElements(By.tagName("button"));
        for(int i=0;i<buttons.size();i++) {
            if(Objects.equals(buttons.get(i).getAttribute("data-title"), "Copy code sample")) {
                buttons.get(i).click();
                break;
            }
        }
        System.out.println("copied code");
        //driver.close();
    }
}