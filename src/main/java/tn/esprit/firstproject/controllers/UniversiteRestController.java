package tn.esprit.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.services.IUniversiteService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {
    private  final IUniversiteService iUniversiteService;
    @GetMapping("/all")
    @ResponseBody
    public List<Universite> getAllUni(){
        return iUniversiteService.retrieveAllUniversites();
    }
    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite universite){
        return iUniversiteService.addUniversite(universite);
    }
    @PutMapping ("/update")
    public Universite updateUni(@RequestBody Universite universite){
        return iUniversiteService.updateUniversite(universite);
    }
    @GetMapping("/get/{id-uni}")
    public Universite getById(@PathVariable("id-uni")Integer id){
        return iUniversiteService.retrieveUniversite(id);

    }
    @PutMapping("/assign/{idUniv}/{idDepart}")
    void assignUniversiteToDepartement(@PathVariable("idUniv") Integer idUniv, @PathVariable("idDepart") Integer idDep){
        iUniversiteService.assignUniversiteToDepartement(idUniv, idDep);
    }
    @GetMapping("/getDep/{idUniv}")
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable("idUniv") Integer idUniversite)
    {
        return iUniversiteService.retrieveDepartementsByUniversite(idUniversite);
    }
}
