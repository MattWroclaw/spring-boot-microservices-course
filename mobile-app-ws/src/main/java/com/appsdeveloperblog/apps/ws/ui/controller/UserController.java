package com.appsdeveloperblog.apps.ws.ui.controller;

import com.appsdeveloperblog.apps.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.appsdeveloperblog.apps.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.apps.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.apps.ws.userservice.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    Map<String, UserRest> users = new HashMap<>(); // <key, value>

    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit)
//    http://localhost:8080/users?page=1231231&limit=17361287
    {
//        if (true)throw new UserServiceException("Exception while getting users");
        return "Get users page = " + page + " limit = " + limit;
    }

    @GetMapping(
            path = "/{userId}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

        if (users.containsKey(userId)) {
            return new ResponseEntity(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity("User not found", HttpStatus.NO_CONTENT);
        }

    }


    @PostMapping(
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

//        UserRest userRest = new UserServiceImpl().createUser(userDetails); robiąc tak,
//        nie możemy później przetestować tych 2 klas osobno. Konieczne jest zastosowanie dependeny injection
//

        UserRest userRest = userService.createUser(userDetails);
        users.put(userRest.getUserId(), userRest);
        return new ResponseEntity(userRest, HttpStatus.CREATED);
    }

    @PutMapping(
            path = "/{userId}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {

        UserRest storedUser = users.get(userId);
        storedUser.setFirstName(userDetails.getFirstName());
        storedUser.setLastName(userDetails.getLastName());

        users.put(storedUser.getUserId(), storedUser);
        return storedUser;

    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {

        users.remove(userId);
        return ResponseEntity.noContent().build();
    }
}
