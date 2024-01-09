package site.de.passagens.REST.API.repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
   
    List<Passenger> findByName(String name);

    
    List<Passenger> findByPassportNumber(String passportNumber);

    
    List<Passenger> findByCpf(String cpf);

   
    List<Passenger> findByRg(String rg);
}