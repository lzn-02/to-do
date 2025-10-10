import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    private List<Tarefa> tarefas;
    private static final String N_ARQUIVO = "tarefas.json";
    private Gson gson;

    public GerenciadorTarefas(){
        this.tarefas = carregarTarefas();
        this.gson = new Gson();
    }

    public Tarefa criarTarefa(String titulo){
        return new Tarefa(titulo);
    }

    public void adicionarTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
        //salvarTarefas();
    }

    public void exibirTarefas(){

        for (Tarefa tarefa : tarefas){
            System.out.println( tarefas.indexOf(tarefa)+1+". "+ tarefa.getTitulo() + " - " + (tarefa.getFeito() ? "feita" : "pendente"));
        }
    }

    private void salvarTarefas(){
        try {
            Writer escritor = new FileWriter(N_ARQUIVO);
            //cria um file writer para escrever no aquivo JSON
            gson.toJson(tarefas, escritor);
            //recebe tarefas e com o file writer escreve as informações no JSON
        }catch(IOException e){
                System.out.println("Erro ao salvar a tarefa. "+ e.getMessage());
        }
    }

    private List<Tarefa> carregarTarefas(){
        try{
            Reader leitor = new FileReader(N_ARQUIVO);
            Type listType = new TypeToken<ArrayList<Tarefa>>(){}.getType();

            List<Tarefa> tarefasCarregadas = gson.fromJson(leitor, listType);

            return tarefasCarregadas != null ? tarefasCarregadas : new ArrayList<>();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Uma nova lista será criada.");
            return new ArrayList<>();
        }
    }



}
