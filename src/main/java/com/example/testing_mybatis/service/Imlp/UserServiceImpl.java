package com.example.testing_mybatis.service.Imlp;

import com.example.testing_mybatis.Dto.UserPostDto;
import com.example.testing_mybatis.model.entity.User;
import com.example.testing_mybatis.provider.UserMapStruct;
import com.example.testing_mybatis.repository.UserRepository;
import com.example.testing_mybatis.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapStruct userMapStruct;
    private final UserRepository userRepository;


    @Override
    public int insertNewUser(UserPostDto userPostDto) {
        User user = userMapStruct.fromUserPostDto(userPostDto);
        return userRepository.insetNewUser(user);
    }
}
