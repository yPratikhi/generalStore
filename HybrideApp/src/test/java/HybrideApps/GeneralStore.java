package HybrideApps;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.aspectj.weaver.tools.Trace;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralStore extends Capabilities{
	//remember android driver is a class and android element is also a class for the specific element
	// driver is a variable which knows that he has to interact with the android driver and android element
	// we will use driver in the codes which will define that by the use of android driver we’ll click on android element

AndroidDriver<AndroidElement>driver;

@BeforeTest
public void bt() throws MalformedURLException  {
driver=cap();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Test(enabled = false)
public void addToCart() {
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	
	 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));
	 driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"India\")")).click();
	 
	 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Pratik");
	 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioMale")).click();
	 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	 
	 driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0).click();
	 driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0).click();
	 
	 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))"));
	 driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(1).click();
	 
	 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
}

@Test(enabled = false)
public void printPrice() {

	 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Pratik");
	 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioMale")).click();
	 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	 
	 driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0).click();
	 driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0).click();
	 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	 
	 String p1= driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"$160.97\")")).getText();
	 String p2= driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"$120.0\")")).getText();

	 String totalPrice=driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	 
	 
	 System.out.println(p1);
	 System.out.println(p2);
	 System.out.println(totalPrice);
	 
	 String pro1= p1.substring(1);
	 String pro2= p2.substring(1);
	 String tPrice= totalPrice.substring(2);
	 
	 Double P1= Double.parseDouble(pro1);
	 Double P2= Double.parseDouble(pro2);
	 Double tPrice2= Double.parseDouble(tPrice);
	 
	 Double addPrice = P1+P2;
	 
	 if(addPrice.equals(tPrice2)) {
		 System.out.println("Cost is Maching");
	 }else {
		 System.out.println("Cost is not Maching");
	 }
	 
}
@Test(enabled = true)
public void vistWeb() {
	 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Pratik");
	 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioMale")).click();
	 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	 
	 driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0).click();
	 driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0).click();
	 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	 
	 driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Send me e-mails on discounts related to selected products in future\")")).click();
	 
	 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
}
}
