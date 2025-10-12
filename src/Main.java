import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        GerenciadorTarefas g = new GerenciadorTarefas();

        String escolha;
        int valor;

        do{
            escolha = obterOpcaoMenu(t);
            //imprime menu, recebe valor e verifica se é válido
            if (escolha.equals("c")){
                //cria uma nova tarefa
                String titulo = leInfoString(t, "digite o nome da tarefa: ");
                Tarefa tarefa = g.criarTarefa(titulo);
                g.adicionarTarefa(tarefa);
                break;
            } else if (escolha.equals("v")) {
                //imprime na tela as tarefas existentes
                g.exibirTarefas();
                break;
            } else if (escolha.equals("e")) {
                escolha = subMenu(t);
                g.exibirTarefas();
                int subEscolha = 0;
                if (escolha.equals("m")){
                    concluirTarefa(g, t);
                    break;
                } else if (escolha.equals("d")){
                    deletarTarefa(g, t);
                    break;
                } else if (escolha.equals("an")){
                    subEscolha = perguntaValor(t);
                    break;
                } else if (escolha.equals("ad")){
                    subEscolha = perguntaValor(t);
                    break;
                }
                break;
            }
        }while (!escolha.equals("s"));

        t.close();
    }

    public static String leInfoString(Scanner t, String msg){
        System.out.println(msg);
        return t.nextLine().trim();
    }

    public static int perguntaValor(Scanner t){
        return Integer.parseInt(leInfoString(t, "digite o número da tarefa: "));
    }

    public static String obterOpcaoMenu(Scanner t){
        boolean entradaValida = false;
        String entrada = "";

        while(!entradaValida){
            try{
                entrada = leInfoString(t, "c - cria tarefa/ v - vizualisa tarefas/ e - editar tarefa/ s - sair").toLowerCase();
                if (entrada.equals("c") || entrada.equals("v") || entrada.equals("s") || entrada.equals("e")){
                    entradaValida = true;
                } else {
                    throw new Exception("Entrada inválida");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida, digite novamente");
            }
        }
        return entrada;
    }

    public static String subMenu(Scanner t){
        boolean entradaValida = false;
        String entrada = "";

        while(!entradaValida){
            try{
                entrada = leInfoString(t, "m - marcar tarefa como concluída/ d - deleta tarefa/ an - altera nome da tarefa/ ad - altera descrição da tarefa").toLowerCase();
                if (entrada.equals("m") || entrada.equals("d") || entrada.equals("an") || entrada.equals("ad")){
                    entradaValida = true;
                } else {
                    throw new Exception("Entrada inválida");
                }
            } catch (Exception e){
                System.out.println("Entrada inválida, digite novamente");
            }
        }
        return entrada;
    }

    public static void concluirTarefa(GerenciadorTarefas g, Scanner t){
        //criar exceção
        int valor = perguntaValor(t);
        g.marcarComoFeito(valor);
    }

    public static void deletarTarefa(GerenciadorTarefas g, Scanner t){
        //criar exceção
        int valor = perguntaValor(t);
        String pergunta = leInfoString(t, "deseja mesmo apagar essa tarefa? s/n").toLowerCase();
        try{
            if (pergunta.equals("s")) {
                g.deletarTarefa(valor);
            } else if (pergunta.equals("n")) {
                System.out.println("operação cancelada");
            } else {
                throw new Exception("entrada inválida");
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida, digite novamente");
        }
    }

    public static void alterarTitulo(GerenciadorTarefas g, Scanner t){

    }

    public static void alterarDescricao(GerenciadorTarefas g, Scanner t){

    }
}