package project.aqua_notes.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.aqua_notes.Entities.RoleEntity;
import project.aqua_notes.Repositories.RoleRepository;

@Service
public class RoleService {
    
    @Autowired
    private final RoleRepository roleRepo;

    public RoleService(RoleRepository roleRepo)
    {
        this.roleRepo = roleRepo;
    }

    public List<RoleEntity> getAll(){
        return roleRepo.findAll();
    }
}
