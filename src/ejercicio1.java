import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ejercicio1 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");
            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my-text-id")));
            name.sendKeys("Maikoll y Fabian Torres");

            WebElement contrasenia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-password")));
            contrasenia.sendKeys("12345abcdef");

            WebElement texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-textarea")));
            texto.sendKeys("Hola como estas");

            WebElement List = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-select")));

            Select Lista = new Select(List);
            Lista.selectByVisibleText("One");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='checkbox']")));
            List<WebElement> casilla = driver.findElements(By.cssSelector("input[type='checkbox']"));

            WebElement c1 = casilla.get(0);
            WebElement c2 = casilla.get(1);

            if (c1.isSelected()){
                c1.click();
            }
            if (!c2.isSelected()){
                c2.click();
            }

            WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
            boton.click();
            WebElement mensaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

            String mensaje = mensaj.getText();

            if (mensaje.contains("Received!")){
                System.out.println("En el mensaje obtenido aparece " + mensaje + " la prueba fue exitosa ");
            }else {
                System.out.println("La prueba no fue exitosa" );
            }


        }finally {
            driver.quit();

        }

    }


}
