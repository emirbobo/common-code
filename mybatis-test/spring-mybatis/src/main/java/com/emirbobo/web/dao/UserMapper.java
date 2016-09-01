package com.emirbobo.web.dao;


import java.util.List;

public interface UserMapper {

    public int insertOrUpdate(String uname);
    public List listAll();

}
