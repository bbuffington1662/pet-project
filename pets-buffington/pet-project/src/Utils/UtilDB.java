/**
 */
package Utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import Database.Pet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDB {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }

   public static List<Pet> listPets() {
      List<Pet> resultList = new ArrayList<Pet>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> pets = session.createQuery("FROM Pet").list();
         for (Iterator<?> iterator = pets.iterator(); iterator.hasNext();) {
             resultList.add((Pet) iterator.next());
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }
   
   public static Pet getPet(int id) {
	      Pet pet = null;
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;

	      try {
	         tx = session.beginTransaction();
	         pet = (Pet) session.get(Pet.class, id);
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return pet;
	   }

   public static void insert(Pet pet) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(pet);
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
   
   public static void delete(Pet pet) {
	  Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         session.delete(pet);
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
   
   public static void update(Pet pet) {
	   Session session = getSessionFactory().openSession();
	      Transaction tx = null;

	      try {
	         tx = session.beginTransaction();
	         session.update(pet);
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
   }
}
