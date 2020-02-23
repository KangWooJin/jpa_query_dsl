package springboot.gradle.querydsl.demo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import springboot.gradle.querydsl.demo.user.User;
import springboot.gradle.querydsl.demo.user.UserService;

@Transactional
@AutoConfigureTestEntityManager
@SpringBootTest
class UserServiceTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private UserService userService;

    @Test
    void findByIdTest() {
        // Given
        User user = new User();
        String name = "woojin";
        user.setName(name);

        User savedUser = testEntityManager.persist(user);

        // When
        User actual = userService.findById(savedUser.getId());

        // Then

        assertThat(actual).isNotNull();
        assertThat(actual.getName()).isEqualTo(name);
    }
}
