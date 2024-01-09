package site.de.passagens.REST.API.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String passportNumber;
    private String cpf;
    private String rg;

    @ManyToOne
    @JoinColumn(name="flight_id", nullable=true)
    private Flight flight; // O voo no qual o passageiro está

    private String flightTime;

    private LocalDate birthDate;

    public Passenger() {
    }

    public Passenger(String name, String cpf, String passportNumber, String flightTime, LocalDate birthDate) {
        this.name = name;
        this.cpf = cpf;
        this.passportNumber = passportNumber;
        this.flightTime = flightTime;
        this.birthDate = birthDate;
    }

    public Passenger(String name, String passportNumber, String cpf, String rg, Flight flight, LocalDate birthDate) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.cpf = cpf;
        this.rg = rg;
        this.flight = flight; // Definindo o voo do passageiro
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public boolean isRgValid(String rg) {
        return rg.matches("[0-9]{7}[A-Z]");
    }

    public boolean isCpfValid(String cpf) {
        return cpf.matches("[0-9]{11}");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Passenger passenger = (Passenger) obj;
        return Objects.equals(id, passenger.id) &&
               Objects.equals(name, passenger.name) &&
               Objects.equals(passportNumber, passenger.passportNumber) &&
               Objects.equals(cpf, passenger.cpf) &&
               Objects.equals(rg, passenger.rg) &&
               Objects.equals(flight, passenger.flight) &&
               Objects.equals(flightTime, passenger.flightTime) &&
               Objects.equals(birthDate, passenger.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, passportNumber, cpf, rg, flight, flightTime, birthDate);
    }
}
