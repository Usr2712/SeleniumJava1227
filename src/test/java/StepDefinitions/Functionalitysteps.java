package StepDefinitions;


import Pagescode.FunctionalityCheck;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Functionalitysteps {


    FunctionalityCheck functionalityCheck = new FunctionalityCheck(DriverInitialization.getDriver());

    @And("user Drags and drops")
    public void userDragsAndDrops() throws InterruptedException, IOException {

        functionalityCheck.DragAndDrop();


    }

    @And("user Resize")
    public void userResize() throws IOException, InterruptedException {

        functionalityCheck.Resize();
    }


    @And("user selects Date from calendar {string} and {string} and \"{}")
    public void userSelectsDateFromCalendarAndAnd(String date, String year, String month) throws Throwable {


        functionalityCheck.CalendarTest(date,year,month);
    }

    @And("user selects Date from calendar using datatable")
    public void userSelectsDateFromCalendarUsingDatatable(DataTable dataTable) throws IOException, InterruptedException {

        List<Map<String, String>> calendardata = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> data : calendardata) {
            String date = data.get("Date");
            String year = data.get("Year");
            String Month = data.get("Month");

            functionalityCheck.CalendarTest(date,year,Month);


        }

      /* @And("user selects Date from calendar")
    public void userSelectsDateFromCalendar() throws InterruptedException, IOException {

        functionalityCheck.CalendarTest();
    }*/
}


}