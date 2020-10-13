package com.example.account.controller

import com.example.account.model.dto.user.NewUserDTO
import com.example.account.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UserController (private val userService: UserService) {

    @GetMapping
    fun list() = userService.findAll();

    @GetMapping("{id}")
    fun find(@PathVariable id: Long) = userService.find(id);

    @PostMapping
    fun store(@RequestBody newUserDTO: NewUserDTO) = userService.store(newUserDTO);

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody newUserDTO: NewUserDTO) = userService.update(id, newUserDTO);

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = userService.destroy(id);
}
