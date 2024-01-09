package site.de.passagens.REST.API.servicetest;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;

    @Test
    public void testCreateFlight() {
        // Cria um voo com propriedades específicas
        Flight flight = new Flight("FL123", new Airline());
        // set flight properties...
        when(flightRepository.save(any(Flight.class))).thenReturn(flight);

        Flight createdFlight = flightService.createFlight(flight);

        assertNotNull(createdFlight);
        assertEquals(flight.getFlightNumber(), createdFlight.getFlightNumber());
        // assert other properties...
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        // Cria um voo com propriedades específicas
        Flight flight = new Flight("FL123", new Airline());
        // set flight properties...
        when(flightRepository.findById(id)).thenReturn(java.util.Optional.of(flight));

        Flight foundFlight = flightService.findById(id);

        assertNotNull(foundFlight);
        assertEquals(flight.getFlightNumber(), foundFlight.getFlightNumber());
        // assert other properties...
    }
}