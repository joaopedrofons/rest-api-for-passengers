package site.de.passagens.REST.API.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

import java.time.Duration;

@Entity
public class Stopover {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight; // Referência ao voo ao qual esta escala pertence

    @NotEmpty
    private String airport; // O aeroporto onde ocorre a escala

    private Duration duration; // A duração da escala

    public Stopover() {
    }

    public Stopover(Flight flight, String airport, Duration duration) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null");
        }
        this.flight = flight;
        this.airport = airport;
        setDuration(duration);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null");
        }
		this.flight = flight;
	}

	public String getAirport() {
		return airport;
	}

	public void setAirport(String airport) {
		this.airport = airport;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
	    if (duration == null || duration.isNegative()) {
	        throw new IllegalArgumentException("Duration must be positive");
	    }
	    this.duration = duration;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Stopover)) return false;
	    Stopover stopover = (Stopover) o;
	    return getId().equals(stopover.getId());
	}
	
	@Override
	public int hashCode() {
	    return getId().hashCode();
	}
}
