package com.techjs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Demo 
{

	public static void main(String[] args)
	{
		Address address = new Address();
		
		Names name = new Names();
		
		name.setFirstName("Kalyan");
		name.setMiddleName("Kumar");
		name.setLastName("B");
		
		address.setId(101);
		address.setNames(name);
		address.setPinCode(560061);
		address.setState("Karnataka");
		
        Configuration config = new Configuration().configure();
        config.addAnnotatedClass(Address.class);

        SessionFactory sf = config.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction ts = session.beginTransaction();
       
       // session.save(address);
        Address addr = session.get(Address.class,101);
        
        System.out.println("First Name :"+addr.getNames().getFirstName());
        System.out.println("Middle Name :"+addr.getNames().getMiddleName());
        System.out.println("Last Name :"+addr.getNames().getLastName());
        
        ts.commit();
        session.close();
        sf.close();

	}

}
