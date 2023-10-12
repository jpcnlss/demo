package com.example.demo;

import java.util.ArrayList;

public class Users {

    private ArrayList<User> users = new ArrayList<User>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void createMockUsers() {
        //inserting mock users
        //create additional mock users here
        addMockUser(1,"Josh","SigeIkembot","Dancer");
        addMockUser(2,"Natoy","AyokoNaSaEarth","Nagmamahal");
        addMockUser(3,"Darna","DingAndBato","Tiga Pag Ligtas");
        addMockUser(4,"Pickachu","PikaPika","Pokemon");
    }

    public void addMockUser(int id, String name, String password, String profession) {
        //inserting one mock user
        User user = new User(id, name, password, profession);
        users.add(user);
    }

    public User getUserById(int id) {
        // find user by id
        for (int i=0; i<users.size(); i++) {
            User user = users.get(i);
            if(id==user.getId()) {
                return user;
            }
        }
        return null;
    }



    public User editUserName(int id, String name) {
        for (int i=0; i<users.size(); i++) {
            User user = users.get(i);
            if(id==user.getId()) {
                user.setName(name);
                users.remove(i);
                users.add(user);
            }
        }
        return null;
    }

    public User editUserProfession(int id, String profession) {
        for (int i=0; i<users.size(); i++) {
            User user = users.get(i);
            if(id==user.getId()) {
                user.setProfession(profession);
                users.remove(i);
                users.add(user);
            }
        }
        return null;
    }

    public ArrayList<User> getUsersByProfession(String profession) {
        // return all users
        if (profession.equalsIgnoreCase("all")) {
            return users;
        }

        // users to return
        ArrayList<User> output = new ArrayList<User>();

        // find users with the given profession and add them to the return list
        for (int i=0; i<users.size(); i++) {
            User user = users.get(i);
            String p = user.getProfession();
            System.out.print(p + " " + profession + " " + users.size());
            if(p.equalsIgnoreCase(profession)) {
                System.out.print(p + " " + profession + " " + i);
                //if profession is the same, add to output list
                output.add(user);
            }
        }

        return output;
    }

    public boolean isEmpty() {
        return users.isEmpty();
    }

    public void deleteUserById(int id) {
        // find user by id and remove it
        for (int i=0; i<users.size(); i++) {
            User user = users.get(i);
            if(id==user.getId()) {
                users.remove(i);
            }
        }
    }
    public void deleteUserByName(String name) {
        // find user by id and remove it
        for (int i=0; i<users.size(); i++) {
            User user = users.get(i);
            if(name.equalsIgnoreCase(user.getName())) {
                users.remove(i);
            }
        }
    }

}