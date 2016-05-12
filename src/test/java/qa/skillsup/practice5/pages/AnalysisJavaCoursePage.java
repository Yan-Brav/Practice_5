package qa.skillsup.practice5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AnalysisJavaCoursePage {
    private WebDriver driver;
    protected String baseUrl = "http://skillsup.ua";
    protected By moveToEducation = By.xpath("//div[@class='menuChapterInside']/a[1]");
    protected By moveToCourses = By.xpath("//a[@href='http://skillsup.ua/training/courses.aspx']");
    private By jumpToJavaPage = By.xpath("//a[@href='http://skillsup.ua/training/courses/diving-into-java.aspx']");
    protected By courseName = By.className("greenHeader");
    protected By coachName = By.className("name");
    protected By submitRequestButton = By.className("button");
    protected By alertContent = By.className("header");



    public AnalysisJavaCoursePage(WebDriver driver) {
        this.driver = driver;
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);
    }

    public void jumpToCoursePage(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(moveToEducation)).build().perform();
        action.moveToElement(driver.findElement(moveToCourses)).build().perform();
        action.click(driver.findElement(jumpToJavaPage)).build().perform();
    }
    public String getTextAboutCourseName(){
        WebElement element = driver.findElement(courseName);
        return element.getText();
    }
    public String getTextAboutCoachName(String nameCoach){
        List<WebElement> elements = driver.findElements(coachName);
        String nameOfCouch = null;
            for (WebElement element : elements){
            if (nameCoach.equals(element.getText())){
                System.out.println(nameCoach + " present on this page");
                nameOfCouch = element.getText();
                break;
            }
        }
        return nameOfCouch;
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
