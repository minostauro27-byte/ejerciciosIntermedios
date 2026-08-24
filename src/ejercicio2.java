import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ejercicio2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       try {
           driver.get("https://bstackdemo.com/");

           wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shelf-item")));

           List<WebElement> productosIniciales = driver.findElements(By.cssSelector(".shelf-item"));
           int cantInicial = productosIniciales.size();

           WebElement inputSamsung = driver.findElement(By.cssSelector("input[value='Samsung']"));
           WebElement labelSamsung = driver.findElement(By.xpath("//span[text()='Samsung']"));

           labelSamsung.click();
           inputSamsung.isSelected();

           wait.until(ExpectedConditions.stalenessOf(productosIniciales.get(0)));

           List<WebElement> productosFiltrados = driver.findElements(By.cssSelector(".shelf-item"));
           int cantFinal = productosFiltrados.size();

           for (WebElement producto : productosFiltrados) {
               System.out.println(producto.findElement(By.cssSelector(".shelf-item__title")).getText());
           }

           if (cantFinal < cantInicial) {
               System.out.println("La prueba fue exitosa");
           } else {
               System.out.println("La prueba fallo");
           }
       }finally {
           driver.quit();
       }


    }
}