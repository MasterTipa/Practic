package com.register.OrthodoxProject.Controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.register.OrthodoxProject.Services.CafeService;
import com.register.OrthodoxProject.TableInfo.Cafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "cafe")
public class CafesController {
    private final CafeService cafeService;
    @Autowired
    public CafesController(CafeService cafeService){
        this.cafeService=cafeService;
    }
    @GetMapping
    public List<Cafe> getCafe(){
        return cafeService.getCafe();
    }
    @PostMapping
    public void registerNewCafe(@RequestBody Cafe cafe){
        cafeService.addNewCafe(cafe);
    }
    @DeleteMapping(path = "{id}")
    public void deleteCafe(
            @PathVariable("id") Long id) {
        cafeService.deleteCafe(id);
    }
    @Transactional
    @PutMapping(path = "{id}")
    public void updateCafe(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String place,
            @RequestParam(required = false) Double score,
            @RequestParam(required = false) Integer table_cout,
            @RequestParam(required = false) Integer max_table
    ){
        cafeService.updateCafe(id, name, place, score, table_cout, max_table);
    }

}
