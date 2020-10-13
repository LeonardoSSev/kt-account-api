package com.example.account.service

import com.example.account.model.dto.user.NewUserDTO
import com.example.account.model.dto.user.UserDTO
import com.example.account.model.entity.User
import com.example.account.repository.UserRepository
import javassist.NotFoundException
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService (private val userRepository: UserRepository) {

    fun findAll(): List<UserDTO> {
        val users =  userRepository.findAll();

        return users.map{user ->  UserDTO(name = user.name, email = user.email)};
    }

    fun store(newUserDTO: NewUserDTO): UserDTO {
        val userEntity = User(name = newUserDTO.name, creationDate = LocalDateTime.now(), email = newUserDTO.email);

        val savedUser = userRepository.save(userEntity);

        val savedUserDTO = UserDTO(name = savedUser.name, email = savedUser.email);

        return savedUserDTO;
    }

    fun find(id: Long): UserDTO {
        val user = userRepository.findById(id)
                .orElse(null) ?: throw NotFoundException("User not found");

        val userDTO = UserDTO(name = user.name, email = user.email);

        return userDTO;
    }

    fun update(id: Long, newUserDTO: NewUserDTO): UserDTO {
        val user = userRepository.findById(id)
                .orElse(null) ?: throw NotFoundException("User not found");

        val updatedUserCopy = user.copy(name = newUserDTO.name, email = newUserDTO.email);

        val updatedUser = userRepository.save(updatedUserCopy);

        val updatedUserDTO = UserDTO(name = updatedUser.name, email = updatedUser.email);

        return updatedUserDTO;
    }

    fun destroy(id: Long): Unit {
        val user = userRepository.findById(id)
                .orElse(null) ?: throw NotFoundException("User not found");

        userRepository.delete(user);
    }
}