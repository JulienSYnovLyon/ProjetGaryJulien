package com.project.springproject.controller;

import com.project.springproject.entities.Roles;
import com.project.springproject.exceptions.ResourceNotFoundException;
import com.project.springproject.services.RolesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RolesService roleService;

    @Operation(summary = "Récupération d'un role à partir de son identifiant")
    @ApiResponse(responseCode = "404", description = "Role non trouvé")
    @RequestMapping(path = "/{id_role}", method = RequestMethod.GET)
    public Roles get(@PathVariable(name = "id_role") Short id) throws ResourceNotFoundException {
        return roleService.getRoleById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @Operation(summary = "Modification ou ajout d'un role")
    public Roles createOrUpdate(@RequestBody @Valid Roles role){
        return roleService.createOrUpdate(role);
    }

    @Operation(summary = "Récupération de tous les utilisateurs")
    @RequestMapping(path = "/_all", method = RequestMethod.GET)
    public List<Roles> getAllRoles() {
        return roleService.getAllRoles();
    }

    @RequestMapping(path = "/{id_Roles}", method = RequestMethod.DELETE)
    public void deleteRole(@PathVariable(name = "id_Roles") String rolename) {
        roleService.deleteRole(rolename);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Roles> getRoles(Pageable pageable) {
        return roleService.getRoleWithPaging(pageable);
    }
}
