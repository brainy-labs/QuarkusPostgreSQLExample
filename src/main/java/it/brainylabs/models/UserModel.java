package it.brainylabs.models;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@RegisterForReflection
@MappedSuperclass
public class UserModel {

    private String username; 
    @Id
    private String email; 
    private String psk;

    public void mapFromUser (UserModel anotherUser) {
        this.username = anotherUser.username;
        this.email = anotherUser.email;
        this.psk = anotherUser.psk;
    }
}
