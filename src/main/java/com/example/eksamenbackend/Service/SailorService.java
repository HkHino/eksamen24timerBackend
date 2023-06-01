package com.example.eksamenbackend.Service;

import com.example.eksamenbackend.Model.Sailor;
import com.example.eksamenbackend.Repository.SailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        //todo validering senere
        /*if(sailor.getContestId()<1 || sailor.getContestId()>3)
        {

        }*/

        return database.save(sailor);
    }

    public void deleteSailors(int id) {
        database.deleteById(id);
    }

    public Sailor editSailorById(int id, Sailor sailor) throws Exception {
        Optional<Sailor> databasePoints = database.findById(id);
        int points = databasePoints.get().getPoints();
        if(sailor.getPoints() == -1 || sailor.getPoints() == -2)
        {
            List<Sailor> allByContestId = database.findAllByContestId(sailor.getContestId());
            points+= allByContestId.size()+1;
        } else if (sailor.getPoints() == -3) {
            List<Sailor> allByContestId = database.findAllByContestId(sailor.getContestId());
            points+= allByContestId.size()+2;

        }
        Sailor newSailor = Sailor.builder().contestId(sailor.getContestId()).points(points).build();
        database.save(newSailor);

        return sailor;
    }
}
