package pl.familybook.fbmain.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SearchUser {
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "fbJPA" );
      EntityManager entitymanager = emfactory.createEntityManager();

      //Scalar function
      long id = 951;
      Query query = entitymanager.createQuery("Select e.email from Profile e where e.id = :id");
      List<String> list = query.getResultList();

      for(String e:list) {
         System.out.println("Employee NAME :"+e);
      }
   }
}