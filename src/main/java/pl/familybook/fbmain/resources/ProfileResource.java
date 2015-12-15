package pl.familybook.fbmain.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.familybook.fbmain.models.Profile;
import pl.familybook.fbmain.services.ProfileService;

@Path("/profile")
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	ProfileService profileService = new ProfileService();
	
	//get all profiles
	@GET
	public List<Profile> getProfiles() {
		return profileService.getProfiles();
	}

	//add new profile
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	//get single profile
	@GET
	@Path("/{id}")
	public Profile getProfileById(@PathParam("id") long id) {
		return profileService.getProfile(id);
	}
	
	// update profile
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Profile updateProfileById(@PathParam("id") Long id, Profile profile) {
		return profileService.updateProfile(id, profile);		
	}
	
	//delete profile
	@DELETE
	@Path("/{id}")
	public Profile deleteProfileById(@PathParam("id") long id) {
		return profileService.deleteProfile(id);
	}
	
	
}
