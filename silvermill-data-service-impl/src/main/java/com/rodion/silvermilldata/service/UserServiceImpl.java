package com.rodion.silvermilldata.service;

import com.rodion.silvermilldata.dao.UserDao;
import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermilldata.entity.UserEntity;
import com.rodion.silvermilldata.mapper.Updater;
import com.rodion.silvermilldata.mapper.UserDomainMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Rodion
 */
public class UserServiceImpl implements UserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

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
    public User createOrUpdateUser(User userRequest) {

        UserEntity userEntity;
        if(exists(userRequest))
        {
            UserEntity userEntityFromDB = userDao.findByUsername(userRequest.getUserName());
            userEntity = Updater.updateUserEntity(userEntityFromDB, userRequest);
        }
        else{
            userEntity = UserDomainMapper.map(userRequest);
        }

        return UserDomainMapper.map(userDao.save(userEntity));
    }

    @Override
    public List<User> findAllUsers() {
        List<UserEntity> userEntities = userDao.findAll();
        return UserDomainMapper.map(userEntities);
    }

    private boolean exists(User userRequest) {

        UserEntity userEntity;
        try{
            userEntity = userDao.findByUsername(userRequest.getUserName());

        }
        catch (Exception e){
            LOGGER.error(String.format("User '%s' is not exists", userRequest.getUserName()), e);
            throw e;
        }

        return (userEntity != null);
    }
}
