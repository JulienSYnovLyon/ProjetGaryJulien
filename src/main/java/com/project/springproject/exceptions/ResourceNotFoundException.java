package com.project.springproject.exceptions;

public class ResourceNotFoundException extends Exception{
    private String type_ressource;
    private String identifiant;

    public String getType_ressource() {
        return type_ressource;
    }

    public void setType_ressource(String type_ressource) {
        this.type_ressource = type_ressource;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public ResourceNotFoundException(Class<?> resourceType, Object resourceId) {
        super("<center><h1 style=\"color: red\">" + resourceType.getSimpleName() + " " + resourceId + " not found</h1></center>");
    }

}

