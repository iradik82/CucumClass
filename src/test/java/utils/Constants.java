package utils;

import static utils.ConfigReader.prop;

public class Constants extends CommonMethods {

    public static final String CONFIGURATION_FILEPATH =
            System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
    public static final int EXPLICIT_WAIT = 20;
    public static final int IMPLICIT_WAIT = 10;

    public static final String TESTDATA_FILEPATH =
            System.getProperty("user.dir") + "/src/test/resources/testData/Book 4.xlsx";

    public static final String SCREENSHOT_FILEPATH = System.getProperty("user.dir") + "/screenshots/";

  /*  public static String getPropertyValue(String key) {
        //get property is the method which will read the value as per the key provided
        return prop.getProperty(key);
    }*/
}
