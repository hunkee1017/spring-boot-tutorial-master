package com.skcc.profile.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.profile.service.ProfileService;
import com.skcc.profile.vo.Profile;

@RestController
@org.springframework.context.annotation.Profile({"dev", "k8s"})
public class ProfileRestController {	
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/profiles")
	public List<Profile> getProfiles() {
		List<Profile> profiles = profileService.getProfiles(); 
		return profiles;
	}
	
	@GetMapping("/profiles/{id}")
	public Profile getProfileById(@PathVariable(value = "id") String id) {
		return profileService.getProfileById(id);
	}
	
	@PostMapping("/profiles")
	public void createProfile(@RequestBody Profile profile) {
		profileService.createProfile(profile);
	}
	
	@PutMapping("/profiles/{id}")
	public void updateProfile(@PathVariable(value = "id") String id, @RequestBody Profile profile) {
		profileService.updateProfile(id, profile);
	}
	
	@DeleteMapping("/profiles/{id}")
	public void deleteProfile(@PathVariable(value = "id") String id) {
		profileService.deleteProfile(id);
	}
	
	// Insert Dummy Data
	@GetMapping("/profiles/load")
	public String loadData() throws IOException {
		profileService.loadData();
		return "Profile Data loaded";
	}

}
