package pl.familybook.fbmain.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pl.familybook.fbmain.models.Profile;

public class ProfileService {

	EntityManagerFactory eFactory;
	EntityManager eManager;
	
	public ProfileService() {
		eFactory = Persistence.createEntityManagerFactory("fbJPA");
		eManager = eFactory.createEntityManager();
	}
	
	public List<Profile> getProfiles() {
		Query query = eManager.createQuery("SELECT p from Profile p");
		List<Profile> profileList = query.getResultList();
		return profileList;
	}
	
	public Profile addProfile(Profile profile) {
		eManager.getTransaction().begin();
		eManager.persist(profile);
		eManager.getTransaction().commit();
		return profile;
	}
	
	public Profile getProfile(long id) {
		//TypedQuery<Profile> query = eManager.createQuery("SELECT p from Profile p WHERE p.id = :id", Profile.class);
		//return query.setParameter("id", id).getSingleResult();
		Profile profile = eManager.find(Profile.class, id);
		return profile;
	}
	
	public Profile updateProfile (long id, Profile profile) {
		
		Profile profileOld = eManager.find(Profile.class, id);
		if (profileOld != null) {
			profileOld.setId(id);
			profileOld.setFirstName(profile.getFirstName());
			profileOld.setLastName(profile.getLastName());
			profileOld.setEmail(profile.getEmail());
			eManager.getTransaction().begin();
			eManager.merge(profileOld);
			eManager.getTransaction().commit();
			return profileOld;
		}
		else {
			return null;
		}

	}
	
	public Profile deleteProfile(long id) {
		Profile profile = eManager.find(Profile.class, id);
		if (profile != null) {
			eManager.getTransaction().begin();
			eManager.remove(profile);
			eManager.getTransaction().commit();
			return profile;
		}
		else {
			return null;
		}
	}
	
}
