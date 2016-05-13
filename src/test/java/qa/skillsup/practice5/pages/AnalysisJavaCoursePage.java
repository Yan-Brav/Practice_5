package qa.skillsup.practice5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
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
    protected By popUpFieldsContent = By.xpath("//div[@class='field fieldlong']");
    protected By namesOfCoaches = By.xpath("//span[@class='name']");



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
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
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
    public List<String> getCoachesNames(){
        List<WebElement> elements = driver.findElements(namesOfCoaches);
        List<String> names = new ArrayList<String>();
        for (WebElement element : elements){
            names.add(element.getText());
        }
        return names;
    }
    public List<String> getFieldsFromPopUp(){
        List<WebElement> elements = driver.findElements(popUpFieldsContent);
        List<String> fieldsPopUp = new ArrayList<String>();
        for (WebElement element : elements){
            System.out.println(element.getText());
            fieldsPopUp.add(element.getText());
        }
        return fieldsPopUp;
    }

}
