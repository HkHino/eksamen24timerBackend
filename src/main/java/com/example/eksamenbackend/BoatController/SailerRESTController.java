package com.example.eksamenbackend.BoatController;

import com.example.eksamenbackend.Model.SailerModel;
import com.example.eksamenbackend.Service.SailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class SailerRESTController {

    @Autowired
    SailerService sailerRepository;
    /**
     * This endpoint gets all sailers
     * @return List of sailers in the database
     */
    @GetMapping("/sailers")
    public ResponseEntity<List<SailerModel>> getAllsailers () {

        return new ResponseEntity<>(sailerRepository.getAllSailers(), HttpStatus.OK);
    }

    /**
     * This endpoint deletes all sailers.
     * @return null
     */
    @DeleteMapping("/sailers")
    public ResponseEntity deleteAllBoats () {

        sailerRepository.deleteAllSailers();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * This endpoint gets a single sailer by ID
     * @param id - The id on the sail
     * @return a sail object
     */
    @GetMapping("/sailers/{id}")
    public ResponseEntity<SailerModel> getsailerById (@PathVariable("id") Integer id) {

        var result = sailerRepository.getSailerById(id);

        // Error handling, if ID does not exist.
        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * This endpoint creates a new sailer, from a sailer object
     * @param sailer - The sailer to create.
     * @return The created sailer.
     */
    @PutMapping("/sailers")
    public ResponseEntity<SailerModel> createsailer (@RequestBody SailerModel sailer) {

        // Error handling, in case the provided model is missing fields.
        if (sailer.IsValid() == false) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        // TODO: Maybe catch exception and error handle.
        var result = sailerRepository.createSailer(sailer);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * This endpoint deletes a specific sailer by the id.
     * @param id - The id on the sailer.
     * @return nothing.
     */
    @DeleteMapping("/sailers/{id}")
    public ResponseEntity deleteSailers (@PathVariable int id) {

        // TODO: Maybe catch exception and error handle.
        sailerRepository.deleteSailer(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * This endpoint allows for changes to a sailers, by id.
     * @param id - The id on the sailer to change.
     * @param sailer - The new sailer object with the changed values.
     * @return The new and changed object.
     */
    @PostMapping("sailer/{id}")
    public ResponseEntity<SailerModel> editSailer (@PathVariable("id") int id, @RequestBody SailerModel sailer) {

        // Error handling, in case the provided model is missing fields.
        if (sailer.IsValid() == false) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try
        {
            var result = sailerRepository.editSailerById(id, sailer);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception exception)
        {
            // Error handling, if ID does not exist.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}


