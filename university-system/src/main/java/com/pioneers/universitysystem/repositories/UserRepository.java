package com.pioneers.universitysystem.repositories;

import com.pioneers.universitysystem.models.entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    List<User> list = new ArrayList<>();

    public User save(User user){
        list.add(user);
        return user;
    }

    public Optional<User> findById (int id) {
        return list.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public Optional<User> findByEmail (String email) {
        return list.stream()
                .filter(user -> user.getEmail() != null && user.getEmail().equals(email))
                .findFirst();
    }

    public Optional<User> findByUsername (String username) {
        return list.stream()
                .filter(user -> user.getUsername() != null && user.getUsername().equals(username))
                .findFirst();
    }

    public boolean deleteUser (int id) {
        return list.removeIf(user -> user.getId() == id);
    }

    public void saveAll(List<User> newUsers) {
        list.addAll(newUsers);
    }

    public List<User> getAllUsers() {
        return list;
    }

    public int getUserNumber(){
        return list.size();
    }

    public boolean isUserExist(String username , String email){
        return list.stream()
                .anyMatch((user -> (user.getUsername()!=null && user.getUsername().equals(username))
                        ||
                        (user.getEmail() != null && user.getEmail().equalsIgnoreCase(email))));


    }


}
