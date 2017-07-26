package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.dao.UserDao;
import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermilldata.entity.UserEntity;
import com.rodion.silvermilldata.mapper.UserDomainMapper;

import java.util.List;

/**
 * @author Rodion
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findUserByUserId(String id) {
        return UserDomainMapper.map(userDao.findByUserId(id));
    }

    @Override
    public User findUserByUsername(String username) {
        return UserDomainMapper.map(userDao.findByUsername(username));
    }

    @Override
    public User createUser(User userRequest) {
        UserEntity userEntity = UserDomainMapper.map(userRequest);
        return UserDomainMapper.map(userDao.insert(userEntity));
    }

    @Override
    public List<User> findAllUsers() {
        List<UserEntity> userEntities = userDao.findAll();
        return UserDomainMapper.map(userEntities);
    }
}
