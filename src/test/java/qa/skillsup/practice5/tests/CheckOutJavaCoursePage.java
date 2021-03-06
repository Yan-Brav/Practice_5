package qa.skillsup.practice5.tests;

import org.junit.Test;
import org.openqa.selenium.NotFoundException;
import qa.skillsup.practice5.pages.AnalysisJavaCoursePage;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class CheckOutJavaCoursePage extends PreviousActions{
    private AnalysisJavaCoursePage page;

    @Test
    public void checkOutJavaPage(){
        page = new AnalysisJavaCoursePage(driver);
        page.jumpToCoursePage();
        String courseName = "Diving into Java (���������� � Java)";

        assertEquals("This page doesn't contain Java course", courseName, page.getTextAboutCourseName());
    }
    @Test
    public void checkOutCouchAlGalFromJavaPage(){
        String couchAlGal = "��������� ����������";
        page = new AnalysisJavaCoursePage(driver);
        page.jumpToCoursePage();

        assertEquals("This coach doesn't present on this page", couchAlGal, page.getTextAboutCoachName(couchAlGal));
    }
    @Test
    public void checkOutCouchAlPedFromJavaPage(){
        String couchAlPed = "������� ���������";
        page = new AnalysisJavaCoursePage(driver);
        page.jumpToCoursePage();

        assertEquals("This coach doesn't present on this page", couchAlPed, page.getTextAboutCoachName(couchAlPed));
    }
    @Test
    public void checkOutCouchDenSkalFromJavaPage(){
        String couchDenSkal = "����� ��������";
        page = new AnalysisJavaCoursePage(driver);
        page.jumpToCoursePage();

        assertEquals("This coach doesn't present on this page", couchDenSkal, page.getTextAboutCoachName(couchDenSkal));
    }
    @Test
    public void popUpIsPresent()throws NotFoundException {
        page = new AnalysisJavaCoursePage(driver);
        page.jumpToCoursePage();
        try {
            assertTrue("PopUP is invisible",page.isPopUpPresent());
        } catch (NotFoundException ex) {
            System.out.println("PopUP is absent");
        }
    }
    @Test
    public void checkOutPopUpFieldsByName()throws NotFoundException{
        String nameOfField = "���";
        page = new AnalysisJavaCoursePage(driver);
        page.jumpToCoursePage();

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
        page.jumpToCoursePage();

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
        page.jumpToCoursePage();

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
        page.jumpToCoursePage();

        try {
            assertEquals("The field with this name wasn't found", nameOfField, page.clickRequestButton(nameOfField));
        }catch (NotFoundException ex){
            ex.printStackTrace();
        }
    }
    //It is alternative instead of test-methods checkOutCouchMarMelFromScrumPage() and checkOutCouchOlSimFromScrumPage()
    //It is more automated test-method
    //But if at least one assert was failed, execution will be stopped
    @Test
    public void checkOutCouchesFromJavaPage(){
        page = new AnalysisJavaCoursePage(driver);
        page.jumpToCoursePage();
        for (String name : page.getCoachesNames()){
            assertEquals(name + " isn't coach for Java", name, page.getTextAboutCoachName(name));
        }
    }
    //It is alternative instead of test-methods checkOutPopUpFieldsByName(), checkOutPopUpFieldsBySurName(),
    //checkOutPopUpFieldsByEmail and checkOutPopUpFieldsByPhoneNumber()
    //It is more automated test-method
    //But if at least one assert was failed, execution will be stopped
    @Test
    public void checkOutPopUpFields(){
        page = new AnalysisJavaCoursePage(driver);
        page.jumpToCoursePage();
        for (String field : page.getFieldsFromPopUp()){
            assertEquals("The field with name " +  field + " wasn't found", field, page.clickRequestButton(field));
        }
    }
}
