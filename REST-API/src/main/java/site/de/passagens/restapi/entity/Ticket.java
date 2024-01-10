package site.de.passagens.restapi.entity;

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
        // Construtor sem validação
    }

    // ... getters e setters para as outras propriedades

    public void setCpf(String cpf) {
        if (isCpfValid(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public void setRg(String rg) {
        if (isRgValid(rg)) {
            this.rg = rg;
        } else {
            throw new IllegalArgumentException("RG inválido");
        }
    }

    public boolean isCpfValid(String cpf) {
        // Implementação básica de validação do CPF
        if (cpf == null || !cpf.replaceAll("\\D", "").matches("\\d{11}")) {
            return false;
        }
        // Adicione mais lógica de validação conforme necessário
        return true;
    }

    public boolean isRgValid(String rg) {
        // Implementação básica de validação do RG
        if (rg == null || !rg.replaceAll("\\D", "").matches("\\d{9}")) {
            return false;
        }
        // Adicione mais lógica de validação conforme necessário
        return true;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return this.passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getRg() {
        return this.rg;
    }
}
