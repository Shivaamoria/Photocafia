package com.userprofile.Controller;

import com.userprofile.Entity.Admin;
import com.userprofile.Entity.NewUser;
import com.userprofile.Entity.UserUpload;
import com.userprofile.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class UserController {
    @Autowired
    UserService userService;
//===================For Users===========================
    @PostMapping("/adduser")
    public void adduser(@RequestBody NewUser user){
        userService.saveUser(user);

    }
    @GetMapping("/getUser")
    public List<NewUser> findUsers(){

        return userService.findall();
    }
    @GetMapping("/getUser/{email}")
    public List<NewUser> findUsersByEmail(@PathVariable String email){

        return userService.findByEmail(email);
    }
    @DeleteMapping("/adduser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.remove(id);
        return "User Deleted";
    }

//================For Admin=====================

    @PostMapping("/addadmin")
    public void addAdmin(@RequestBody Admin admin){

        userService.saveAdmin(admin);
    }
    @GetMapping("/getadmin")
    public List<Admin> findAdmin(){

        return userService.findAllAdmin();
    }
//    ====================For Upload photos=====================
@PostMapping("/uploadphoto")
public void addpost(@RequestBody UserUpload photos){
    userService.savePhotos(photos);

}
}
