package com.example.eksamenbackend.Service;

import com.example.eksamenbackend.Model.Boat;
import com.example.eksamenbackend.Repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoatService {

    @Autowired
    BoatRepository database;

    public List<Boat> getAllBoats () {
        return database.findAll();
    }

    public void deleteAllBoats () {
        database.deleteAll();
    }

    public Boat getBoatById (int id) {
        return database.findById(id).orElse(null);
    }

    public Boat createBoat (Boat boat) {
        return database.save(boat);
    }

    public void deleteBoat (int id) {
        database.deleteById(id);
    }

    public Boat editBoatById (int id, Boat changes) throws Exception {

        var target = database.findById(id).orElse(null);

        if (target == null) {
            throw new Exception("The ID does not exist!");
        }

        target.setType(changes.getType());
        database.save(target);

        return target;
    }
}
