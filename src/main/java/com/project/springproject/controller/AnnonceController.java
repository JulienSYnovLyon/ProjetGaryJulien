package com.project.springproject.controller;

import com.project.springproject.entities.Annonces;
import com.project.springproject.exceptions.ResourceNotFoundException;
import com.project.springproject.services.AnnonceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/annonces")
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;

    @Operation(summary = "Récupération d'annonces à partir de son identifiant")
    @ApiResponse(responseCode = "404", description = "Annonce non trouvé")
    @RequestMapping(path = "/{id_annonces}", method = RequestMethod.GET)
    public Annonces get(@PathVariable(name = "id_annonces") Long annonce) throws ResourceNotFoundException {
        return annonceService.getUserById(annonce);
    }

    @Operation(summary = "Modification ou ajout d'une annonce")
    @RequestMapping(method = RequestMethod.PUT)
    public Annonces createOrUpdate(@RequestBody @Valid Annonces annonce){
        return annonceService.createOrUpdate(annonce);
    }

    @Operation(summary = "Récupération de toutes les annonces")
    @RequestMapping(path = "/_all", method = RequestMethod.GET)
    public List<Annonces> getAllUsers() {
        return annonceService.getAllUsers();
    }

    @RequestMapping(path = "/{id_annonces}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "id_annonces") String username) {
        annonceService.deleteUser(username);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Annonces> getUsers(Pageable pageable) {
        return annonceService.getUsersWithPaging(pageable);
    }
}
