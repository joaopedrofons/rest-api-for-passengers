package site.de.passagens.REST.API.service;

@Service
public class TicketService {

    @Autowired
    private TicketRpository ticketRpository;

    public List<Ticket> getAllTickets() {
        return ticketRpository.findAll();
    }

    public Ticket getTicket(Long id) {
        return ticketRpository.findById(id).orElse(null);
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRpository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket ticketDetails) {
        Ticket ticket = getTicket(id);
        if(ticket != null) {
            ticket.setName(ticketDetails.getName());
            ticket.setPassportNumber(ticketDetails.getPassportNumber());
            ticket.setCpf(ticketDetails.getCpf());
            ticket.setRg(ticketDetails.getRg());
            return ticketRpository.save(ticket);
        }
        return null;
    }

    public void deleteTicket(Long id) {
        Ticket ticket = getTicket(id);
        if(ticket != null) {
            ticketRpository.delete(ticket);
        }
    }
}