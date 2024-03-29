package model;

import jakarta.persistence.*;

@Entity
@Table(name = "censusyear")
public class CensusYear {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "censusYearID", nullable = false)
    private int censusYearID;
    @Basic
    @Column(name = "censusYear", nullable = false)
    private int censusYear;

    public int getCensusYearID() {
        return censusYearID;
    }

    public void setCensusYearID(int censusYearID) {
        this.censusYearID = censusYearID;
    }

    public int getCensusYear() {
        return censusYear;
    }

    public void setCensusYear(int censusYear) {
        this.censusYear = censusYear;
    }

    @Override
    public String toString() {
        return "CensusYearEntity{" +
                "censusYearID=" + censusYearID +
                ", censusYear=" + censusYear +
                '}';
    }
}
