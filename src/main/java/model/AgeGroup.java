package model;

import jakarta.persistence.*;
@Entity
@Table(name = "agegroup")
public class AgeGroup {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ageGroupID", nullable = false)
    private int ageGroupId;

    @Basic
    @Column(name = "description", nullable = false, length = 40)
    private String description;

    @Override
    public String toString() {
        return "AgeGroupEntity{" +
                "ageGroupId=" + ageGroupId +
                ", description='" + description + '\'' +
                '}';
    }

    public int getAgeGroupId() {
        return ageGroupId;
    }

    public void setAgeGroupId(int ageGroupId) {
        this.ageGroupId = ageGroupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}