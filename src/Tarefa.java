import java.time.LocalDate;

public class Tarefa {
    private String titulo;
    private String descricao;
    private Boolean feito;
    private final LocalDate dataDeCriacao;

    public Tarefa(String titulo) {
        this.titulo = titulo;
        this.descricao = "sem descrição";
        this.feito = false;
        this.dataDeCriacao = LocalDate.now();
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

    public void setFeito() {
        this.feito = true;
    }

    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }

    @Override
    public String toString() {
        return  titulo + "\n" +
                "- descricao: " + descricao + "\n" +
                "- concluido: " + (feito? "Sim" : "Não") + "\n" +
                "criada em " + dataDeCriacao.getDayOfMonth() + "/" + dataDeCriacao.getMonthValue() + "/" + dataDeCriacao.getYear() + "\n";
    }
}
