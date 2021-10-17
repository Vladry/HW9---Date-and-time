package hw9.family.Controller;

import hw9.family.service.Services;

public class FamilyController {
    public Services FamilyService ;

    public FamilyController(Services service) {
        this.FamilyService  = service;
    }
}
