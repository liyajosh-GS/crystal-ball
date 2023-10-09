package com.project.crystalBall.service.impl.User;

import com.project.crystalBall.dto.User.User;
import com.project.crystalBall.entity.user.UserEntity;
import com.project.crystalBall.exception.NoSuchItemFoundException;
import com.project.crystalBall.mapper.user.UserDtoEntityMapper;
import com.project.crystalBall.repository.UserRepository;
import com.project.crystalBall.service.impl.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends AbstractCrudService<User, Long, UserEntity> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDtoEntityMapper mapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserDtoEntityMapper mapper) {
        super(userRepository, mapper);
    }

    public User create(User user){
        Optional<UserEntity> existingUser = userRepository.findByUserName(user.getUserName());
        if(existingUser.isEmpty()){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return super.create(user);
        } else {
            throw new RuntimeException("Existing user name");
        }
    }

    public User readByUserNameAndPassword(String userName, String password) {
        Optional<UserEntity> existingUser = userRepository.findByUserName(userName);
        if(existingUser.isEmpty()){
            throw new RuntimeException("User name does not exist");
        } else {
            if(passwordEncoder.matches(password, existingUser.get().getPassword())){
                return mapper.convertToDto(existingUser.get());
            } else {
                throw new RuntimeException("User name and password combination fails");
            }
        }
    }

    public User readByUserName(String userName) {
        Optional<UserEntity> existingUser = userRepository.findByUserName(userName);
        return existingUser.map(e -> mapper.convertToDto(e)).orElseThrow(() -> new NoSuchItemFoundException("User does not exist"));
    }
}
