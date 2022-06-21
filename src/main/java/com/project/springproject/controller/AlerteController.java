package com.project.springproject.controller;

import com.project.springproject.entities.Alertes;
import com.project.springproject.exceptions.ResourceNotFoundException;
import com.project.springproject.services.AlerteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alertes")
public class AlerteController {

    @Autowired
    private AlerteService alerteService;

    @Operation(summary = "Récupération d'alerte à partir de son identifiant")
    @ApiResponse(responseCode = "404", description = "Alerte non trouvé")
    @RequestMapping(path = "/{id_alertes}", method = RequestMethod.GET)
    public Alertes get(@PathVariable(name = "id_alertes") Long alerte) throws ResourceNotFoundException {
        return alerteService.getAlerteById(alerte);
    }

    @Operation(summary = "Modification ou ajout d'une alerte")
    @RequestMapping(method = RequestMethod.PUT)
    public Alertes createOrUpdate(@RequestBody @Valid Alertes alerte){
        return alerteService.createOrUpdate(alerte);
    }

    @Operation(summary = "Récupération de toutes les annonces")
    @RequestMapping(path = "/_all", method = RequestMethod.GET)
    public List<Alertes> getAllAlertes() {
        return alerteService.getAllAlertes();
    }

    @RequestMapping(path = "/{id_alertes}", method = RequestMethod.DELETE)
    public void deleteAlerte(@PathVariable(name = "id_alertes") String username) {
        alerteService.deleteAlerte(username);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Alertes> getAlertes(Pageable pageable) {
        return alerteService.getAlerteWithPaging(pageable);
    }
}
