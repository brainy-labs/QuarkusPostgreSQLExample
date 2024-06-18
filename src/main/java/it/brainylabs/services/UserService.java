package it.brainylabs.services;

import java.util.List;

import io.quarkus.cache.CacheInvalidate;
import it.brainylabs.models.entities.UserEntity;
import it.brainylabs.reporitories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserService {
    

    @Inject
    private UserRepository userRepository; 

    public List<UserEntity> listAll () {
        return userRepository.listAll();
    }

    public UserEntity findById (String email) {
        return userRepository.findById(email);
    }

    public UserEntity findByUsername (String username) {
        return userRepository.findByUsername(username);
    }

    @CacheInvalidate(cacheName = "users")
    public void delete (UserEntity userEntity) {
        userRepository.delete(userEntity);
    }

    public void save (UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public void update (UserEntity userEntity) {
        userRepository.update(userEntity);
    }

}
