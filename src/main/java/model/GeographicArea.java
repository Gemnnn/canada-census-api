package model;
import jakarta.persistence.*;

@Entity
@Table(name = "geographicarea")
public class GeographicArea {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "geographicAreaID", nullable = false)
    private int geographicAreaID;

    @Basic
    @Column(name = "code", nullable = false)
    private int code;

    @Basic
    @Column(name = "level", nullable = false)
    private int level;

    @Basic
    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Basic
    @Column(name = "alternativeCode", nullable = false)
    private int alternativeCode;

    // Constructor
    public GeographicArea() {

    }

    public GeographicArea(int code, int level, String name) {
        this.code = code;
        this.level = level;
        this.name = name;
    }

    public GeographicArea(int code, int level, String name, int alternativeCode) {
        this.code = code;
        this.level = level;
        this.name = name;
        this.alternativeCode = alternativeCode;
    }

    public int getGeographicAreaID() {
        return geographicAreaID;
    }

    public void setGeographicAreaID(int geographicAreaID) {
        this.geographicAreaID = geographicAreaID;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlternativeCode() {
        return alternativeCode;
    }

    public void setAlternativeCode(int alternativeCode) {
        this.alternativeCode = alternativeCode;
    }

    @Override
    public String toString() {
        return "GeographicArea{" +
                "geographicAreaID=" + geographicAreaID +
                ", code=" + code +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", alternativeCode=" + alternativeCode +
                '}';
    }
}