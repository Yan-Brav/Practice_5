package qa.skillsup.practice5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AnalysisSQLCoursePage {
    private WebDriver driver;
    private String baseUrl = "http://skillsup.ua";
    private By moveToEducation = By.xpath("//div[@class='menuChapterInside']/a[1]");
    private By moveToCourses = By.xpath("//a[@href='http://skillsup.ua/training/courses.aspx']");
    private By jumpToSQLPage = By.xpath("//a[@href='http://skillsup.ua/training/courses/sql-fundamentals.aspx']");
    private By courseName = By.className("greenHeader");
    private By coachName = By.className("name");
    private By submitRequestButton = By.className("button");
    private By alertContent = By.className("header");

    public AnalysisSQLCoursePage(WebDriver driver) {
        this.driver = driver;
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);
    }

    public void jumpToSQLCoursePage() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(moveToEducation)).build().perform();
        action.moveToElement(driver.findElement(moveToCourses)).build().perform();
        action.click(driver.findElement(jumpToSQLPage)).build().perform();
    }

    public String getTextAboutCourseName() {
        WebElement element = driver.findElement(courseName);
        /*WebDriverWait webDriverWait = new WebDriverWait(driver,50);
        webDriverWait.until(ExpectedConditions.textToBe(courseName, "SQL Fundamentals "));*/
        return element.getText();
    }

    public String getTextAboutCoachName(String nameCoach) {
        List<WebElement> elements = driver.findElements(coachName);
        String nameOfCoach = null;
        for (WebElement element : elements) {
            if (nameCoach.equals(element.getText())) {
                System.out.println(nameCoach + " present on this page");
                nameOfCoach = element.getText();
                break;
            }
        }
        return nameOfCoach;
    }
    public  String clickRequestButton(String value){
        Actions action = new Actions(driver);
        action.click(driver.findElement(submitRequestButton)).build().perform();
        String windowId = driver.getWindowHandle();
        String fieldName = null;
        List<WebElement> elements = driver.switchTo().window(windowId).findElements(alertContent);
        for (WebElement element : elements){
            if (element.getText().equals(value)){
                fieldName = element.getText();
                break;
            }
        }
        return fieldName;
    }
}
