package RunnerTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	public static WebDriver driver;
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)).pageLoadTimeout(Duration.ofSeconds(45));
	    driver.manage().deleteAllCookies();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    
	}

	@When("user enter valid userrname and valid password")
	public void user_enter_valid_userrname_and_valid_password(DataTable dataTable) {
		
		List<List<String>> list = dataTable.asLists();
		String Uname = list.get(0).get(0);
		System.out.println(Uname);
		
		String Pass = list.get(0).get(1);
		System.out.println(Pass);
		
		driver.findElement(By.name("username")).sendKeys(Uname);
		driver.findElement(By.name("password")).sendKeys(Pass);
		
	}
	@Then("user click login button")
	public void user_click_login_button() {
		
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}
	

	

	@Then("user capture title")
	public void user_capture_title() {
	  String a = driver.getTitle();
	  System.out.println(a);
	}


}
