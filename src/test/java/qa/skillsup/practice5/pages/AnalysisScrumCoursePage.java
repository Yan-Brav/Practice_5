package qa.skillsup.practice5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AnalysisScrumCoursePage extends AnalysisJavaCoursePage{

    private WebDriver driver;
    private By jumpToScrumPage = By.xpath("//a[@href='http://skillsup.ua/training/courses/diving-into-scrum.aspx']");


    public AnalysisScrumCoursePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);
    }

    public void jumpToCoursePage() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(moveToEducation)).build().perform();
        action.moveToElement(driver.findElement(moveToCourses)).build().perform();
        action.click(driver.findElement(jumpToScrumPage)).build().perform();
    }

    public String getTextAboutCourseName() {
        WebElement element = driver.findElement(courseName);
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
    public boolean isPopUpPresent(){
        return driver.findElement(submitRequestButton).isDisplayed();
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
