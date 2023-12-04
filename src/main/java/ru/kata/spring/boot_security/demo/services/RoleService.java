package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRoles();

    void saveRole(Role role);

    void deleteRole(Long id);

    Role getRoleByName(String name);
}
