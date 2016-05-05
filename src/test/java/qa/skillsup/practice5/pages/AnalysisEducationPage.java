package qa.skillsup.practice5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AnalysisEducationPage {
    private WebDriver driver;
    private String baseUrl = "http://skillsup.ua";
    private By moveToEducation = By.xpath("//div[@class='menuChapterInside']/a[1]");
    private By moveToCourses = By.xpath("//a[@href='http://skillsup.ua/training/courses.aspx']");
    private By jumpToJavaPage = By.xpath("//a[@href='http://skillsup.ua/training/courses/diving-into-java.aspx']");
    private By courseName = By.className("greenHeader");
    private By couchName = By.className("name");
    private By submitRequestButton = By.className("button");



    public AnalysisEducationPage(WebDriver driver) {
        this.driver = driver;
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);
    }

    public void jumpToJavaCoursePage(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(moveToEducation)).build().perform();
        action.moveToElement(driver.findElement(moveToCourses)).build().perform();
        action.click(driver.findElement(jumpToJavaPage)).build().perform();
    }
    public String getTextAboutCourseName(){
        WebElement element = driver.findElement(courseName);
        WebDriverWait webDriverWait = new WebDriverWait(driver,50);
        webDriverWait.until(ExpectedConditions.textToBe(courseName, "Diving into Java (Погружение в Java)"));
        return element.getText();
    }
    public String getTextAboutCouchName(String nameCouch){
        List<WebElement> elements = driver.findElements(couchName);
        String nameOfCouch = null;
        for (WebElement element : elements){
            if (nameCouch.equals(element.getText())){
                System.out.println(nameCouch + " present on this page");
                nameOfCouch = element.getText();
                break;
            }
        }
        return nameOfCouch;
    }
    public  void clickRequestButton(){
        Actions action = new Actions(driver);
        action.click(driver.findElement(submitRequestButton)).build().perform();
        /*WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        webDriverWait.until(ExpectedConditions.alertIsPresent());*/
        driver.switchTo().alert().accept();

    }

}
