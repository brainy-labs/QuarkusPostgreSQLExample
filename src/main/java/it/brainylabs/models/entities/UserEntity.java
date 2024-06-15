package it.brainylabs.models.entities;


import it.brainylabs.models.UserModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "UTENTI")
public class UserEntity extends UserModel {
    
}
