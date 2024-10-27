package com.appsdeveloperblog.apps.ws.userservice;

import com.appsdeveloperblog.apps.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.apps.ws.ui.model.response.UserRest;

public interface UserService {

    UserRest createUser(UserDetailsRequestModel userDetails);
}
