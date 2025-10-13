//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    //private Gson gson;
    private List<Tarefa> tarefas;
    //private static final String N_ARQUIVO = "tarefas.json";


    public GerenciadorTarefas(){
        this.tarefas = new ArrayList<Tarefa>();
        //this.gson = new Gson( );
    }

    public Tarefa criarTarefa(String titulo){
        return new Tarefa(titulo);
    }

    public void adicionarTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }

    public void exibirTarefasSimples(){
        for (Tarefa tarefa : tarefas){
            System.out.println( tarefas.indexOf(tarefa)+1+". "+ tarefa.getTitulo() + " - " + (tarefa.getFeito() ? "feita" : "pendente"));
        }
    }

    public void exibirTarefasCompleto(){
        for(Tarefa tarefa : tarefas){
            System.out.println(tarefas.indexOf(tarefa)+1+". "+tarefa.toString());
        }
    }

    public void marcarComoFeito(int valor){
        tarefas.get(valor-1).setFeito();
    }

    public void editarTituloTarefa(int valor, String novoTitulo){
        tarefas.get(valor-1).setTitulo(novoTitulo);
    }

    public void editarDescricaoTarefa(int valor, String novaDescricao){ tarefas.get(valor-1).setDescricao(novaDescricao);}

    public void deletarTarefa(int valor){tarefas.remove(valor-1); }

    public void maisInfo(int valor){
        tarefas.get(valor-1).toString();
    }

}
