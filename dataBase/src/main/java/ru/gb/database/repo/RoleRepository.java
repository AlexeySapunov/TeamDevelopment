package ru.gb.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.database.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
