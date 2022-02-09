package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {

@Autowired
private UserService userService;

@GetMapping("/user/list")
public String displayList(Model model) {
	List<User> userlist = userService.SearchAll();
	model.addAttribute("userlist",userlist);
	return "user/list";
}

@GetMapping("/user/add")
public String displayAdd(Model model) {
	model.addAttribute("userRequest", new UserRequest());
	return "user/add";
}

@PostMapping("/user/create")
public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
        
        List<String> errorList = new ArrayList<String>();
        for (ObjectError error : result.getAllErrors()) {
          errorList.add(error.getDefaultMessage());
        }
        model.addAttribute("validationError", errorList);
        return "user/add";
      }
      
      userService.create(userRequest);
      return "redirect:/user/list";
    }

	
@GetMapping("/user/{id}")
public String displayView(@PathVariable Long id, Model model) {
    User user = userService.findById(id);
    model.addAttribute("userData", user);
	return "user/view";
}

@GetMapping("/user/{id}/edit")
public String displayEdit(@PathVariable Long id, Model model) {
  User user = userService.findById(id);
  UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
  userUpdateRequest.setId(user.getId());
  userUpdateRequest.setJan(user.getJan());
  userUpdateRequest.setManufacturer(user.getManufacturer());
  userUpdateRequest.setName(user.getName());
  userUpdateRequest.setExpiration(user.getExpiration());
  model.addAttribute("userUpdateRequest", userUpdateRequest);
  return "user/edit";
}
@PostMapping("/user/update")
public String update(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result, Model model) {
  if (result.hasErrors()) {
    List<String> errorList = new ArrayList<String>();
    for (ObjectError error : result.getAllErrors()) {
      errorList.add(error.getDefaultMessage());
    }
    model.addAttribute("validationError", errorList);
    return "user/edit";
  }
  userService.update(userUpdateRequest);
  return String.format("redirect:/user/%d", userUpdateRequest.getId());
}






}
