package com.skcc.profile.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcc.profile.dao.ProfileRepository;
import com.skcc.profile.vo.Profile;

@Service("profileService")
@org.springframework.context.annotation.Profile({"dev", "k8s"})
public class ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	public List<Profile> getProfiles() {
		return profileRepository.findAll();
	}
	
	public Profile getProfileById(String id) {
		return profileRepository.findByUsername(id);
	}
	
	public void createProfile(Profile profile){
		profileRepository.save(profile);
	}
	
	public void updateProfile(String id, Profile profile){
		profile.setId(id);
		profileRepository.save(profile);
	}
	
	public void deleteProfile(String id){
		profileRepository.delete(id);
	}
	
	// Insert Dummy Data
	public void loadData() throws IOException{
		profileRepository.loadData();
	}
	
}
