import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        GerenciadorTarefas g = new GerenciadorTarefas();

        String escolha;

        do{
            escolha = leInfoString(t, "c - cria tarefa/ v - vizualisa tarefas/ s - sair");
            switch (escolha){
                case "c":
                    String titulo = leInfoString(t, "digite o nome da tarefa: ");
                    Tarefa tarefa = g.criarTarefa(titulo);
                    g.adicionarTarefa(tarefa);
                    //cria tarefa e adiciona
                    break;
                case "v":
                    g.exibirTarefas();
                    break;
            }
        }while(!escolha.equalsIgnoreCase("s"));
        t.close();
    }

    public static String leInfoString(Scanner t, String msg){
        System.out.println(msg);
        return t.nextLine().trim();
    }
}