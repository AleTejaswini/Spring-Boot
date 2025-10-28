package relationships.examples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import relationships.examples.onetoone.EmpID;
import relationships.examples.onetoone.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        EmpID empid = new EmpID();
        empid.setId(1);
        empid.setEmpcode("T001");
        
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("Teja");
        emp.setEmpid(empid);
        
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Employee.class).addAnnotatedClass(EmpID.class);
        
        SessionFactory factory= config.buildSessionFactory();
        
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        
        session.persist(emp);
        
        
       
      
        Employee e = session.find(Employee.class, 1); 
        System.out.println(e.toString());
//        session.remove(e);
        
       
        
        t.commit();
    }
}
