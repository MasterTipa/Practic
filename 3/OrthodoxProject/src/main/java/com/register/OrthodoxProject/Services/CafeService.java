package com.register.OrthodoxProject.Services;

import com.register.OrthodoxProject.Repository.CafeRepository;
import com.register.OrthodoxProject.TableInfo.Cafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class CafeService {
    @Autowired
    private final CafeRepository cafeRepository;
    @Autowired
    public CafeService(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    @Autowired
    public List<Cafe> getCafe() {
        return cafeRepository.findAll();
    }

    public void addNewCafe(Cafe cafe) {
        cafeRepository.save(cafe);
        System.out.println("cafe:"+cafe.getId()+"is added");
    }

    public void deleteCafe(Integer id) {
        boolean exists = cafeRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Cafe with id: "+id+" does not exists");
        }
        else {
            cafeRepository.deleteById(id);
            System.out.println("Cafe with id: "+id+" was delete");
        }
    }
@Transactional
    public void updateCafe(int id, String name, String place, Double score, Integer table_cout, Integer max_table) {
    Cafe cafe = cafeRepository.findById(id)
            .orElseThrow(()-> new IllegalStateException("Cafe with id: "+id+" does not exists"));
    if (name!=null && name.length()>0 && !Objects.equals(cafe.getName(), name)){
        cafe.setName(name);
    }
    if (place!=null && place.length()>0 && !Objects.equals(cafe.getName(), place)){
        cafe.setName(place);
    }
    if(score>0&&
            !Objects.equals(cafe.getScore(), score)
    ){
        cafe.setScore(score);
    }
    if(table_cout>0&&
            !Objects.equals(cafe.getScore(), table_cout)
    ){
        cafe.setTableCout(table_cout);
    }
    if(max_table>0&&
            !Objects.equals(cafe.getMaxTable(), max_table)
    ){
        cafe.setMaxTable(max_table);
    }
}
}
