package com.jiafly.blueberry.service.impl;

import com.jiafly.blueberry.domain.model.User;
import com.jiafly.blueberry.domain.repository.UserRepository;
import com.jiafly.blueberry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuyi
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void insert(User user) {
        userRepository.insert(user);
    }

    @Override
    public List<User> selectAll() {
        return userRepository.selectAll();
    }

    @Override
    public User selectById(Long id) {
        return userRepository.selectByPrimaryKey(id);
    }
}
