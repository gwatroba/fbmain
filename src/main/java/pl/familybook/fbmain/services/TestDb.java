package pl.familybook.fbmain.services;

import pl.familybook.fbmain.models.Profile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestDb {

   public static void main( String[] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "fbJPA" );
      
      EntityManager entitymanager = emfactory.createEntityManager();
      entitymanager.getTransaction( ).begin( );

      Profile profile = new Profile( ); 
      //employee.setEid( 12012 );
      profile.setFirstName("Adam");
      profile.setLastName("Bielan");
      profile.setEmail("adam3@bielan.pl");
      
      entitymanager.persist(profile);
      entitymanager.getTransaction( ).commit( );

      entitymanager.close( );
      emfactory.close( );
   }
}


