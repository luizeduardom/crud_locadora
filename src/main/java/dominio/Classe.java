package dominio;


import javax.persistence.*;

@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nomeClasse", nullable = false)
    private String nome;
    @Column(name = "valor", nullable = false)
    private float valor;
    @Column(name = "prazoDevolucao", nullable = false)
    private int prazoDevolucao;


    public Classe() {
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public int getPrazoDevolucao() {
        return prazoDevolucao;
    }
    public void setPrazoDevolucao(int prazoDevolucao) {
        this.prazoDevolucao = prazoDevolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
