package ru.gb.database.repo;

import org.springframework.data.repository.CrudRepository;
import ru.gb.database.model.UserBot;

public interface UserBotRepository extends CrudRepository<UserBot, Long> {
}
