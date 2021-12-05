package StepDefinition;

import com.mysql.cj.protocol.Resultset;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class SaasInitial {
    @Given("Launch the browser")
    public void launch_the_browser() throws InterruptedException {
        WebDriver driver;
        String driverpath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", driverpath+"/src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com.au");
        System.out.println(driver.getTitle());
        Thread.sleep(1000);
        driver.quit();
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }

    @And("I Launch MYSQLDB")
    public void i_launch_mysqldb() {
        // Write code here that turns the phrase above into concrete actions
        Connection Connector;
        String url = "jdbc:mysql://localhost:3306/SGR";
        String Username = "root";
        String pwd = "Mysqldb1";
//        String Query1 = "Insert into UserDetails(firstname, emailid) values(101,'ram')";
        String Query1 = "Select * from UserDetails";
        try {
            Connector = DriverManager.getConnection(url,Username, pwd);
            Statement statement = Connector.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet records = statement.executeQuery(Query1);
            records.first();
            String ss = records.getString(2);
            System.out.println("SS value is " + ss);
            while (records.next()){
                String Fname = records.getString("firstname");
                System.out.println(Fname);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Given("I Print the {string} and {string}")
    public void i_print_the_and(String Username, String Email) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Value : "+Username+"\t Email : "+Email);
    }
}
