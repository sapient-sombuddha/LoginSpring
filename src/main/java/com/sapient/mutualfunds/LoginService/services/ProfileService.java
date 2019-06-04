package com.sapient.mutualfunds.LoginService.services;

import com.sapient.mutualfunds.LoginService.models.Profile;
import com.sapient.mutualfunds.LoginService.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository repository;
//    Create profile on sign up
    public Profile createProfile(String name, String username, String password){
        return repository.save(new Profile(name, username, password));
    }
//    Checks if a username is already present
    public boolean isUsernamePresent(String username){
        Optional<Profile> profile = repository.findByUsername(username);
        if (profile.isPresent()){
            return true;
        }
        return false;
    }

    public boolean isUserPresent(String username, String password){
        Optional<Profile> profile = repository.findByUsernameAndPassword(username, password);
        if (profile.isPresent()){
            return true;
        }
        return false;
    }

    public Profile getByUsername(String username){
        Profile p = new Profile();
        Optional<Profile> profile = repository.findByUsername(username);
        if (profile.isPresent()){
            return profile.get();
        }
        return p;
    }

    public List<Profile> getAll(){
        return repository.findAll();
    }

}
