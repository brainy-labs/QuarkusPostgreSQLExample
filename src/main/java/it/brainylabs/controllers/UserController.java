package it.brainylabs.controllers;

import java.util.List;

import it.brainylabs.models.entities.UserEntity;
import it.brainylabs.models.requests.UserRequest;
import it.brainylabs.models.resposes.UserResponse;
import it.brainylabs.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    private UserService userService;

    @GET()
    @Path("{username}") 
    public UserResponse get(@PathParam(value = "username") String username) {
        UserEntity user = userService.findByUsername(username);
        UserResponse userResponse = new UserResponse();

        userResponse.mapFromUser(user);
        return userResponse;
    }

    @GET()
    public List<UserResponse> listAll (){
        return userService.listAll().stream().map(v->{
            UserResponse userResponse = new UserResponse(); 
            userResponse.mapFromUser(v);
            return userResponse;
        }).toList();
    }

    @DELETE
    public void delete(UserRequest user) {
        UserEntity userEntity = new UserEntity();
        userEntity.mapFromUser(user);

        userService.delete(userEntity);
    }

    @POST
    public void save(UserRequest user) {
        UserEntity userEntity = new UserEntity();
        userEntity.mapFromUser(user);

        userService.save(userEntity);
    }

    @PUT
    public void update(UserRequest user) {
        UserEntity userEntity = new UserEntity();
        userEntity.mapFromUser(user);

        userService.update(userEntity);
    }
}
