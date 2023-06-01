package com.example.eksamenbackend.BoatController;

import com.example.eksamenbackend.Model.Sailor;
import com.example.eksamenbackend.Service.SailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SailorRESTController {
    @Autowired
    SailorService sailorRepository;

    /**
     * This endpoint gets all Sailors
     *
     * @return List of Sailors in the database
     */
    @GetMapping("/sailors")
    public ResponseEntity<List<Sailor>> getAllSailors() {

        return new ResponseEntity<>(sailorRepository.getAllSailors(), HttpStatus.OK);
    }

    /**
     * This endpoint deletes all Sailors.
     *
     * @return null
     */
    @DeleteMapping("/sailors")
    public ResponseEntity deleteAllSailors() {

        sailorRepository.deleteAllSailors();

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * This endpoint gets a single sailor by ID
     *
     * @param id - The id on the sail
     * @return a sail object
     */
    @GetMapping("/sailors/{id}")
    public ResponseEntity<Sailor> getSailorById(@PathVariable("id") int id) {

        var result = sailorRepository.getSailorById(id);

        // Error handling, if ID does not exist.
        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * This endpoint creates a new sailor, from a sailor object
     *
     * @param sailor - The sailor to create.
     * @return The created sailor.
     */
    @PostMapping("/sailors")
    public ResponseEntity<Sailor> createSailor(@RequestBody Sailor sailor) {

        // TODO: Maybe catch exception and error handle.
        var result = sailorRepository.createSailor(sailor);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * This endpoint deletes a specific sailor by the id.
     *
     * @param id - The id on the sailor.
     * @return nothing.
     */
    @DeleteMapping("/sailor/{id}")
    public ResponseEntity deleteSailorById(@PathVariable int id) {

        // TODO: Maybe catch exception and error handle.
        sailorRepository.deleteSailors(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * This endpoint allows for changes to a sailors, by id.
     *
     * @param id      - The id on the sailor to change.
     * @param changes - The new sailor object with the changed values.
     * @return The new and changed object.
     */
    @PostMapping("sailor/{id}")
    public ResponseEntity<Sailor> editSailor(@PathVariable("id") int id, @RequestBody Sailor changes) {

        try {
            var result = sailorRepository.editSailorById(id, changes);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception exception) {
            // Error handling, if ID does not exist.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
