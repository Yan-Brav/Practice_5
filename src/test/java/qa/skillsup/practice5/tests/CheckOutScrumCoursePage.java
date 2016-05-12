package qa.skillsup.practice5.tests;

import org.junit.Test;
import org.openqa.selenium.NotFoundException;
import qa.skillsup.practice5.pages.AnalysisScrumCoursePage;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class CheckOutScrumCoursePage extends PreviousActions {
    private AnalysisScrumCoursePage pageScrum;

    @Test
    public void checkOutScrumPage(){
        pageScrum = new AnalysisScrumCoursePage(driver);
        pageScrum.jumpToCoursePage();
        String courseName = "Diving into Scrum (���������� � Scrum)";

        assertEquals("This page doesn't contain Scrum course", courseName, pageScrum.getTextAboutCourseName());
    }
    @Test
    public void checkOutCouchMarMelFromScrumPage(){
        String couchMarMel = "������ �������";
        pageScrum = new AnalysisScrumCoursePage(driver);
        pageScrum.jumpToCoursePage();

        assertEquals("This couch doesn't present on this page", couchMarMel, pageScrum.getTextAboutCoachName(couchMarMel));
    }
    @Test
    public void checkOutCouchOlSimFromScrumPage(){
        String couchOlSim = "����� ������";
        pageScrum = new AnalysisScrumCoursePage(driver);
        pageScrum.jumpToCoursePage();

        assertEquals("This couch doesn't present on this page", couchOlSim, pageScrum.getTextAboutCoachName(couchOlSim));
    }
    @Test
    public void popUpIsPresent()throws NotFoundException {
        pageScrum = new AnalysisScrumCoursePage(driver);
        pageScrum.jumpToCoursePage();
        try {
            assertTrue("PopUp is invisible",pageScrum.isPopUpPresent());
        } catch (NotFoundException ex) {
            System.out.println("PopUp is absent");
        }
    }
    @Test
    public void checkOutPopUpFieldsByName()throws NotFoundException{
        String nameOfField = "���";
        pageScrum = new AnalysisScrumCoursePage(driver);
        pageScrum.jumpToCoursePage();

        try {
            assertEquals("The field with this name wasn't found", nameOfField, pageScrum.clickRequestButton(nameOfField));
        }catch (NotFoundException ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void checkOutPopUpFieldsBySurName()throws NotFoundException{
        String nameOfField = "�������";
        pageScrum = new AnalysisScrumCoursePage(driver);
        pageScrum.jumpToCoursePage();

        try {
            assertEquals("The field with this name wasn't found", nameOfField, pageScrum.clickRequestButton(nameOfField));
        }catch (NotFoundException ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void checkOutPopUpFieldsByEmail()throws NotFoundException{
        String nameOfField = "����������� �����";
        pageScrum = new AnalysisScrumCoursePage(driver);
        pageScrum.jumpToCoursePage();

        try {
            assertEquals("The field with this name wasn't found", nameOfField, pageScrum.clickRequestButton(nameOfField));
        }catch (NotFoundException ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void checkOutPopUpFieldsByPhoneNumber()throws NotFoundException{
        String nameOfField = "�������";
        pageScrum = new AnalysisScrumCoursePage(driver);
        pageScrum.jumpToCoursePage();

        try {
            assertEquals("The field with this name wasn't found", nameOfField, pageScrum.clickRequestButton(nameOfField));
        }catch (NotFoundException ex){
            ex.printStackTrace();
        }
    }
}
