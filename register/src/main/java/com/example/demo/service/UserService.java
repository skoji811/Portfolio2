package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
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

public User findById(Long id) {
    return userRepository.findById(id).get();
  }

public void update(UserUpdateRequest userUpdateRequest) {
    User user = findById(userUpdateRequest.getId());
    user.setJan(userUpdateRequest.getJan());
    user.setManufacturer(userUpdateRequest.getManufacturer());
    user.setName(userUpdateRequest.getName());
    user.setExpiration(userUpdateRequest.getExpiration());
    user.setUpdateDate(new Date());
    userRepository.save(user);
  }

public void delete(Long id) {
	User user = findById(id);
	userRepository.delete(user);
}
}
