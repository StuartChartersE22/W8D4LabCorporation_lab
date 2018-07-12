package db;

import models.Employee;
import models.Manager;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBManager {

    private static Session session;

//    public static List<Employee> getEmployeesForManager(Manager manager){
//        session = HibernateUtil.getSessionFactory().openSession();
//        List<Employee> results = null;
//        try {
//            Criteria cr = session.createCriteria(Employee.class);
//            cr.add(Restrictions.eq("manager", manager));
//            results =  cr.list();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return results;
//    }

}
