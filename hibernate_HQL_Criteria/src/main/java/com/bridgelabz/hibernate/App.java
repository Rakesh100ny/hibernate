package com.bridgelabz.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.bridgelabz.model.Employee;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
     Session session=sessionFactory.openSession();
     session.beginTransaction();
                
     /* Query<Employee> query=session.createQuery("from Employee"); //HQL Query
     ----------Pagination-----------
       query.setFirstResult(5);
       query.setMaxResults(4);
     
     List<Employee> users=(List<Employee>) query.list(); 
     
     
     for(Employee employee :users)
    	 System.out.println(employee.getEmpName());
     
     */
     
     
  /*  -------------HQL Query Using Attribute Name in HQL query----------------   
     Query query=session.createQuery("select empName from Employee"); //HQL Query
     List<String> users=(List<String>) query.list(); //here i did used String b;Coz in my HQL query i wrote empName 
                                                     //it is attribute so the HQL query give me String so
  
   for(String name : users)
     {
      System.out.println(name);	 
     }
    
  */   
 
     
     /*---------Understanding Parameter Binding and SQL Injection---------
     
       int minUserId=5; //prameter binging ***One Way***
       Query<Employee> query=session.createQuery("from Employee where id> "+minUserId); 
     
     
     String minUserId=" 5 or 1 = 1"; //SQL injection ***Second Way***
     Query<Employee> query=session.createQuery("from Employee where id> "+minUserId);
     
     */
    
   /*   
    String minUserId="5"; 
     String empName="User : 9";
     Query<Employee> query=session.createQuery("from Employee where id> ?0 and empName=?1");// ***Third Way***
     query.setInteger(0, Integer.parseInt(minUserId));
     query.setString(1, empName);
     
    */
     
    /* String minUserId="5"; 
     String empName="User : 9";
     Query<Employee> query=session.createQuery("from Employee where id> :id and empName=:empName");// ***Fourth Way***
     query.setInteger("id",Integer.parseInt(minUserId));
     query.setString("empName", empName);
     
     */
     
     /*-------------------Named Query-----------------------
        
       Query<Employee> query=session.getNamedQuery("Employee.byId");
       query.setInteger(0, 2);
     */
     
     /*-----------------NamedNativeQuery-------------
     Query<Employee> query=session.getNamedQuery("Employee.byName");
     query.setString(0, "User : 9");
     */
     
     /*----------------Criteria API------------------  
     Criteria criteria=session.createCriteria(Employee.class);
     //criteria.add(Restrictions.eq("empName", "User : 9"));

     criteria.add(Restrictions.eq("empName", "User : 9"))
             .add(Restrictions.gt("id", 5));
     
     //criteria.add(Restrictions.gt("id", 5));
     
     criteria.add(Restrictions.like("empName", "%User : 1%"))
     .add(Restrictions.between("id", 5, 50));
     
     criteria.add(Restrictions.or(Restrictions.between("id", 1, 3),Restrictions.between("id", 7, 10)));
    
     List<Employee> users=(List<Employee>)criteria.list();
     */
    
     
     /*Criteria criteria=session.createCriteria(Employee.class)
    		 .setProjection(Projections.max("id"))
    		 .addOrder(Order.desc("id"));
    		 
    		     List<Integer> users=(List<Integer>)criteria.list();
     
     session.getTransaction().commit();;
     session.close();
     
     for(Integer employee :users)
    	 System.out.println(employee);
    }
    */  
     
     
     /*Criteria criteria=session.createCriteria(Employee.class)
    		  .addOrder(Order.desc("id"));
    */
     
     
     
     /*---------------Query By Example-------------------*/
     Employee employee=new Employee();
     //employee.setId(5);
    /* employee.setEmpName("User : 5");
     
     Example example=Example.create(employee);*/
     
employee.setEmpName("User : 1%");
     
     Example example=Example.create(employee).enableLike();
     
     Criteria criteria=session.createCriteria(Employee.class)
                               .add(example);
     
     List<Employee> users=(List<Employee>)criteria.list();
     
     session.getTransaction().commit();;
     session.close();
     
     for(Employee employee1 :users)
    	 System.out.println(employee1.getEmpName());
    }
}
