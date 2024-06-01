package com.desafioPicpay.desafioPicpay.services;

import com.desafioPicpay.desafioPicpay.domain.user.User;
import com.desafioPicpay.desafioPicpay.domain.user.UserType;
import com.desafioPicpay.desafioPicpay.dtos.UserDTO;
import com.desafioPicpay.desafioPicpay.repostories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuario do tipo logista não esta aturizado a realizar transações");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo Insuficiente");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuaruio não encontrado"));

    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }


    public void saveUser(User user) {
        this.repository.save(user);
    }
}
