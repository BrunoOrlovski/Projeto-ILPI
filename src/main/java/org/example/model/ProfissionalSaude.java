package org.example.model;

import jakarta.persistence.*;

// A anotação @Entity indica que esta classe será uma entidade JPA, mapeada para uma tabela no banco de dados.
@Entity
@Table(name = "profissionais_saude")  // A tabela no banco de dados será chamada "profissionais_saude".
public class ProfissionalSaude {


    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Atributo 'id' que é gerado automaticamente e serve como chave primária.

    private String nome;
    private String registro;
    private String especialidade;
    private String contato;


    public ProfissionalSaude() {
    }

    public ProfissionalSaude(String nome,String registro, String especialidade, String contato) {
        this.nome = nome;
        this.registro = registro;
        this.especialidade = especialidade;
        this.contato = contato;
    }

    // Métodos getter e setter para acessar e modificar os valores dos atributos.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    // Sobrescreve o método 'toString' para uma representação legível do objeto.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProfissionalSaude{")
                .append("id=").append(id)  // Exibe o id do profissional.
                .append(", nome='").append(nome).append('\'')  // Exibe o nome do profissional.
                .append(", registro='").append(registro).append('\'')  // Exibe o número de registro.
                .append(", especialidade='").append(especialidade).append('\'')  // Exibe a especialidade do profissional.
                .append(", contato='").append(contato).append('\'')  // Exibe o contato do profissional.
                .append('}');
        return sb.toString();  // Retorna a representação em String do objeto.
    }
}