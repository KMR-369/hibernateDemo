package com.wipro.training.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Application to save Employee Object to database
 */
public class EmployeeApp
{
	
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration(); 		//Configuration object imported from org.hibernate
        cfg.configure("hibernate.cfg.xml");    		//It configures the configuration file
        SessionFactory sf=cfg.buildSessionFactory();	// with the help of configuration object, creating Session Factory object
        Session session=sf.openSession();               //using session factory object to get physical connection with DataBase
             
        Transaction t=session.beginTransaction();      //starting transaction( C R U D ) using session Object
       
        Employee e1=new Employee();    // create transient Object of Employee
       
        e1.setFirstName("Manikanta");
        e1.setLastName("Reddy");
       
        session.save(e1);           // Persist ( Saves to DataBase ) the Object of Employee
        t.commit();
        System.out.println("Data successfully Saved to DB");
        session.close();
        sf.close();
    }
}
