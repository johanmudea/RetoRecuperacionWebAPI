package co.com.sofka.stepdefinition.common;

import org.apache.log4j.PropertyConfigurator;
import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static co.com.sofka.util.Log4jValues.USER_DIR;

public class ServiceSetUp {

    protected static final String BASE_URI = "https://www.etnassoft.com/api/v1";
    protected static final String RESOURCE = "/get/?any_tags=[html,css,javascript]&amp;order=newest";


    protected void generalSetUp(){
        setUpLog4j2();
    }

    private void setUpLog4j2(){
        PropertyConfigurator.configure(USER_DIR.getValue()  + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}