package utils;

import netscape.javascript.JSObject;
import org.json.JSONObject;

public class APIPayloadConstant {

    public static String createEmployeePayload(){
        String createEmployeePayload="{\n" +
                "  \"emp_firstname\": \"Lima\",\n" +
                "  \"emp_lastname\": \"Lolka\",\n" +
                "  \"emp_middle_name\": \"MS\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1945-01-14\",\n" +
                "  \"emp_status\": \"confirmed\",\n" +
                "  \"emp_job_title\": \"QA enge\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeeJsonBody(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Lima");
        obj.put("emp_lastname","Lolka");
        obj.put("emp_middle_name","MS");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","1945-01-14");
        obj.put("emp_status","confirmed");
        obj.put("emp_job_title","QA enge");

        return obj.toString();
    }

    public static String createEmployeePayloadDynamic(String firstname, String lastName,
                                                      String middleName, String gender, String dob,
                                                      String empStatus, String jobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname",firstname);
        obj.put("emp_lastname",lastName);
        obj.put("emp_middle_name",middleName);
        obj.put("emp_gender",gender);
        obj.put("emp_birthday",dob);
        obj.put("emp_status",empStatus);
        obj.put("emp_job_title",jobTitle);

        return obj.toString();
    }

    public static String adminPayload(){
        String adminPayload= "{\n" +
                "    \"email\": \"batch142023!@test.com\",\n" +
                "    \"password\": \"Test@123\"\n" +
                "}";

        return adminPayload;
    }
}
