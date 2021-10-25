package com.vishwa.mbs.services;

import com.vishwa.mbs.entities.User;
import com.vishwa.mbs.exceptions.UserDetailsNotFoundException;
import com.vishwa.mbs.exceptions.UserNameAlreadyExistsException;
import com.vishwa.mbs.exceptions.UserTypeDetailsNotFoundException;

public interface UserService {

    public User acceptUserDetails(User user)
            throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException;

    public User getUserDetails(int id) throws UserDetailsNotFoundException;

    public User getUserDetailsByUsername(String username) throws UserDetailsNotFoundException;

    public User updateUserDetails(int id, User user)
            throws UserNameAlreadyExistsException, UserDetailsNotFoundException, UserTypeDetailsNotFoundException;

}
