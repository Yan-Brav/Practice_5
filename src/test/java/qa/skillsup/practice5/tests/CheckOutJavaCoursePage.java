package qa.skillsup.practice5.tests;

import org.junit.Test;
import org.openqa.selenium.NotFoundException;
import qa.skillsup.practice5.pages.AnalysisJavaCoursePage;

import static junit.framework.TestCase.assertEquals;

public class CheckOutJavaCoursePage extends PreviousActions{
    private AnalysisJavaCoursePage page;

    @Test
    public void checkOutJavaPage(){
        page = new AnalysisJavaCoursePage(driver);
        page.jumpToJavaCoursePage();
        String courseName = "Diving into Java (���������� � Java)";

        assertEquals("This page doesn't contain Java course", courseName, page.getTextAboutCourseName());
    }
    @Test
    public void checkOutCouchAlGalFromJavaPage(){
        String couchAlGal = "��������� ����������";
        page = new AnalysisJavaCoursePage(driver);
        page.jumpToJavaCoursePage();

        assertEquals("This couch doesn't present on this page", couchAlGal, page.getTextAboutCoachName(couchAlGal));
    }
    @Test
    public void checkOutCouchAlPedFromJavaPage(){
        String couchAlPed = "������� ���������";
        page = new AnalysisJavaCoursePage(driver);
        page.jumpToJavaCoursePage();

        assertEquals("This couch doesn't present on this page", couchAlPed, page.getTextAboutCoachName(couchAlPed));
    }
    @Test
    public void checkOutCouchDenSkalFromJavaPage(){
        String couchDenSkal = "����� ��������";
        page = new AnalysisJavaCoursePage(driver);
        page.jumpToJavaCoursePage();

        assertEquals("This couch doesn't present on this page", couchDenSkal, page.getTextAboutCoachName(couchDenSkal));
    }
    @Test
    public void checkOutPopUpFieldsByName()throws NotFoundException{
        String nameOfField = "���";
        page = new AnalysisJavaCoursePage(driver);
        page.jumpToJavaCoursePage();

        try {
            assertEquals("The field with this name wasn't found", nameOfField, page.clickRequestButton(nameOfField));
        }catch (NotFoundException ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void checkOutPopUpFieldsBySurName()throws NotFoundException{
        String nameOfField = "�������";
        page = new AnalysisJavaCoursePage(driver);
        page.jumpToJavaCoursePage();

        try {
            assertEquals("The field with this name wasn't found", nameOfField, page.clickRequestButton(nameOfField));
        }catch (NotFoundException ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void checkOutPopUpFieldsByEmail()throws NotFoundException{
        String nameOfField = "����������� �����";
        page = new AnalysisJavaCoursePage(driver);
        page.jumpToJavaCoursePage();

        try {
            assertEquals("The field with this name wasn't found", nameOfField, page.clickRequestButton(nameOfField));
        }catch (NotFoundException ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void checkOutPopUpFieldsByPhoneNumber()throws NotFoundException{
        String nameOfField = "�������";
        page = new AnalysisJavaCoursePage(driver);
        page.jumpToJavaCoursePage();

        try {
            assertEquals("The field with this name wasn't found", nameOfField, page.clickRequestButton(nameOfField));
        }catch (NotFoundException ex){
            ex.printStackTrace();
        }
    }
}
