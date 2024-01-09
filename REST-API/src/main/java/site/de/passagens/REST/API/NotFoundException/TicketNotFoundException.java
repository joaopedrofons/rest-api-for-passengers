package site.de.passagens.REST.API.NotFoundException;


public class TicketNotFoundException extends RuntimeException {

    public TicketNotFoundException(String message) {
        super(message);
    }
}
