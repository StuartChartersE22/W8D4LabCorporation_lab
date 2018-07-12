package db;

import models.*;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.reflections.Reflections;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DBManager {

    private static Session session;
    private static Reflections reflections;

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
