package com.example.demo;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/listUsers")
    public String listUsers() {
        Users users = new Users();
        users.createMockUsers();
        return String.format("%s", new Gson().toJson(users.getUsers()));
    }

    @GetMapping("/getUserById")
    public String getUserById(@RequestParam int id) {
        Users users = new Users();
        users.createMockUsers();

        User user = users.getUserById(id);
        if (user == null) {
            return String.format("%s", "No user found");
        } else {
            return String.format("%s", new Gson().toJson(user));
        }
    }

    //Sample http://127.0.0.1:8081/getUsersByProfession?profession=developer
    @GetMapping("/getUsersByProfession")
    public String getUsersByProfession(@RequestParam(value = "profession", defaultValue = "all") String profession) {

        //Create mock users
        Users users = new Users();
        users.createMockUsers();

        //filter users by profession
        ArrayList<User> output = users.getUsersByProfession(profession);
        if (output.isEmpty()) {
            return String.format("%s", "No user found");
        } else {
            return String.format("%s", new Gson().toJson(output));
        }
    }


    //Sample http://127.0.0.1:8081/addUser?id=5&name=robert&password=password5&profession=developer
    //Use postman with method post
    @PostMapping("/addUser")
    public String getUsersByProfession(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam String password,
            @RequestParam String profession) {

        //Create mock users
        Users users = new Users();
        users.createMockUsers();


        //add user
        users.addMockUser(id, name, password, profession);

        users.getUsersByProfession(profession);
        if (users.isEmpty()) {
            return String.format("%s", "No user found");
        } else {
            return String.format("%s", new Gson().toJson(users.getUsers()));
        }
    }

    //Sample http://127.0.0.1:8081/editUserName?id=1&name=robert
    //Use postman with method post
    @PostMapping("/editUserName")
    public String editUserName(
            @RequestParam int id,
            @RequestParam String name) {

        //Create mock users
        Users users = new Users();
        users.createMockUsers();

        users.editUserName(id, name);
        return String.format("%s", new Gson().toJson(users.getUsers()));
    }

    @PostMapping("/editUserProfession")
    public String editUserProfession(
            @RequestParam int id,
            @RequestParam String profession) {

        //Create mock users
        Users users = new Users();
        users.createMockUsers();

        users.editUserProfession(id, profession);
        return String.format("%s", new Gson().toJson(users.getUsers()));
    }


    //Sample http://127.0.0.1:8081/deleteUserById?id=2
    //Use postman with method delete
    @DeleteMapping("/deleteUserById")
    public String deleteUserById(@RequestParam int id) {
        Users users = new Users();
        users.createMockUsers();

        users.deleteUserById(id);
        if (users.isEmpty()) {
            return String.format("%s", "No user found");
        } else {
            return String.format("%s", new Gson().toJson(users.getUsers()));
        }
    }
    @DeleteMapping("/deleteUserByName")
    public String deleteUserByName(@RequestParam String name) {
        Users users = new Users();
        users.createMockUsers();

        users.deleteUserByName(name);
        if (users.isEmpty()) {
            return String.format("%s", "No user found");
        } else {
            return String.format("%s", new Gson().toJson(users.getUsers()));
        }

    }
}
