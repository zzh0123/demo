package com.zzh.demo.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.zzh.demo.entity.Result;
import com.zzh.demo.entity.User;
import com.zzh.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zzh
 * @create 2019-08-18 22:38
 * @desc 用户controller
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/getUserList")
    public Result getUserList(){
        Result result = null;
        result = service.getUserList();
        System.out.println("--getUserList--" + JSON.toJSON(result).toString());
        return result;
    }

    @GetMapping("/getUserResultByUserId")
    public Result getUserResultByUserId(@RequestParam(required = true) String userId){
        Result result = null;
        result = service.getUserResultByUserId(userId);
        System.out.println("--getUserResultByUserId--" + JSON.toJSON(result).toString());
        return result;
    }

    @GetMapping("/getUsersByPage")
    public Result getUsersByPage(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "3") int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        Result result = null;
        result = service.getUsersByPage();
        System.out.println("--getUsersByPage--" + JSON.toJSON(result).toString());
        return result;
    }

    @GetMapping("/users")
    public List<User> lists(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return service.getUsers();
    }

    // post请求
    @PostMapping("/insertUser")
    public Result insertUser(@RequestBody User user){
        Result result = null;
        result = service.insertUser(user);
        System.out.println("--insertUser--" + JSON.toJSON(result).toString());
        return result;
    }

    @PostMapping("/insertUser1")
    public Result insertUser1(@RequestParam String userId, @RequestParam String userName){
        Result result = null;
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        result = service.insertUser(user);
        System.out.println("--insertUser1--" + JSON.toJSON(result).toString());
        return result;
    }

    @PostMapping("/insertUser2")
    public Result insertUser2(@RequestParam String userId, @RequestParam String userName,
                              @RequestParam Integer age){
        Result result = null;
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setAge(age);
        result = service.insertUser(user);
        System.out.println("--insertUser2--" + JSON.toJSON(result).toString());
        return result;
    }



    /**
     * 功能描述: 登录
     * @param:
     * @return:
     * @auther: zzh
     * @date: 2019-08-18 22:42
     */
//    @PostMapping("/login")
//    public Result login(@RequestParam(value = "password", required = true) String password,
//                        @RequestParam(value = "phone", required = true) String phone,
//                        @RequestParam(value = "type", required = true) String type){
//        User user = new User();
//        user.setUserId(phone);
//        user.setUserName(phone);
//        user.setArea("");
//        user.setBirthday(null);
//        user.setBriefIntroduction("");
//        user.setHeadPortrait("");
//        user.setSex("");
//        user.setUserType(1);
//        user.setVipLevel(1);
//
//        Result result = null;
//        result = service.insertUser(user);
//        return result;
//    }

}
