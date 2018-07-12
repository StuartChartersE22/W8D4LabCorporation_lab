package db;

import models.*;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DBManager extends DBHelper {

    private static Session session;
    private static Reflections reflections;

    public static List<Manager> getAll(){
        return getAll(Manager.class);
    }

    public static Manager find(int id){
        return find(id, Manager.class);
    }

    public static List<Administrator> getAdminForManager(Manager manager){
        return getAssociationsForAnObject(manager, Administrator.class, "manager");
    }

    public static List<Employee> getEmployeesForManager(Manager manager){
        reflections = new Reflections("models");
        session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Employee> results = new ArrayList<Employee>();

        Set manageableSet = reflections.getSubTypesOf(Manageable.class);
        Iterator classIterator = manageableSet.iterator();

        try {
            while (classIterator.hasNext()){
                Class criteriaClass = (Class)classIterator.next();
                Criteria cr = session.createCriteria(criteriaClass);
                cr.add(Restrictions.eq("manager", manager));
                results.addAll(cr.list());
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

}
