package site.de.passagens.restapi.NotFoundException;


public class TicketNotFoundException extends RuntimeException {

    public TicketNotFoundException(String message) {
        super(message);
    }
}
