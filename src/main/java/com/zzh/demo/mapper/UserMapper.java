package com.zzh.demo.mapper;


import com.github.pagehelper.Page;
import com.zzh.demo.base.BaseMapper;
import com.zzh.demo.entity.User;

public interface UserMapper extends BaseMapper<User > {
    Page<User> getUsers();
}