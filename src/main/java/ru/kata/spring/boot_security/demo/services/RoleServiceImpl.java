package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.services.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.getRoleByName(name);
    }

}
