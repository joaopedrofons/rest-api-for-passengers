package site.de.passagens.restapi.entity;


import java.time.Duration;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String flightNumber;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;
    
    @Column
    private String origin;
    
    @Column
    private String destination;

    @Column
    private Duration duration;

    @Enumerated(EnumType.STRING)
    private FlightClass flightClass;

    @OneToMany(mappedBy = "flight")
    private List<Passenger> passengers;

    @Column
    private String arrivalTime;

    @Column
    private String departureTime;

    @Column
    private String airplaneModel;

    // Construtor público sem argumentos para JPA
    public Flight() {}

    // Construtores públicos para criação de objetos Flight
    public Flight(String flightNumber, Airline airline) {
        if (airline == null) {
            throw new IllegalArgumentException("Airline cannot be null");
        }
        this.flightNumber = flightNumber;
        this.airline = airline;
    }

    public Flight(String flightNumber, Airline airline, String origin, String destination, Duration duration, FlightClass flightClass) {
        this(flightNumber, airline);  // Reutilizando o construtor acima
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
        this.flightClass = flightClass; 
    }

    public Flight(String flightNumber, Airline airline, String origin, String destination, Duration duration) {
        this(flightNumber, airline, origin, destination, duration, null);  // Reutilizando o construtor acima
    }

    public Flight(Airline airline, String airplaneModel, String origin, String destination, String departureTime, String arrivalTime) {
        if (airline == null) {
            throw new IllegalArgumentException("Airline cannot be null");
        }
        this.airline = airline;
        this.airplaneModel = airplaneModel;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    // Getters e setters...

    public void setAirline(Airline airline) {
        if (airline == null) {
            throw new IllegalArgumentException("Airline cannot be null");
        }
        this.airline = airline;
    }

    public Airline getAirline() {
        return this.airline;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Duration getDuration() {
        return this.duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public FlightClass getFlightClass() {
        return this.flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    public List<Passenger> getPassengers() {
        return this.passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getAirplaneModel() {
        return this.airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {
        this.airplaneModel = airplaneModel;
    }

	public Object getDeparture() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getArrival() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDeparture(Object departure) {
		// TODO Auto-generated method stub
		
	}

	public void setArrival(Object arrival) {
		// TODO Auto-generated method stub
		
	}

	public void setModel(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setMaxCapacity(int i) {
		// TODO Auto-generated method stub
		
	}

	public Short getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public Short getMaxCapacity() {
		// TODO Auto-generated method stub
		return null;
	}
}
