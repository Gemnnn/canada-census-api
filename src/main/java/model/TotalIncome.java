package model;

import jakarta.persistence.*;

@Entity
@Table(name = "totalincome")
public class TotalIncome {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "description", length = 40, nullable = false)
    private String description;

    @Override
    public String toString() {
        return "TotalIncome{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}