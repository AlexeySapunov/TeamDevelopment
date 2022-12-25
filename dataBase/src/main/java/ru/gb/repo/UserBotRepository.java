package ru.gb.repo;

import org.springframework.data.repository.CrudRepository;
import ru.gb.model.UserBot;

public interface UserBotRepository extends CrudRepository<UserBot, Long> {
}
