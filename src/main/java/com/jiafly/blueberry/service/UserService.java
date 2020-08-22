package com.jiafly.blueberry.service;

import com.jiafly.blueberry.domain.model.User;

import java.util.List;

/**
 * @author liuyi
 */
public interface UserService {

    /**
     * insert
     *
     * @param user user
     */
    void insert(User user);

    /**
     * 查询所有
     *
     * @return users
     */
    List<User> selectAll();

    /**
     * 根据id查询
     *
     * @param id id
     * @return user
     */
    User selectById(Long id);
}
