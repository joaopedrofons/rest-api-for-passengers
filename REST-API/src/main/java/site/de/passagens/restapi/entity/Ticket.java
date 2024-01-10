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
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            return false;
        }
        // Adicione mais lógica de validação conforme necessário
        return true;
    }

    public boolean isRgValid(String rg) {
        // Implementação básica de validação do RG
        if (rg == null || !rg.matches("\\d{2}\\.\\d{3}\\.\\d{3}-\\d{1}")) {
            return false;
        }
        // Adicione mais lógica de validação conforme necessário
        return true;
    }
}
