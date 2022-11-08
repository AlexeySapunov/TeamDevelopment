package ru.gb.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.gb.database.model.Rating;
import ru.gb.database.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query("select distinct u " +
            "from User u " +
            "left join fetch u.roles " +
            "where u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);

    @Query("select distinct u " +
            "from User u " +
            "left join fetch u.rating " +
            "where u.rating = :rating")
    Optional<User> findUserByRating(@Param("rating") Rating rating);
}
