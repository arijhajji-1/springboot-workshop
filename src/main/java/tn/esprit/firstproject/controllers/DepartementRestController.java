package tn.esprit.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.services.IDepartementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dep")
public class DepartementRestController {
    @GetMapping("/get/{id-dep}")

    public Departement getById(@PathVariable("id-dep") Integer id){
        return iDepartementService.retrieveDepartement(id);
    }
    private final IDepartementService iDepartementService;
    @PostMapping("/add")
    public Departement addDepar(@RequestBody Departement dep){
        return  iDepartementService.addDepartement(dep);
    }
    @GetMapping("/all")
    @ResponseBody
    public List<Departement> getDepart() {
        return iDepartementService.retrieveAllDepartements();
    }
    @PutMapping("/updateDepar/{id}")
    public Departement Departementupdate(@PathVariable("id") Integer id){
        Departement d=iDepartementService.retrieveDepartement(id);
        return iDepartementService.updateDepartement(d);


    }
    @PutMapping("/update/{id}/{idDep}")
    public Departement addDepar(@PathVariable("id") Integer id ,@PathVariable("idDep") Integer idDep){
        return  iDepartementService.affecterEtudiant(id,idDep);
    }

}
