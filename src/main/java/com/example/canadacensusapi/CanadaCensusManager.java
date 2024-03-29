package com.example.canadacensusapi;

import jakarta.persistence.*;
import model.GeographicArea;

import java.util.List;

public class CanadaCensusManager {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CanadaCensusManager");
        EntityManager em = emf.createEntityManager();

        try {
            // Question2.
            Question2(em);

            // Question3.
            Question3(em);

            // Question4.


            // Question5.


        } finally {
            em.close();
            emf.close();
        }
    }

    /**
     * Queries and prints the name of the geographic area with ID 10.
     * of a GeographicArea entity by its ID. If the entity with the specified ID is not found,
     * it prints a message indicating the geographic area was not found.
     */
    private static void Question2(EntityManager em) {
        String queryString = "SELECT g.name FROM GeographicArea g WHERE g.geographicAreaID = 10";
        Query query = em.createQuery(queryString);
        try {
            String areaName = (String) query.getSingleResult();
            System.out.println("Name of Geographic Area ID 10: " + areaName);
        } catch (NoResultException e) {
            System.out.println("Geographic Area with ID 10 not found.");
        }
    }

    /**
     * Queries and prints all geographic areas that have a level of 2.
     * This method demonstrates how to execute a JPQL query to fetch entire entities
     * based on a condition (level = 2). It then iterates over the result list and prints
     * each geographic area.
     */
    private static void Question3(EntityManager em) {
        String queryString = "SELECT g FROM GeographicArea g WHERE g.level = 2";
        TypedQuery<GeographicArea> queryForLevel2 = em.createQuery(queryString, GeographicArea.class);
        List<GeographicArea> areasLevel2 = queryForLevel2.getResultList();
        System.out.println("Geographic Areas with Level 2:");
        areasLevel2.forEach(System.out::println);
    }


}
