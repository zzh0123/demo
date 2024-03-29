package com.zzh.demo.service;

import com.github.pagehelper.Page;
import com.zzh.demo.entity.Result;
import com.zzh.demo.entity.User;
import com.zzh.demo.mapper.UserMapper;
import com.zzh.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzh
 * @create 2019-08-18 21:55
 * @desc User服务
 */
@Service
public class UserService {

    @Autowired
    private UserMapper mapper;


    public User getUserById(String userId){
        User user = null;
        user = mapper.selectByPrimaryKey(userId);
        return user;
    }

    public Result getUserList(){
        Result result = null;
        List<User> userList = null;
        userList = mapper.selectAll();
        result = ResultUtil.getSearchResult(userList);
        return result;
    }

    /**
     * 功能描述: 根据userid查询用户信息
     * @param: userId
     * @return: result
     * @auther: zzh
     * @date: 2019-08-18 22:09
     */
    public Result getUserResultByUserId(String userId){
        Result result = null;
        User user = null;
        user = mapper.selectByPrimaryKey(userId);
        result = ResultUtil.getSearchResult(user);
        return result;
    }

    public Result getUsersByPage(){
        Result result = null;
        Page<User> users = null;
        users = mapper.getUsers();
        result = ResultUtil.getSearchResult(users);
        return result;
    }

    public Page<User> getUsers() {
        return mapper.getUsers();
    }


    /**
     * 功能描述: 注册，插入用户信息
     * @param: user
     * @return: result
     * @auther: zzh
     * @date: 2019-08-18 22:34
     */
    public Result insertUser(User user){
        Result result = null;
        Integer count = null;
        count = mapper.insert(user);
        System.out.println("--count--" + count);
        if (count == 1){
            result = ResultUtil.getInsertResult(user);
        } else {
            result = ResultUtil.getInsertResult(null);
        }

        return result;
    }


    /**
     * 生成6位随机数验证码
     * @return
     */
    public String vcode(){
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }
}
