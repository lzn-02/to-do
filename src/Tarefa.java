import java.util.Scanner;

public class Tarefa {
    private String titulo;
    private String descricao;
    private Boolean feito;

    public Tarefa(String titulo) {
        this.titulo = titulo;
        this.descricao = "sem descrição";
        this.feito = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getFeito() {
        return feito;
    }

    public void setFeito(Boolean feito) {
        this.feito = true;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
