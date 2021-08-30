package org.ada.school;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.repository.UserRepository;
import org.ada.school.service.UserService;
import org.ada.school.service.UserServiceMongoDB;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceAppTests
{

    @Autowired
    UserService userService;

    boolean hasMocked = false;

    @BeforeEach
    public void setUp() {
        if (!hasMocked) {
            mockData();
            hasMocked = true;
        }
    }


    private void mockData() {
        UserDto userDto = new UserDto();

        userDto.setName("Eduard");
        userDto.setEmail("eduard@mail.com");
        userDto.setLastName("Arias");
        userService.create(new User(userDto));

        userDto.setName("Ed");
        userDto.setEmail("");
        userDto.setLastName("Cartoon Network");
        userService.create(new User(userDto));

        userDto.setName("Edd");
        userDto.setEmail("");
        userDto.setLastName("Cartoon Network");
        userService.create(new User(userDto));

        userDto.setName("Eddy");
        userDto.setEmail("");
        userDto.setLastName("Cartoon Network");
        userService.create(new User(userDto));

        userDto.setName("Carlos");
        userDto.setEmail("eduard@mail.com");
        userDto.setLastName("Santana");
        userService.create(new User(userDto));
    }


    @Test
    public void queryMethod1() {
        try {
            userService.findUsersWithNameOrLastNameLike("Ed")
                    .stream()
                    .forEach(System.out::println);

            userService.findUsersWithNameOrLastNameLike("Santana")
                    .stream()
                    .forEach(System.out::println);

        } catch(Exception ex) {
            fail("An exception has occurred: "+ex.getLocalizedMessage());
        }
    }

}
