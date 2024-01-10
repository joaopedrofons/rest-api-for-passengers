package site.de.passagens.REST.API.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String passportNumber;
    private String cpf;
    private String rg;

    public Ticket() {
        if (isCpfValid(cpf) && isRgValid(rg)) {
            this.name = name;
            this.passportNumber = passportNumber;
            this.cpf = cpf;
            this.rg = rg;
        } else {
            throw new IllegalArgumentException("CPF ou RG inválido");
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (isCpfValid(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        if (isRgValid(rg)) {
            this.rg = rg;
        } else {
            throw new IllegalArgumentException("RG inválido");
        }
    }

    public boolean isCpfValid(String cpf) {
        // Implemente a lógica de validação do CPF aqui
        return cpf != null && cpf.length() == 11 && cpf.chars().allMatch(Character::isDigit);
    }

    public boolean isRgValid(String rg) {
        // Implemente a lógica de validação do RG aqui
        return rg != null && rg.length() >= 5 && rg.length() <= 14 && rg.chars().allMatch(Character::isLetterOrDigit);
    }

	public void setId(long l) {
		// TODO Auto-generated method stub
		
	}
}
