import db.DBHelper;
import db.DBManager;
import models.Administrator;
import models.Department;
import models.Employee;
import models.Manager;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Department department = new Department("Strat planning");
        DBHelper.save(department);

        Manager manager = new Manager("John", "JK23", 123.23, 1000000.20, department);
        DBHelper.save(manager);

        Administrator administrator1 = new Administrator("Boris Johnson", "px103", 1.02, manager);
        DBHelper.save(administrator1);

        Administrator administrator2 = new Administrator("David Davis", "px102", 1.02, manager);
        DBHelper.save(administrator2);

//        List<Employee> employees = DBManager.getEmployeesForManager(manager)

        System.exit(0);
    }
}
