import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        GerenciadorTarefas g = new GerenciadorTarefas();

        String escolha;


        do{
            escolha = obterOpcaoMenu(t);
            //imprime menu, recebe valor e verifica se é válido
            if (escolha.equals("c")){
                //cria uma nova tarefa
                String titulo = leInfoString(t, "digite o nome da tarefa: ");
                Tarefa tarefa = g.criarTarefa(titulo);
                g.adicionarTarefa(tarefa);

            } else if (escolha.equals("v")) {
                //imprime na tela as tarefas existentes
                exibirTarefas(g);

            } else if (escolha.equals("e")) {
                //menu de edição
                //criar subEscolha, enquanto subEscolha for diferente de "s" o usuário permanecerá no menu de edição
                escolha = subMenu(t);
                g.exibirTarefasSimples();
                if (escolha.equals("m")){
                    //marca tarefa como feita/conluida
                    concluirTarefa(g, t);

                } else if (escolha.equals("d")){
                    //deleta tarefa existente
                    deletarTarefa(g, t);

                } else if (escolha.equals("an")){
                    //altera título da tarefa escolhida
                    alterarTitulo(g, t);

                } else if (escolha.equals("ad")){
                    //altera descrição da tarefa escolhida
                    alterarDescricao(g, t);

                }

            }
        } while (!escolha.equals("s"));
        t.close();
    }

    public static String leInfoString(Scanner t, String msg){
        System.out.println(msg);
        return t.nextLine().trim();
    }

    public static int perguntaValor(Scanner t){
        return Integer.parseInt(leInfoString(t, "digite o número da tarefa: "));
    }

    public static void verificaValor(int valor, GerenciadorTarefas g, Scanner t){
        while(valor>g.getTarefas().size() || valor<g.getTarefas().size()){
            System.out.println("Item inexistente. Por favor, insira um valor que esteja dentro da lista");
            valor = perguntaValor(t);
        }

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
                entrada = leInfoString(t, "m - marcar tarefa como concluída/ d - deleta tarefa/ an - altera nome da tarefa/ ad - altera descrição da tarefa/ v - voltar").toLowerCase();
                if (entrada.equals("m") || entrada.equals("d") || entrada.equals("an") || entrada.equals("ad") || entrada.equals("s")){
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

    public static void exibirTarefas(GerenciadorTarefas g){
        //alterar método toString(), adicionar operador ternário nele que indica se a tarefa está feita ou pendente (feito)
        if (g.getTarefas().isEmpty()){
            System.out.println("Sua lista de tarefas está vazia.");
        } else {
            g.exibirTarefasCompleto();
        }
    }

    public static void concluirTarefa(GerenciadorTarefas g, Scanner t){
        //criar exceção
        boolean valorValido = false;
        while(!valorValido){
            try {
                int valor = perguntaValor(t);
                g.marcarComoFeito(valor);
                valorValido = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Valor inválido, digite novamente");
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido, digite novamente");
            }
        }

    }

    public static void deletarTarefa(GerenciadorTarefas g, Scanner t){
        //criar exceção
        int valor = perguntaValor(t);
        String pergunta = leInfoString(t, "deseja mesmo apagar essa tarefa? s/n").toLowerCase();
        //loop para verificar se valor é 's' ou 'n' com exceção
        try{
            if (pergunta.equals("s")) {
                //try-catch aqui
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
        //verificar se indice informado existe no array antes de prosseguir (conferir comparando o valor com o tamanho do array?)
        boolean valorValido = false;


        int valor = perguntaValor(t);
        String novoTitulo = leInfoString(t, "Digite o novo título da tarefa");
        g.editarTituloTarefa(valor, novoTitulo);
    }

    public static void alterarDescricao(GerenciadorTarefas g, Scanner t){
        boolean valorValido = false;
        //verificar se indice informado existe no array antes de prosseguir (conferir comparando o valor com o tamanho do array?)
        while(!valorValido) {
            int valor = perguntaValor(t);
            validadorDeIndex(valor, g);
            String novaDescicao = leInfoString(t, "Digite a descição");
            g.editarDescricaoTarefa(valor, novaDescicao);
        }
    }

     public static boolean validadorDeIndex(int valor, GerenciadorTarefas g){
        try{
            g.getTarefas().get(valor-1);
            return true;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Item não encontrado");
        } catch (NumberFormatException e){
            System.out.println("Valor inválido");
        }
        return false;
     }

}