package it.brainylabs.models.entities;

import it.brainylabs.models.UserModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER")
public class UserEntity extends UserModel {
    
}
