package qa.skillsup.practice5.tests;

import org.junit.Test;
import org.openqa.selenium.NoAlertPresentException;
import qa.skillsup.practice5.pages.AnalysisEducationPage;

import static junit.framework.TestCase.assertEquals;

public class CheckOutJavaCoursePage extends PreviousActions{
    private AnalysisEducationPage page;

    @Test
    public void checkOutJavaPage(){
        page = new AnalysisEducationPage(driver);
        page.jumpToJavaCoursePage();
        String courseName = "Diving into Java (Погружение в Java)";

        assertEquals("This page doesn't contain Java course", courseName, page.getTextAboutCourseName());
    }
    @Test
    public void checkOutCoucheAlGalFromJavaPage(){
        String couchAlGal = "Александр Галковский";
        page = new AnalysisEducationPage(driver);
        page.jumpToJavaCoursePage();

        assertEquals("This couch doesn't present on this page", couchAlGal, page.getTextAboutCouchName(couchAlGal));
    }
    @Test
    public void checkOutCoucheAlPedFromJavaPage(){
        String couchAlPed = "Алексей Педоренко";
        page = new AnalysisEducationPage(driver);
        page.jumpToJavaCoursePage();

        assertEquals("This couch doesn't present on this page", couchAlPed, page.getTextAboutCouchName(couchAlPed));
    }
    @Test
    public void checkOutCoucheDenSkalFromJavaPage(){
        String couchDenSkal = "Денис Скаленко";
        page = new AnalysisEducationPage(driver);
        page.jumpToJavaCoursePage();

        assertEquals("This couch doesn't present on this page", couchDenSkal, page.getTextAboutCouchName(couchDenSkal));
    }
    @Test(expected = NoAlertPresentException.class)
    public void checkOutPopUpExist(){
        page = new AnalysisEducationPage(driver);
        page.jumpToJavaCoursePage();
        page.clickRequestButton();
        /*driver.switchTo().alert();
       // assertTrue("The PopUp is absent", IsAlertPresent);

        assertTrue(Boolean.parseBoolean(driver.getWindowHandle()));
*/
    }
}
