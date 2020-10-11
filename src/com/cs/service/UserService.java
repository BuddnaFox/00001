package com.cs.service;

import com.cs.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    //查询数据的总记录数
    public int findByCountUser()throws Exception;

    //分页方法
    public List<User> findByPageUserInfo(int pageNo, int pageSize) throws Exception;

    public User findBySearchUserId(int id) throws SQLException;

    public boolean delByUserID(int id);

}
