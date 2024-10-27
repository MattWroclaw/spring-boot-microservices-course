package com.appsdeveloperblog.apps.ws.userservice.impl;

import com.appsdeveloperblog.apps.ws.shared.Utils;
import com.appsdeveloperblog.apps.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.apps.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.apps.ws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users; // <key, value>

    Utils utils;

    UserServiceImpl(){}

    @Autowired
    UserServiceImpl(Utils utils){
        this.utils = utils;
    }



    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest userRest = new UserRest();
        userRest.setFirstName(userDetails.getFirstName());
        userRest.setLastName(userDetails.getLastName());
        userRest.setEmail(userDetails.getEmail());
        userRest.setPassword(userDetails.getPassword());

        String userID = utils.generateUserId();
        userRest.setUserId(userID);

        if(users == null) {
            users = new HashMap<>();
            users.put(userID, userRest);
        }
        users.put(userID, userRest);

        return userRest;
    }
}
