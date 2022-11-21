package tn.esprit.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Equipe;
import tn.esprit.firstproject.services.IEquipeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipe")
public class EquipeRestController {
    private final IEquipeService iEquipeService;
    @GetMapping("/all")
    @ResponseBody
    public List<Equipe> getAllEquipes(){
        return  iEquipeService.retrieveAllEquipes();
    }
    @PostMapping("/add")
    public Equipe addEquipe(@RequestBody Equipe equipe){
        return  iEquipeService.addEquipe(equipe);
    }
    @PutMapping("/update")
    public Equipe updateEquipe(@RequestBody Equipe equipe){
        return iEquipeService.updateEquipe(equipe);
    }
    @GetMapping("/get/{id-equipe}")
    public Equipe getById(@PathVariable("id-equipe") Integer id){
        return iEquipeService.retrieveEquipe(id);
    }

}
