import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Random;

public class test {
    @Test
    public void test2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://vynoteka.lt"); // opening the page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/a[2]")).click(); // closing cookies
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button")).click(); // confirming the age check

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25)); // waiting for the newsletter to show up
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/form/div[4]/div[2]/div/label/div[1]")).click(); // clicking on the i agree with the privacy policy checkmark


        String email = generateRandomEmail(); // generating random email
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/form/div[3]/div[2]/div/input")).sendKeys(email); // inputting the randomly generated email
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/form/div[5]/div[2]/div/button")).click(); // clicking subscribe

//        WebElement resultText = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[1]/p"));
//        Assert.assertEquals(resultText.getText(), "Ačiū, kad prenumeruojate!"); // checking if subscribed successfully

        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[2]/button")).click(); // closing the newsletter page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // waiting for the other ad to show up
        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/button")).click(); // closing the ad

        driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[3]/div/div/div/form/div[1]/div/input")).sendKeys("Marina alta blanco"); // searching for the specific wine
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement resultText = driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[3]/div/div/div/form/div[2]/div/div[2]/div/div/div/div/div[1]/div/div/a/span"));
        Assert.assertEquals(resultText.getText(), "Marina Alta Blanco 0,75 L"); // checking if the search works like its supposed to (we got the result what we wanted)

        driver.close(); // closing the app
    }

    @Test
    public void test3() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://vynoteka.lt"); //open page
        driver.manage().window().maximize(); // maximising the page

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //wait 3 seconds to load

        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button")).click(); //click on over 20 years old

        String name = generateRandomName(); //generate the random register info
        String lastname = generateRandomName();
        String email = generateRandomEmail();
        String password = generateRandomPassword();
        String pNumber = generateRandomPhoneNumber();

        driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[4]/nav/div[1]/button")).click(); // click on prisijungti
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1)); // wait to load
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div[1]/div/button")).click(); // click on register
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[1]/div/div[1]/input")).sendKeys(name); // input firstname
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[2]/div/div/input")).sendKeys(lastname); // input last name
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[1]/div/div/span[1]/button")).click(); //click on the year dropdown
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // wait for the dropdown to show
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[1]/div/div/span[2]/div/div/button[7]")).click(); // click on an option
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // wait for the dropdown to show
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[2]/div/div/span[1]/button")).click(); // click on the month dropdown
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // wait for the dropdown to show
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[2]/div/div/span[2]/div/div/button[2]")).click(); // click on an option
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // wait for the dropdown to show
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[3]/div/div/span[1]/button")).click(); // click on the day dropdown
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // wait for the dropdown to show
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[3]/div/div/span[2]/div/div/button[6]")).click(); // click on an option
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[4]/div/div[1]/input")).sendKeys(email); // input email
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[5]/div/div[1]/input")).sendKeys(pNumber); // input phone number
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[6]/div/div/input")).sendKeys(password); // input password
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[7]/div/div/input")).sendKeys(password); // input repeating password
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[1]/div/div[8]/div[1]/div/label")).click(); // click on the checkbox that you agree eula
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/a[2]")).click(); // click to close the cookies
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1)); // wait for the box to disappear
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/div/form/div[2]/div/div[2]/button")).click(); // click on complete registration
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25)); // wait for the popup ad to show
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[2]/button")).click(); // close the ad
        try { // wait for the timer to hit 30s
            Thread.sleep(13000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/div/div[2]/div/form/div[3]/div[2]/button")).click(); // click continue without confirming phone number
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait for the OTHER popup ad to show
        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/button")).click(); // close the ad
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[3]/div/div/div[1]/div/div[1]/div/nav/div[1]/div/button")).click(); // clicking on the wine tab
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[3]/div/div/div[1]/div/div[1]/div/nav/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div/nav/div[1]/a")).click(); // clicking on the "calm" wine
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // waiting to load
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/main/section/div/div[2]/div/div[1]/div[4]/div[1]/div/div/div[1]/a")).click(); // clicking on the first option
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[2]/section[1]/div/div/div/div/div/div[2]/div[2]/div[2]/div[2]/button")).click(); // adding it to cart
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[2]/div/div/div/div[1]/div/div[2]/div/ul/li[1]/button")).click(); // clicking send to home
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[1]/div[1]/div/div[1]")).click(); // clicking ordering to home
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[1]/div[1]/button")).click(); // clicking next button
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // waiting for address popup
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div[2]/div/div[1]/div/div/input")).sendKeys("Seinų g. 5, Kaunas"); // inputting the address
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div[2]/div/div[2]/button")).click(); // clicking search
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // waiting for the address to load
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div[2]/div/button")).click(); // clicking on the address
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // waiting for the button to popup
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/div/form/div[1]/div/button")).click(); // clicking on select the address
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // waiting for the next window to popup
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/div/form/div/button")).click(); // clicking save address
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/div/div/div[2]/div[4]/div[5]")).click(); // clicking on the time
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[2]/button")).click(); // clicking on reserve time
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[2]/div[3]/div[2]/button")).click(); // clicking on continue purchase
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[2]/section[1]/div/div/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div/button[2]")).click(); // adding another one to the cart
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[2]/div/div/div/div[1]/div/div[2]/div[2]/button")).click(); // continuing the order


//        driver.close(); // closing the app
        //fixing app
    }

    public static String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};
        String[] characters = {"abcdefghijklmnopqrstuvwxyz", "0123456789"};

        Random random = new Random();

        StringBuilder email = new StringBuilder();

        // Generate username part
        int usernameLength = random.nextInt(10) + 5; // Random length between 5 to 14 characters
        for (int i = 0; i < usernameLength; i++) {
            String characterSet = characters[random.nextInt(2)]; // Selecting either alphabets or numbers
            char randomChar = characterSet.charAt(random.nextInt(characterSet.length()));
            email.append(randomChar);
        }

        // Adding '@' symbol
        email.append("@");

        // Selecting random domain
        String randomDomain = domains[random.nextInt(domains.length)];
        email.append(randomDomain);

        return email.toString();
    }

    public static String generateRandomName() {
        String[] characters = {"abcdefghijklmnopqrstuvwxyz", "0123456789"};
        Random random = new Random();

        StringBuilder username = new StringBuilder();

        int usernameLength = random.nextInt(10) + 5; // Random length between 5 to 14 characters
        for (int i = 0; i < usernameLength; i++) {
            String characterSet = characters[random.nextInt(2)]; // Selecting either alphabets or numbers
            char randomChar = characterSet.charAt(random.nextInt(characterSet.length()));
            username.append(randomChar);
        }
        return username.toString();
    }

    public static String generateRandomPassword() {
        String[] characters = {"abcdefghijklmnopqrstuvwxyz", "0123456789"};
        Random random = new Random();

        StringBuilder password = new StringBuilder();

        int passwordLength = random.nextInt(15) + 10; // Random length between 6 to 14 characters
        for (int i = 0; i < passwordLength; i++) {
            String characterSet = characters[random.nextInt(2)]; // Selecting either alphabets or numbers
            char randomChar = characterSet.charAt(random.nextInt(characterSet.length()));
            password.append(randomChar);
        }
        return password.toString();

    }

    public static String generateRandomPhoneNumber() {
        String[] characters = {"0123456789"};
        Random random = new Random();

        StringBuilder phoneNumber = new StringBuilder("6");

        int phoneLength = 8;
        for (int i = 1; i < phoneLength; i++) {
            String characterSet = characters[random.nextInt(1)]; // Selecting either alphabets or numbers
            char randomChar = characterSet.charAt(random.nextInt(characterSet.length()));
            phoneNumber.append(randomChar);
        }

        return phoneNumber.toString();
    }
}
