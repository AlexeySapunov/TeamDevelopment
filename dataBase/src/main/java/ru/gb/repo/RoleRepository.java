package ru.gb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
