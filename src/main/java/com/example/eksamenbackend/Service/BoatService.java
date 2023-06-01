package com.example.eksamenbackend.Service;

import com.example.eksamenbackend.Model.BoatModel;
import com.example.eksamenbackend.Repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoatService {

    @Autowired
    BoatRepository database;

    public List<BoatModel> getAllBoats () {
        return database.findAll();
    }

    public void deleteAllBoats () {
        database.deleteAll();
    }

    public BoatModel getBoatById (int id) {
        return database.findById(id).orElse(null);
    }

    public BoatModel createBoat (BoatModel boat) {
        return database.save(boat);
    }

    public void deleteBoat (int id) {
        database.deleteById(id);
    }

    public BoatModel editBoatById (int id, BoatModel boat) throws Exception {

        var target = database.findById(id).orElse(null);

        if (target == null) {
            throw new Exception("The ID does not exist!");
        }

        target.setPoints(boat.getPoints());
        /*target.setDato(boat.getDato());
        target.setFod25(boat.get()); //todo spørg philip om en bedre løsning
        target.setFod25_40(boat.get());
        target.setFod40(boat.get());
        */
        database.save(target);

        return target;
    }
}
