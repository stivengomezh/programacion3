package com.edu.umanizales.first_api.controller;

import com.edu.umanizales.first_api.model.Kid;
import com.edu.umanizales.first_api.model.Node;
import com.edu.umanizales.first_api.service.ListSEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listse")
public class ListSEController {
    @Autowired
    // Este es para que aparezca y se vaya cuando termine su tarea

    private ListSEService listSEService;
    @GetMapping
    public Node getListChildren(){
        return listSEService.showKids();
    }
    @PostMapping
    public String addKidToFinal(@RequestBody  Kid kid){
        if(kid.age<0){
            return "Invalid Age";
        }

        listSEService.getListSE().addKidToFinal(kid);
        return "Adicionado exitosamente";
    }
    @PostMapping("/tostart")
    public String addKidToStart(@RequestBody  Kid kid){
        if(kid.age<0){
            return "Invalid Age";
        }

        listSEService.getListSE().addKidToStart(kid);
        return "Adicionado exitosamente";
    }
    @PostMapping("/inposition/{position}")
    public String addKidInPosition(@RequestBody  Kid kid,@PathVariable int position) {
        if(kid.age<0){
            return "Invalid Age";
        }
        if(position<0){
            return "Invalid Position";
        }
        listSEService.getListSE().addKidInPosition(kid, position);
        return "Adicionado exitosamente en la posición indicada";
    }
    @GetMapping("/invest")
    public String investKids() {
        listSEService.getListSE().investKids();
        return "Invertido exitosamente";
    }

    @PostMapping("/deletePosition/{position}")
    public String deleteForPosition(@PathVariable int position) {
       listSEService.getListSE().deleteForPosition(position);
       return "Eliminado exitosamente";
    }
    @PostMapping("/deleteID/{id}")
    public String deleteID(@PathVariable int id) {
        listSEService.getListSE().deleteForID(id);
        return "Eliminado exitosamente";
    }
@GetMapping("/interleaveGender")
    public String interleaveGender() {
        listSEService.getListSE().interleaveByGender();
        return "Intercalado exitosamente";
}
@GetMapping("/interleaveHeadAndTail")
    public String interleaveHeadAndTail() {
        listSEService.getListSE().interleaveHeadAndTail();
        return "Intercalado exitosamente";
}


}
