package com.example.eksamenbackend.Service;

import com.example.eksamenbackend.Model.SailerModel;
import com.example.eksamenbackend.Repository.SailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SailerService {
    @Autowired
    SailerRepository database;

    public List<SailerModel> getAllSailers () {
        return database.findAll();
    }

    public void deleteAllSailers () {
        database.deleteAll();
    }

    public SailerModel getSailerById (int id) {
        return database.findById(id).orElse(null);
    }

    public SailerModel createSailer (SailerModel boat) {
        return database.save(sailer);
    }

    public void deleteSailer (int id) {
        database.deleteById(id);
    }

    public SailerModel editSailerById (int id, SailerModel sailer) throws Exception {

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
