package com.project.springproject.controller;

import com.project.springproject.entities.TypeAnnonce;
import com.project.springproject.exceptions.ResourceNotFoundException;
import com.project.springproject.services.TypeAnnonceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/typeannonce")
public class TypeAnnonceController {

    @Autowired
    private TypeAnnonceService typeAnnonceService;

    @Operation(summary = "Récupération d'un type d'annonce à partir de son identifiant")
    @ApiResponse(responseCode = "404", description = "Type d'annonce non trouvé")
    @RequestMapping(path = "/{id_typeannonce}", method = RequestMethod.GET)
    public TypeAnnonce get(@PathVariable(name = "id_typeannonce") Short type) throws ResourceNotFoundException {
        return typeAnnonceService.getTypeAnnonceById(type);
    }

    @Operation(summary = "Modification ou ajout d'un type d'annonce")
    @RequestMapping(method = RequestMethod.PUT)
    public TypeAnnonce createOrUpdate(@RequestBody @Valid TypeAnnonce type) {
        return typeAnnonceService.createOrUpdate(type);
    }

    @Operation(summary = "Récupération de tous les type d'annonces")
    @RequestMapping(path = "/_all", method = RequestMethod.GET)
    public List<TypeAnnonce> getAllTypeAnnonces() {
        return typeAnnonceService.getTypeAnnonceUsers();
    }

    @RequestMapping(path = "/{id_typeannonce}", method = RequestMethod.DELETE)
    public void deleteType(@PathVariable(name = "id_typeannonce") String type) {
        typeAnnonceService.deleteType(type);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<TypeAnnonce> getTypeAnnonces(Pageable pageable) {
        return typeAnnonceService.getTypeAnnonceWithPaging(pageable);
    }
}
