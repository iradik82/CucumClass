package steps;

import pages.AddEmployeePage;
import pages.DashBoardPage;
import pages.EmployeeListPage;
import pages.LoginPage;

public class PageInitializer {
    public static LoginPage login;
    public static DashBoardPage dashBoard;

    public static AddEmployeePage addEmployee;

    public static EmployeeListPage employeeList;

    public static void initializePageObjects(){
        login = new LoginPage();
        dashBoard = new DashBoardPage();
        addEmployee = new AddEmployeePage();
        employeeList =new EmployeeListPage();
    }
}
