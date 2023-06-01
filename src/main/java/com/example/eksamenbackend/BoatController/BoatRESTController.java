package com.example.eksamenbackend.BoatController;

import com.example.eksamenbackend.Model.Boat;
import com.example.eksamenbackend.Service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class BoatRESTController {

    @Autowired
    BoatService boatRepository;

    /**
     * This endpoint gets all boats
     * @return List of boats in the database
     */
    @GetMapping("/boats")
    public ResponseEntity<List<Boat>> getAllBoats () {
        return new ResponseEntity<>(boatRepository.getAllBoats(), HttpStatus.OK);
    }

    /**
     * This endpoint deletes all boats.
     * @return null
     */
    @DeleteMapping("/boats")
    public ResponseEntity deleteAllBoats () {

        boatRepository.deleteAllBoats();

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * This endpoint gets a single boat by ID
     * @param id - The id on the boat
     * @return a boat object
     */
    @GetMapping("/boats/{id}")
    public ResponseEntity<Boat> getBoatById (@PathVariable("id") int id) {

        var result = boatRepository.getBoatById(id);

        // Error handling, if ID does not exist.
        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * This endpoint creates a new boat, from a boat object
     * @param boat - The boat to create.
     * @return The created boat.
     */
    @PutMapping("/boats")
    public ResponseEntity<Boat> createBoat (@RequestBody Boat boat) {

        // Error handling, in case the provided model is missing fields.
        if (boat.IsValid() == false) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        // TODO: Maybe catch exception and error handle.
        var result = boatRepository.createBoat(boat);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * This endpoint deletes a specific boat by the id.
     * @param id - The id on the boat.
     * @return nothing.
     */
    @DeleteMapping("/boats/{id}")
    public ResponseEntity deleteBoatById (@PathVariable int id) {

        // TODO: Maybe catch exception and error handle.
        boatRepository.deleteBoat(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * This endpoint allows for changes to a boats, by id.
     * @param id - The id on the boat to change.
     * @param changes - The new boat object with the changed values.
     * @return The new and changed object.
     */
    @PostMapping("boats/{id}")
    public ResponseEntity<Boat> editBoatById (@PathVariable("id") int id, @RequestBody Boat changes) {

        // Error handling, in case the provided model is missing fields.
        if (changes.IsValid() == false) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try
        {
            var result = boatRepository.editBoatById(id, changes);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception exception)
        {
            // Error handling, if ID does not exist.
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

//todo 22 uger mellem første maj og første oktober dvs 66 "løb" afholdes