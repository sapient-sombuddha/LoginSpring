package com.sapient.mutualfunds.LoginService.repository;

import com.sapient.mutualfunds.LoginService.models.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProfileRepository extends MongoRepository<Profile, String > {
    public Optional<Profile> findByUsername(String username);
    public Optional<Profile> findByUsernameAndPassword(String username, String password);
}
