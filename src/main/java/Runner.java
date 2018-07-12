import db.DBHelper;
import db.DBManager;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Department department = new Department("Strat planning");
        DBHelper.save(department);

        Manager manager1 = new Manager("John", "JK23", 123.23, 1000000.20, department);
        DBHelper.save(manager1);

        Manager manager2 = new Manager("Bill", "JK27", 123.00, 1000000.20, department);
        DBHelper.save(manager2);

        Administrator administrator1 = new Administrator("Boris Johnson", "px103", 1.02, manager1);
        DBHelper.save(administrator1);

        Administrator administrator2 = new Administrator("David Davis", "px102", 1.02, manager1);
        DBHelper.save(administrator2);

        Worker worker1 = new Worker("Jane", "qwe31", 12.30, manager1);
        DBHelper.save(worker1);

        Worker worker2 = new Worker("Ross", "qwe31", 12.30, manager2);
        DBHelper.save(worker2);

        CEO ceo = new CEO("Helen", "qwer", 123.12);
        DBHelper.save(ceo);

        List<Employee> employees = DBManager.getEmployeesForManager(manager1);

        System.exit(0);
    }
}
