package com.example.eksamenbackend.Service;

import com.example.eksamenbackend.Model.Sailor;
import com.example.eksamenbackend.Repository.SailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SailorService
{
    @Autowired
    SailerRepository database;

    public List<Sailor> getAllSailors() {
        return database.findAll();
    }

    public void deleteAllSailors() {
        database.deleteAll();
    }

    public Sailor getSailorById(int id) {
        return database.findById(id).orElse(null);
    }

    public Sailor createSailor(Sailor sailor) {
        return database.save(sailor);
    }

    public void deleteSailors(int id) {
        database.deleteById(id);
    }

    public Sailor editSailorById(int id, Sailor sailor) throws Exception {

        var target = database.findById(id).orElse(null);

        if (target == null) {
            throw new Exception("The ID does not exist!");
        }
      /*
        target.setDato(boat.getDato());
        target.setFod25(boat.get()); //todo spørg philip om en bedre løsning
        target.setFod25_40(boat.get());
        target.setFod40(boat.get());
      */
        database.save(target);

        return target;
    }
}
