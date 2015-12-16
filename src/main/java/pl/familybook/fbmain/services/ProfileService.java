package pl.familybook.fbmain.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pl.familybook.fbmain.models.Profile;

public class ProfileService {

	EntityManagerFactory eFactory;
	EntityManager eManager;

	public ProfileService() {
		eFactory = Persistence.createEntityManagerFactory("fbJPA");
		eManager = eFactory.createEntityManager();
	}

	// add closing eFactory and eManager?

	public List<Profile> getProfiles() {
		Query query = eManager.createQuery("SELECT p from Profile p");
		List<Profile> profileList = query.getResultList();
		return profileList;
	}

	public String addProfile(Profile profile) {
		// is it okay exception handling?
		try {
			eManager.getTransaction().begin();
			eManager.persist(profile);
			eManager.getTransaction().commit();
			return "Profile: " + profile.getEmail() + " added!";
		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}

	public Profile getProfile(long id) {
		// TypedQuery<Profile> query = eManager.createQuery("SELECT p from
		// Profile p WHERE p.id = :id", Profile.class);
		// return query.setParameter("id", id).getSingleResult();
		Profile profile = eManager.find(Profile.class, id);
		return profile;
	}

	public Profile updateProfile(long id, Profile profile) {

		try {
			Profile profileOld = eManager.find(Profile.class, id);
			profileOld.setFirstName(profile.getFirstName());
			profileOld.setLastName(profile.getLastName());
			profileOld.setEmail(profile.getEmail());
			eManager.getTransaction().begin();
			// can be done in one transaction without merge
			eManager.merge(profileOld);
			eManager.getTransaction().commit();
			return profileOld;
		} catch (Exception e) {
			return null; // howto return value?
		}

	}

	public Profile deleteProfile(long id) {
		Profile profile = eManager.find(Profile.class, id);
		if (profile != null) {
			eManager.getTransaction().begin();
			eManager.remove(profile);
			eManager.getTransaction().commit();
			return profile;
		} else {
			return null;
		}
	}

}
