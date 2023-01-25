package org.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LaunchAPIDemo {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability("appPackage", "io.appium.android.apis");
        cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
                cap);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@text='Continue']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@text='OK']")).click();
        Thread.sleep(2000);

        if (driver.findElementByAccessibilityId("Accessibility").isDisplayed()) {
            System.out.println("The element is visible");
        } else {
            System.out.println("The element is not visible");
        }
        Thread.sleep(2000);

        driver.findElementByAccessibilityId("Accessibility").click();
        Thread.sleep(2000);

        if (driver.findElement(By.xpath("//*[@text='Accessibility Node Provider']")).isDisplayed()
                && driver.findElement(By.xpath("//*[@text='Accessibility Node Querying']")).isDisplayed()) {
            System.out.println("The element is visible");
        } else {
            System.out.println("The element is not visible");
        }

        driver.quit();

    }

}
