package model;

import jakarta.persistence.*;

@Entity
@Table(name = "household")
public class HouseHold {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "geographicArea", nullable = false)
    private int geographicArea;

    @Basic
    @Column(name = "householdType", nullable = false)
    private int householdType;

    @Basic
    @Column(name = "householdSize", nullable = false)
    private int householdSize;

    @Basic
    @Column(name = "householdsByAgeRange", nullable = false)
    private int householdsByAgeRange;

    @Basic
    @Column(name = "householdEarners", nullable = false)
    private int householdEarners;

    @Basic
    @Column(name = "totalIncome", nullable = false)
    private int totalIncome;

    @Basic
    @Column(name = "censusYear", nullable = false)
    private int censusYear;

    @Basic
    @Column(name = "numberReported", nullable = false)
    private int numberReported;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeographicArea() {
        return geographicArea;
    }

    public void setGeographicArea(int geographicArea) {
        this.geographicArea = geographicArea;
    }

    public int getHouseholdType() {
        return householdType;
    }

    public void setHouseholdType(int householdType) {
        this.householdType = householdType;
    }

    public int getHouseholdSize() {
        return householdSize;
    }

    public void setHouseholdSize(int householdSize) {
        this.householdSize = householdSize;
    }

    public int getHouseholdsByAgeRange() {
        return householdsByAgeRange;
    }

    public void setHouseholdsByAgeRange(int householdsByAgeRange) {
        this.householdsByAgeRange = householdsByAgeRange;
    }

    public int getHouseholdEarners() {
        return householdEarners;
    }

    public void setHouseholdEarners(int householdEarners) {
        this.householdEarners = householdEarners;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    public int getCensusYear() {
        return censusYear;
    }

    public void setCensusYear(int censusYear) {
        this.censusYear = censusYear;
    }

    public int getNumberReported() {
        return numberReported;
    }

    public void setNumberReported(int numberReported) {
        this.numberReported = numberReported;
    }

    @Override
    public String toString() {
        return "HouseHoldEntity{" +
                "id=" + id +
                ", geographicArea=" + geographicArea +
                ", householdType=" + householdType +
                ", householdSize=" + householdSize +
                ", householdsByAgeRange=" + householdsByAgeRange +
                ", householdEarners=" + householdEarners +
                ", totalIncome=" + totalIncome +
                ", censusYear=" + censusYear +
                ", numberReported=" + numberReported +
                '}';
    }
}