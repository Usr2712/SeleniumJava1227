package StepDefinitions;

import Pagescode.WriteDataCode;
import io.cucumber.java.en.And;

import java.io.IOException;

public class WriteData {

    WriteDataCode writeDataCode = new WriteDataCode(DriverInitialization.getDriver());


    @And("user write data")
    public void userWriteData() throws IOException {


writeDataCode.retrieveFirstColumnValues();



    }

}
