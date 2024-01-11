package site.de.passagens.restapi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Airplane> airplanes = new ArrayList<>();

    public Airline() {
    }

    public Airline(String name) {
        this.name = name;
    }

    public void addAirplane(Airplane airplane) {
        this.airplanes.add(airplane);
        airplane.setAirline(this);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Airplane> getAirplanes() {
        return new ArrayList<>(this.airplanes);
    }

    public void setAirplanes(List<Airplane> airplanes) {
        this.airplanes.clear();
        if (airplanes != null) {
            this.airplanes.addAll(airplanes);
        }
    }

    public Optional<Airline> orElse(Object object) {
        return object instanceof Airline ? Optional.of((Airline) object) : Optional.empty();
    }
}
