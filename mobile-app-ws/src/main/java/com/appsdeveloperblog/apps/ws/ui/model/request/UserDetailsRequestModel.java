package com.appsdeveloperblog.apps.ws.ui.model.request;

import com.appsdeveloperblog.apps.ws.ui.model.response.UserRest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Map;

public class UserDetailsRequestModel {


    @NotBlank(message = "First name cannot be empty")
    @Size(min=2, message = "First name must be at least 2 characters")
    private String firstName;

    @NotNull (message = "Last name cannot be empty")
    @Size(min=2, message = "Last name must be at least 2 characters")
    private String lastName;
    @Email (message = "Email is not valid")
    private String email;
    @NotNull
    @Size(min=3, max=8, message = "Password should be between 3 and 8 characters")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
