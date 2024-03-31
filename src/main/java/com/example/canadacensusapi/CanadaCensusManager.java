package com.example.canadacensusapi;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import model.Age;
import model.GeographicArea;
import model.TotalIncome;

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
            Question4(em);

            // Question5.
            Question5(em);


        } finally {
            em.close();
            emf.close();
        }
    }

    /**
     * Retrieves via Entity Manager's find method and then prints the name of the geographic area with ID 10.
     * If the entity with the specified ID is not found,
     * it prints a message indicating the geographic area was not found.
     */
    private static void Question2(EntityManager em) {
        try {
            GeographicArea geographicArea = em.find(GeographicArea.class, 10);

            System.out.println("------ Question 2 ------");
            System.out.println("Information of Geographic Area with the ID of 10");
            System.out.print("ID: " + geographicArea.getGeographicAreaID());
            System.out.print("  Name: " + geographicArea.getName());
            System.out.print("  Level: " + geographicArea.getLevel());
            System.out.print("  Code: " + geographicArea.getCode());
            System.out.println("    Alt Code: " + geographicArea.getAlternativeCode());
            System.out.println();

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
        System.out.println("------ Question 3 ------");
        System.out.println("Geographic Areas with Level 2:");
        areasLevel2.forEach(System.out::println);
        System.out.println();
    }

    /**
     * Queries and prints the count of households found for each specified criteria
     */
    private static void Question4(EntityManager em) {
        // Initialize each question's query
        String queryStringA = "SELECT COUNT(h.id) FROM HouseHold h WHERE h.censusYear = 2 AND h.householdType = 4"; // type id 4 = One couple census family without other persons in the household
        String queryStringB = "SELECT COUNT(h.id) FROM HouseHold h WHERE h.censusYear = 2 AND h.householdSize = 3"; // size id 3 = 2 or more persons
        String queryStringC = "SELECT COUNT(h.id) FROM HouseHold h WHERE h.censusYear = 2 AND h.householdEarners = 3"; // earners id 3 = 1 earner or more
        String queryStringD = "SELECT COUNT(h.id) FROM HouseHold h WHERE h.censusYear = 2 AND h.totalIncome = 15"; // income id 15 = $80,000 to $89,999

        // Get all query results to strings
        String resultA = em.createQuery(queryStringA).getSingleResult().toString();
        String resultB = em.createQuery(queryStringB).getSingleResult().toString();
        String resultC = em.createQuery(queryStringC).getSingleResult().toString();
        String resultD = em.createQuery(queryStringD).getSingleResult().toString();

        // Output the results in the console
        System.out.println("------ Question 4 ------");
        System.out.println("Count of households for 2016 Census with specific criteria:");
        System.out.println("A. One couple census family without other persons in the household: " + resultA);
        System.out.println("B. 2 or more members in the household: " + resultB);
        System.out.println("C. At least 1 earner in the household: " + resultC);
        System.out.println("D. Total income between $80,000 and $89,999: " + resultD);
        System.out.println();

    }

    /**
     * Uses Criteria to output various data to console according to specific requirements
     */
    private static void Question5(EntityManager em) {
        System.out.println("------ Question 5 ------");

        CriteriaBuilder cb = em.getCriteriaBuilder();

        // Question A
        CriteriaQuery<GeographicArea> cqA = cb.createQuery(GeographicArea.class); // Create CriteriaQuery for question A
        Root<GeographicArea> rootA = cqA.from(GeographicArea.class);
        cqA.multiselect(rootA.get("code"), rootA.get("level"), rootA.get("name"));
        List<GeographicArea> resultsA = em.createQuery(cqA).setMaxResults(10).getResultList();

        System.out.println("A. Use Multiselect to get Code, Level and Name from Geographic Area Table. Display 10 Records only:");
        for (GeographicArea result : resultsA) {
            System.out.print("Code: " + result.getCode());
            System.out.print("  Level: " + result.getLevel());
            System.out.println("  Name: " + result.getName());
        }
        System.out.println();

        // Question B
        CriteriaQuery<Integer> cqB = cb.createQuery(Integer.class); // Create CriteriaQuery for question B
        Root<Age> rootB = cqB.from(Age.class);
        cqB.select(rootB.get("combined")).orderBy(cb.desc(rootB.get("combined"))); // Selects combined ordered by/descending by combined
        List<Integer> resultsB = em.createQuery(cqB).setMaxResults(20).getResultList(); // Results are just a list of integers (the number of combined age)

        System.out.println("B. Display Top 20 combined Age information from Age Table order by Desc:");
        for (Integer result : resultsB) {
            System.out.println("Combined: " + result);
        }
        System.out.println();

        // Question C
        CriteriaQuery<GeographicArea> cqC = cb.createQuery(GeographicArea.class); // Create CriteriaQuery for question C
        Root<GeographicArea> rootC = cqC.from(GeographicArea.class);
        cqC.select(rootC).where(cb.equal(rootC.get("name"), "Peterborough")); // Selects where geographic area name = Peterborough
        List<GeographicArea> resultsC = em.createQuery(cqC).getResultList();

        System.out.println("C. Use Where Clause to Display information for Geographic Area named ‘Peterborough’:");
        for (GeographicArea result : resultsC) {
            System.out.print("GeographicAreaId: " + result.getGeographicAreaID());
            System.out.print("  Code: " + result.getCode());
            System.out.print("  Level: " + result.getLevel());
            System.out.print("  Name: " + result.getName());
            System.out.println("  AltCode: " + result.getAlternativeCode());
        }
        System.out.println();

        // Question D
        CriteriaQuery<TotalIncome> cqD = cb.createQuery(TotalIncome.class); // Create CriteriaQuery for question D
        Root<TotalIncome> rootD = cqD.from(TotalIncome.class);
        cqD.select(rootD).where(cb.between(rootD.get("id"), 10, 20)); // Selects all TotalIncome descriptinos with ID from 10 to 20
        List<TotalIncome> resultsD = em.createQuery(cqD).getResultList();

        System.out.println("D. Display Total Income Description between id 10 to 20:");
        for (TotalIncome result : resultsD) {
            System.out.print("ID: " + result.getId());
            System.out.println("    Description: " + result.getDescription());
        }
        System.out.println();

        // Question E
        CriteriaQuery<Object[]> cqE = cb.createQuery(Object[].class);
        Root<GeographicArea> rootE = cqE.from(GeographicArea.class);
        cqE.multiselect(rootE.get("level"), cb.count(rootE)).groupBy(rootE.get("level"));
        List<Object[]> resultsE = em.createQuery(cqE).getResultList();

        System.out.println("E. Use Group by Clause to Display Geographic Area Information group by Level:");
        for (Object[] result : resultsE) {
            System.out.print("Level: " + result[0]);
            System.out.println("    Count: " + result[1]);
        }
        System.out.println();
    }

}
