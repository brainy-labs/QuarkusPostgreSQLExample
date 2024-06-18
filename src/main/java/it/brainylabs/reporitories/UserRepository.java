package it.brainylabs.reporitories;

import java.util.List;

import io.quarkus.cache.CacheResult;
import it.brainylabs.models.entities.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserRepository {
    @Inject
    EntityManager entityManager;

    @CacheResult(cacheName = "users")
     public UserEntity findById(String email) {
        return entityManager.find(UserEntity.class, email);
    }

    @Transactional
    public void save(UserEntity user) {
        entityManager.persist(user);
    }

    @Transactional
    public UserEntity update(UserEntity user) {
        return entityManager.merge(user);
    }

    @Transactional
    public void delete(UserEntity user) {
        entityManager.remove(entityManager.contains(user)?user:entityManager.merge(user));
    }

    @CacheResult(cacheName = "users")
    public List<UserEntity> listAll() {
        return entityManager.createQuery("SELECT u FROM UserEntity u", UserEntity.class).getResultList();
    }

    @CacheResult(cacheName = "users")
    public UserEntity findByUsername(String username) {
        Query q =entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.username=:username");
        q.setParameter("username", username);

        Object result = q.getSingleResult();

        if(result instanceof UserEntity){
            return (UserEntity) result;
        }

        return null;
    }
}
