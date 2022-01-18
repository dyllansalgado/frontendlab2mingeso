import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumTest {
    // Se declara el driver para el navegador Web
    private static WebDriver driver;

    // Antes de hace cualquier test se instancia el driver de firefox
    // Y se configura el wait implicito
    @BeforeAll
    public static void setupDriver(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Despues de ejecutar todos los test se cierra el driver del navegador Web
    @AfterAll
    public static void tearDownDriver(){
        if (driver != null) {
            driver.quit();
        }
    }

    // Despues de cada test se espera un tiempo de 5 segundos
    // Para ver el resultado y dejar que los datos se actualicen
    @AfterEach
    public void afterSleep(){
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie) {
        }
    }
    @Test
    @Order(1)
    public void initWeb() {
        // Se dirige a la página de Log In
        driver.get("http://localhost:3000/home");
        // Se busca el boton de inicio
        WebElement iniciar = driver.findElement(By.linkText("Ir a productos"));
        iniciar.click();
    }

    @Test
    @Order(2)
    public void addFailProducto() {

        // Se busca en la pagina de productos, el boton agregar productos
        driver.get("http://localhost:3000/productos");
        // Se busca el boton agregar
        WebElement agregar = driver.findElement(By.xpath("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"btn-primary\", \" \" ))]"));
        agregar.click();
        // Se agrega el nombre de producto
        WebElement nombre = driver.findElement(By.id("nombre"));
        nombre.sendKeys("Nombre_5");
        // Se agrega el codigo del producto
        WebElement codigo = driver.findElement(By.id("codigo"));
        codigo.sendKeys("Codigo_5");
        // Se agrega la fecha
        WebElement date = driver.findElement(By.id("fechaVencimiento"));
        date.click();
        date.sendKeys("2022-01-01");
        // Se agrega la categoria del producto
        WebElement cat = driver.findElement(By.id("categoria"));
        cat.sendKeys("2");
        // Se agrega el precio del producto
        WebElement precio = driver.findElement(By.id("precio"));
        precio.sendKeys("5500");
        precio.sendKeys(Keys.ENTER);
    }
    @Test
    @Order(3)
    public void addProducto() {
        // Se busca en la pagina de productos, el boton agregar productos
        driver.get("http://localhost:3000/productos");
        // Se busca el boton agregar
        WebElement agregar = driver.findElement(By.xpath("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"btn-primary\", \" \" ))]"));
        agregar.click();
        // Se agrega el nombre de producto
        WebElement nombre = driver.findElement(By.id("nombre"));
        nombre.sendKeys("Nombre_4");
        // Se agrega el codigo del producto
        WebElement codigo = driver.findElement(By.id("codigo"));
        codigo.sendKeys("Codigo_4");
        // Se agrega la fecha
        WebElement date = driver.findElement(By.id("fechaVencimiento"));
        date.click();
        date.sendKeys("2022-01-01");
        // Se agrega la categoria del producto
        WebElement cat = driver.findElement(By.id("categoria"));
        cat.sendKeys("1");
        // Se agrega el precio del producto
        WebElement precio = driver.findElement(By.id("precio"));
        precio.sendKeys("4500");
        precio.sendKeys(Keys.ENTER);
    }






}





