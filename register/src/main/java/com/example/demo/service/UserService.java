package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

@Autowired
private UserRepository userRepository;

public List<User> SearchAll(){
	return userRepository.findAll();
}

public void create(UserRequest userRequest) {
    Date now = new Date();
    User user = new User();
    user.setJan(userRequest.getJan());
    user.setManufacturer(userRequest.getManufacturer());
    user.setName(userRequest.getName());
    user.setExpiration(userRequest.getExpiration());
    user.setCreateDate(now);
    user.setUpdateDate(now);
    userRepository.save(user);
}
}
