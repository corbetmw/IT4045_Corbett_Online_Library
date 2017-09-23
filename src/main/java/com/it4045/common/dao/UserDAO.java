package com.it4045.common.dao;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.*;
import com.it4045.common.dto.User;
import com.it4045.common.exceptions.UserNotFoundException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO implements IUserDAO  {

    FirebaseDatabase database = Database.getDatabase();

    DatabaseReference usersRef = database.getReference("users");


    public UserDAO() throws IOException{

    }

    public List<User> getAllUsers() throws Exception {
        final List<User> users = new ArrayList<User>();
        // Attach a listener to read the data at our posts reference
        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                users.add(user);
            }

            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
        return users;
    }

    public User getUserByUsername(String userName) throws Exception {
        for (User user : this.getAllUsers()){
            if (user.getUsername().equalsIgnoreCase(userName)){
                return user;
            }
        }
        throw new UserNotFoundException("A user with the specified username does not exist");
    }

    public void addUser(User user) throws Exception {
        usersRef.push().setValue(user);
    }

    public void updateUser(User user) throws Exception {
        DatabaseReference userRef = usersRef.orderByChild("userName").equalTo(user.getUsername()).getRef();

        Map<String, Object> userUpdates = new HashMap<String, Object>();
        userUpdates.put(userRef.getKey(), user);

//        userUpdates.put("userName", user.getUsername());
//        userUpdates.put("fullName", user.getFullname());
//        userUpdates.put("password", user.getPassword());
//        userUpdates.put("role", user.getRole());

        userRef.updateChildren(userUpdates);
    }

    public void deleteUser(User user) throws Exception {
        DatabaseReference userRef = usersRef.orderByChild("userName").equalTo(user.getUsername()).getRef();

        userRef.removeValue();
    }
}
