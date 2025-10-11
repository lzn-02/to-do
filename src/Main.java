import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        GerenciadorTarefas g = new GerenciadorTarefas();

        String escolha;
        int valor;

        do{
            escolha = leInfoString(t, "c - cria tarefa/ v - vizualisa tarefas/ m - marcar como feito/ e - editar tarefa/ d - deletar tarefa/ s - sair").toLowerCase();
            //conferir se o valor informado é um dos solicitados
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
                case "m": //tranformar em um menu de informações/edição junto com deletar e editar, adicionar um "adicionar descrição"
                    g.exibirTarefas();
                    valor = perguntaValor(t);
                    //erro de outOfBounds
                    g.marcarComoFeito(valor);
                    break;
                case "e":
                    g.exibirTarefas();
                    valor = perguntaValor(t);
                    String novoTitulo = leInfoString(t, "Digite o novo nome da tarefa");
                    //erro de outOfBounds
                    g.editarTarefa(valor, novoTitulo);
                    System.out.println("título redefinido");
                    break;
                case "d":
                    g.exibirTarefas();
                    valor = perguntaValor(t);
                    String pergunta = leInfoString(t, "deseja mesmo deletar essa tarefa? s/n").toLowerCase();
                    if (pergunta.equals("s")){
                        g.deletarTarefa(valor);
                        System.out.println("tarefa deletada");
                        break;
                    }
                    System.out.println("operação cancelada");
                    break;

                }
                //limpar???
        }while(!escolha.equalsIgnoreCase("s"));
        t.close();
    }

    public static String leInfoString(Scanner t, String msg){
        System.out.println(msg);
        return t.nextLine().trim();
    }

    public static int perguntaValor(Scanner t){
        return Integer.parseInt(leInfoString(t, "digite o número da tarefa: "));
    }
}