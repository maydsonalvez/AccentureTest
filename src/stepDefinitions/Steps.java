package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import auxiliar.ClasseAuxiliar;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	private WebDriver driver;
	private ClasseAuxiliar dsl;
	
	@Given("^Open the Google Chrome and launch the application$")
	public void open_Chrome_launch_application() throws Throwable
	{
		//Initialize the Chrome Driver
		System.setProperty("webdriver.chrome.driver", "..\\AccentureTestMaydson\\Drivers\\chromedriver_v93.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
						
		//Launch the application
		driver.get("http://sampleapp.tricentis.com/101/app.php");
		dsl = new ClasseAuxiliar(driver);
	}
	
	@When("^Fill the forms, validate the outcomes and send the quote$")
	public void fill_forms_validate_outcomes_send_quote() throws Throwable
	{
		/********* Fill the 1st form ("Enter Vehicle Data") *********/ 
		
		
		dsl.validaMsg(By.className("counter"), "12");		
		dsl.selectOptCombo(By.id("make"), "BMW");
		dsl.validaMsg(By.className("counter"), "11");	
		dsl.selectOptCombo(By.id("model"), "Scooter");
		dsl.validaMsg(By.className("counter"), "10");	
		dsl.inserirTexto(By.id("cylindercapacity"), "1000");
		dsl.validaMsg(By.className("counter"), "9");	
		dsl.inserirTexto(By.id("engineperformance"), "500");
		dsl.validaMsg(By.className("counter"), "8");
		dsl.inserirTexto(By.id("dateofmanufacture"), "09/01/2021");
		dsl.validaMsg(By.className("counter"), "7");	
		dsl.selectOptCombo(By.id("numberofseats"), "2");
		
		//RADIO BUTTON
		WebElement form1radio1 = driver.findElement(By.className("ideal-radio"));
		form1radio1.click();
		form1radio1.isSelected();
		
		dsl.validaMsg(By.className("counter"), "6");
		dsl.selectOptCombo(By.id("numberofseatsmotorcycle"), "2");
		dsl.validaMsg(By.className("counter"), "5");
		dsl.selectOptCombo(By.id("fuel"), "Gas");
		dsl.validaMsg(By.className("counter"), "4");
		dsl.inserirTexto(By.id("payload"), "120");
		dsl.validaMsg(By.className("counter"), "3");
		dsl.inserirTexto(By.id("totalweight"), "300");
		dsl.validaMsg(By.className("counter"), "2");
		dsl.inserirTexto(By.id("listprice"), "15000");
		dsl.validaMsg(By.className("counter"), "1");
		dsl.inserirTexto(By.id("licenseplatenumber"), "1111111111");
		dsl.inserirTexto(By.id("annualmileage"), "50000");
		dsl.validaMsg(By.className("counter"), "0");
		
		//Click on button "Next"
		dsl.clicarObjeto(By.id("nextenterinsurantdata"));
		
		
		/********* Fill the 2nd form ("Enter Insurant Data") ************/
		
		
		// Change to the window "Enter Insurant Data");
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		System.out.println((String)driver.getWindowHandles().toArray()[0]);
		
		dsl.validaMsg(By.xpath("//a[@id='enterinsurantdata']/span"), "7");
		dsl.inserirTexto(By.id("firstname"), "Maydson");
		dsl.validaMsg(By.xpath("//a[@id='enterinsurantdata']/span"), "6");
		dsl.inserirTexto(By.id("lastname"), "Ribeiro");
		dsl.validaMsg(By.xpath("//a[@id='enterinsurantdata']/span"), "5");
		dsl.inserirTexto(By.id("birthdate"), "09/27/1991");
		dsl.validaMsg(By.xpath("//a[@id='enterinsurantdata']/span"), "4");
		
		//RADIO
		WebElement oRadioBtn = driver.findElement(By.xpath("//form[@id='insurance-form']/div/section[2]/div[4]/p/label/span")); 
		System.out.println(oRadioBtn);
		oRadioBtn.click();
		
		dsl.inserirTexto(By.id("streetaddress"), "Q 09 Casa 115, Setor Oeste, Gama");
		dsl.selectOptCombo(By.id("country"), "Brazil");
		dsl.validaMsg(By.xpath("//a[@id='enterinsurantdata']/span"), "3");
		dsl.inserirTexto(By.id("zipcode"), "72425090");
		dsl.validaMsg(By.xpath("//a[@id='enterinsurantdata']/span"), "2");
		dsl.inserirTexto(By.id("city"), "Brasilia");
		dsl.selectOptCombo(By.id("occupation"), "Employee");
		dsl.validaMsg(By.xpath("//a[@id='enterinsurantdata']/span"), "1");
		
		// HOBBIES
		dsl.clicarObjeto(By.xpath("//form[@id='insurance-form']/div/section[2]/div[10]/p/label/span"));
		dsl.clicarObjeto(By.xpath("//form[@id='insurance-form']/div/section[2]/div[10]/p/label[3]/span"));
		dsl.clicarObjeto(By.xpath("//form[@id='insurance-form']/div/section[2]/div[10]/p/label[4]/span"));
		dsl.validaMsg(By.xpath("//a[@id='enterinsurantdata']/span"), "0");
		
		dsl.inserirTexto(By.id("website"), "https://www.accenture.com/br-pt");
		
		//Click on button "Next"
		dsl.clicarObjeto(By.id("nextenterproductdata"));
		
		
		/************ Fill the 3rd form ("Enter Product Data") ************/
		
		
		// Change to the window "Enter Product Data"
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		System.out.println((String)driver.getWindowHandles().toArray()[0]);
		
		dsl.validaMsg(By.xpath("//a[@id='enterproductdata']/span"), "6");
		dsl.inserirTexto(By.id("startdate"), "01/06/2022");
		dsl.validaMsg(By.xpath("//a[@id='enterproductdata']/span"), "5");
		dsl.selectOptCombo(By.id("insurancesum"), "3.000.000,00");
		dsl.validaMsg(By.xpath("//a[@id='enterproductdata']/span"), "4");
		dsl.selectOptCombo(By.id("meritrating"), "Bonus 6");
		dsl.validaMsg(By.xpath("//a[@id='enterproductdata']/span"), "3");
		dsl.selectOptCombo(By.id("damageinsurance"), "Full Coverage");
		dsl.validaMsg(By.xpath("//a[@id='enterproductdata']/span"), "2");
		
		//RADIO
		dsl.clicarObjeto(By.xpath("//form[@id='insurance-form']/div/section[3]/div[5]/p/label/span"));
		dsl.validaMsg(By.xpath("//a[@id='enterproductdata']/span"), "1");

		dsl.selectOptCombo(By.id("courtesycar"), "Yes");
		dsl.validaMsg(By.xpath("//a[@id='enterproductdata']/span"), "0");
		
		// Click on button "Next"
		dsl.clicarObjeto(By.id("nextselectpriceoption"));
		
		
		/************ Fill the 4th form ("Select Price Option") ************/
		
		
		// Change to the window "Select Price Option"
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		System.out.println((String)driver.getWindowHandles().toArray()[0]);
		
		dsl.validaMsg(By.xpath("//a[@id='selectpriceoption']/span"), "1");
		
		// Validate the grid with the insurance options:
		// TITLES:
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr/td"), "Price per Year ($)");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[2]/td"), "Online Claim");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[3]/td"), "Claims Discount (%)");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[4]/td"), "Worldwide Cover");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tfoot/tr/th"), "Select Option");
		// SILVER:
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/thead/tr/th[2]"), "Silver");
		dsl.validaMsg(By.xpath("//span[@id='selectsilver_price']"), "296.00");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[2]/td[2]"), "No");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[3]/td[2]"), "No");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[4]/td[2]"), "No");
		//GOLD:
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/thead/tr/th[3]"), "Gold");
		dsl.validaMsg(By.xpath("//span[@id='selectgold_price']"), "872.00");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[2]/td[3]"), "Submit");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[3]/td[3]"), "2");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[4]/td[3]"), "Limited");
		//PLATINUM:
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/thead/tr/th[4]"), "Platinum");
		dsl.validaMsg(By.xpath("//span[@id='selectplatinum_price']"), "1,712.00");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[2]/td[4]"), "Submit");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[3]/td[4]"), "5");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[4]/td[4]"), "Limited");
		//ULTIMATE:
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/thead/tr/th[5]"), "Ultimate");
		dsl.validaMsg(By.xpath("//span[@id='selectultimate_price']"), "3,262.00");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[2]/td[5]"), "Submit");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[3]/td[5]"), "10");
		dsl.validaMsg(By.xpath("//table[@id='priceTable']/tbody/tr[4]/td[5]"), "Unlimited");
		
		// Select insurance option
		dsl.clicarObjeto(By.xpath("//table[@id='priceTable']/tfoot/tr/th[2]/label[3]/span"));
		dsl.validaMsg(By.xpath("//a[@id='selectpriceoption']/span"), "0");
		
		// Click on button "Download Quote"
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("downloadquote")));
		dsl.clicarObjeto(By.id("downloadquote"));
		System.out.println("Realizou o download!");
		
		
		/************ Fill the 5th form ("Send Quote") ************/
		
		
		// Change to the window "Send Quote"
		WebDriverWait wait2 = new WebDriverWait(driver, 35);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("xLoaderQuote")));
		dsl.validaMsg(By.id("xLoaderQuote"), "Please, select a price option to send the quote.");
		dsl.clicarObjeto(By.xpath("//a[@id='selectpriceoption']"));
		dsl.clicarObjeto(By.xpath("//a[@id='sendquote']"));
		
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		System.out.println((String)driver.getWindowHandles().toArray()[0]);
		
		dsl.validaMsg(By.xpath("//a[@id='sendquote']/span"), "4");
		dsl.inserirTexto(By.id("email"), "teste@teste.com.br");
		dsl.inserirTexto(By.id("phone"), "61999999999");
		dsl.validaMsg(By.xpath("//a[@id='sendquote']/span"), "3");
		dsl.inserirTexto(By.id("username"), "maydson");
		dsl.validaMsg(By.xpath("//a[@id='sendquote']/span"), "2");
		dsl.inserirTexto(By.id("password"), "123456@aA");
		dsl.validaMsg(By.xpath("//a[@id='sendquote']/span"), "1");
		dsl.inserirTexto(By.id("confirmpassword"), "123456@aA");
		dsl.validaMsg(By.xpath("//a[@id='sendquote']/span"), "0");
		dsl.inserirTexto(By.id("Comments"), "Teste de preenchimento de formulários com Selenium e Cucumber.");
		
		//Click on button "Send"
		dsl.clicarObjeto(By.id("sendemail"));
		
		
		/************ Confirmation frame ************/
		
		// Validate the confirmation sent form frame
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[7]/div/button")));
		dsl.validaMsg(By.xpath("//h2"), "Sending e-mail success!");
		driver.findElement(By.xpath("//div[7]/div/button")).click();
	}
	
	@Then("^Close the browser$")
	public void close_browser() throws Throwable
	{
		// Close the browser
		driver.close();
	}

}
