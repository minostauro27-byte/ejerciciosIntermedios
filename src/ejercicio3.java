import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ejercicio3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://www.automationexercise.com/products");

            WebElement tirulo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));
            tirulo.sendKeys("jeans");

            WebElement boton = driver.findElement(By.id("submit_search"));
            boton.click();

            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".title.text-center"), "SEARCHED PRODUCTS"));

            List<WebElement> productos = driver.findElements(By.cssSelector(".productinfo p"));
            int cantidad = productos.size();

            productos.forEach(prod -> System.out.println(prod.getText()));

            boolean coincidencia = productos.stream()
                    .allMatch(prod -> prod.getText().toLowerCase().contains("jeans"));

            if (cantidad > 0 && coincidencia) {
                System.out.println("La prueba fue exitosa");
            } else {
                System.out.println("La prueba fallo");
            }
        } finally {
            driver.quit();
        }
    }
}