package APIPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {


    //one thing to remember
    //base URI - base URL
    //end then using when keyword, we will send the end point

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    String token ="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9." +
            "eyJpYXQiOjE2NzQxNTU5NTIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY3NDE5OTE1MiwidXNlcklkIjoiNDc1NCJ9." +
            "G3yAcyeGRQDgYlwlZ0psnkYPmtP8iDknWGhPLqcmmRk";


    static String employee_id;

    @Test
    public void bgetOneEmployee(){
        //prepare the request
        RequestSpecification request = given().header("Authorization",token)
                .header("Content-Type","application/json")
                .queryParam("employee_id",employee_id);

       Response response = request.when().get("/getOneEmployee.php");
       // System.out.println(response.asString());

        response.prettyPrint();
        //verifying the status code
        response.then().assertThat().statusCode(200);

        //using jsonpath method we are extracting the value form the response body
        String firstName=response.jsonPath().getString("employee.emp_firstname");

        System.out.println(firstName);
        Assert.assertEquals(firstName,"Lima");
        response.then().assertThat().body("employee.emp_firstname",equalTo("Lima"));

    }

    @Test
    public void acreateEmployee(){
        RequestSpecification request=given().header("Authorization",token).header("Content-Type","application/json").
                body("{\n" +
                        "  \"emp_firstname\": \"Lima\",\n" +
                        "  \"emp_lastname\": \"Lolka\",\n" +
                        "  \"emp_middle_name\": \"MS\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1945-01-14\",\n" +
                        "  \"emp_status\": \"confirmed\",\n" +
                        "  \"emp_job_title\": \"QA enge\"\n" +
                        "}");

        Response response=request.when().post("/createEmployee.php");

        response.then().assertThat().statusCode(201);

        response.prettyPrint();
        employee_id=response.jsonPath().getString("Employee.employee_id");

        System.out.println(employee_id);
    }
@Test
    public void cupdateEmployee(){
        RequestSpecification request =given().header("Authorization",token).header("Content-Type","application/json").
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Enjoy\",\n" +
                        "  \"emp_lastname\": \"Life\",\n" +
                        "  \"emp_middle_name\": \"your\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2023-01-15\",\n" +
                        "  \"emp_status\": \"thankfull\",\n" +
                        "  \"emp_job_title\": \"happiness giver\"\n" +
                        "}");

        Response response=request.when().put("/updateEmployee.php");

        response.then().assertThat().statusCode(200);

        response.then().assertThat().body("Message",equalTo("Employee record Updated"));
        response.prettyPrint();
    }

    @Test
    public void dgetUpdatetEmploye(){

        //prepare the request
        RequestSpecification request = given().header("Authorization",token)
                .header("Content-Type","application/json")
                .queryParam("employee_id",employee_id);

        Response response = request.when().get("/getOneEmployee.php");
        // System.out.println(response.asString());

        response.prettyPrint();
        //verifying the status code
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("employee.emp_job_title",equalTo("happiness giver"));

    }
}
