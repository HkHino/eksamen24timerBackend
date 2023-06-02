/*package com.example.eksamenbackend.Model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.sql.SQLException;
import java.util.Date;

public class eventPlanning {

    public void createEvents(EntityManager em) throws SQLException {
        // Get the start date
        Date date = new Date(2020, 05, 01);
        long startTime = date.getTime();

        // Get the end date
        date = new Date(2020, 10, 01);
        long endTime = date.getTime();

        // Create a query to insert events
        String queryStr = "INSERT INTO events (name, start_time, end_time)VALUES (:name, :start_time, :end_time)";
        Query query = em.createQuery(queryStr);

        // Loop through and create events
        for (int i = 1; i <= 22; i++) {
            // Calculate the start and end times of the event
            long eventStartTime = startTime + (i * 7 * 24 * 60 * 60 * 1000);
            long eventEndTime = eventStartTime + (1 * 24 * 60 * 60 * 1000);

            // Set the parameters
            query.setParameter("name", "Kap" + i);
            query.setParameter("start_time", eventStartTime);
            query.setParameter("end_time", eventEndTime);

// Execute the query
            query.executeUpdate();
            // Close the query
            query.close();
        }
    }
}

 */