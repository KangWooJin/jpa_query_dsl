package springboot.gradle.querydsl.demo.user;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQuery;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    private static final QUser qUser = QUser.user;
    private final EntityManager entityManager;

    public User findById(Long id) {
        JPAQuery<User> query = new JPAQuery<>(entityManager);

        query.from(qUser)
             .where(qUser.id.eq(id));

        return query.fetchOne();
    }
}
