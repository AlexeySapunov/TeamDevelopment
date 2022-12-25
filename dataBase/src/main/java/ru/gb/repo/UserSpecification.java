package ru.gb.repo;

import org.springframework.data.jpa.domain.Specification;
import ru.gb.model.User;

public class UserSpecification {

    public static Specification<User> nameLike(String pattern){
        return (root,query,builder) -> builder.like(root.get("username"),"%" + pattern + "%");
    }

    public static Specification<User> minAge(Integer minAge) {
        return (root, query, builder) -> builder.ge(root.get("age"), minAge);
    }

    public static Specification<User> maxAge(Integer maxAge) {
        return (root, query, builder) -> builder.le(root.get("age"), maxAge);
    }
}
