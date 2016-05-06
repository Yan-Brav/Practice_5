package qa.skillsup.practice5.tests;

import org.junit.Test;
import org.openqa.selenium.NotFoundException;
import qa.skillsup.practice5.pages.AnalysisSQLCoursePage;

import static junit.framework.TestCase.assertEquals;

public class CheckOutSQLCoursePage extends PreviousActions{
        private AnalysisSQLCoursePage pageSQL;

    @Test
        public void checkOutSQLPage(){
            pageSQL = new AnalysisSQLCoursePage(driver);
            pageSQL.jumpToSQLCoursePage();
            String courseName = "SQL Fundamentals";

            assertEquals("This page doesn't contain SQL course", courseName, pageSQL.getTextAboutCourseName());
        }
    @Test
        public void checkOutCoachAlPedFromSQLPage(){
            String coachAlPed = "Алексей Педоренко";
            pageSQL = new AnalysisSQLCoursePage(driver);
            pageSQL.jumpToSQLCoursePage();

            assertEquals("This couch doesn't present on this page", coachAlPed, pageSQL.getTextAboutCoachName(coachAlPed));
    }
    @Test
        public void checkOutCoachDenSkalFromSQLPage(){
            String coachDenSkal = "Денис Скаленко";
            pageSQL = new AnalysisSQLCoursePage(driver);
            pageSQL.jumpToSQLCoursePage();

            assertEquals("This couch doesn't present on this page", coachDenSkal, pageSQL.getTextAboutCoachName(coachDenSkal));
    }
    @Test
        public void checkOutCouchLinOlFromSQLPage(){
            String couchLinOl = "Лина Олейник";
            pageSQL = new AnalysisSQLCoursePage(driver);
            pageSQL.jumpToSQLCoursePage();

            assertEquals("This couch doesn't present on this page", couchLinOl, pageSQL.getTextAboutCoachName(couchLinOl));
    }
    @Test
        public void checkOutPopUpFieldsByName()throws NotFoundException {
            String nameOfField = "Имя";
            pageSQL = new AnalysisSQLCoursePage(driver);
            pageSQL.jumpToSQLCoursePage();

            try {
                assertEquals("The field with this name wasn't found", nameOfField, pageSQL.clickRequestButton(nameOfField));
            }catch (NotFoundException ex){
                ex.printStackTrace();
            }
    }
    @Test
    public void checkOutPopUpFieldsBySurName()throws NotFoundException{
        String nameOfField = "Фамилия";
        pageSQL = new AnalysisSQLCoursePage(driver);
        pageSQL.jumpToSQLCoursePage();

        try {
            assertEquals("The field with this name wasn't found", nameOfField, pageSQL.clickRequestButton(nameOfField));
        }catch (NotFoundException ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void checkOutPopUpFieldsByEmail()throws NotFoundException{
        String nameOfField = "Электронная почта";
        pageSQL = new AnalysisSQLCoursePage(driver);
        pageSQL.jumpToSQLCoursePage();

        try {
            assertEquals("The field with this name wasn't found", nameOfField, pageSQL.clickRequestButton(nameOfField));
        }catch (NotFoundException ex){
            ex.printStackTrace();
        }
    }
    @Test
    public void checkOutPopUpFieldsByPhoneNumber()throws NotFoundException{
        String nameOfField = "Телефон";
        pageSQL = new AnalysisSQLCoursePage(driver);
        pageSQL.jumpToSQLCoursePage();

        try {
            assertEquals("The field with this name wasn't found", nameOfField, pageSQL.clickRequestButton(nameOfField));
        }catch (NotFoundException ex){
            ex.printStackTrace();
        }
    }
}
