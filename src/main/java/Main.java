
import javax.swing.JOptionPane;

public class Main {

    static int idades[] = new int[100];
    static String nomes[] = new String[100];
    static int n = 0;

    public static void pornomes() {
        String nomepesquisa = JOptionPane.showInputDialog("digite o nome a ser pesquisado");
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (nomes[i].equalsIgnoreCase(nomepesquisa)) {
                System.out.println("achei  aluno com o nome " + nomes[i] + " idade = " + idades[i]);
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Nenhum auno achado com nome: " + nomepesquisa);
        }
    }

    public static void poridades() {
        int idadepesquisa = Integer.parseInt(JOptionPane.showInputDialog("digite a idade a ser pesquisado"));
        boolean flags = false;
        for (int i = 0; i < n; i++) {
            if (idades[i] == idadepesquisa) {
                System.out.println("achei  aluno com essa idade " + idades[i] + " idade = " + nomes[i]);
                flags = true;
            }
        }
        if (flags == false) {
            System.out.println("Nenhum auno achado com idade " + idadepesquisa);
        }
    }

    public static void exclusao() {
        String nomepesquisa = JOptionPane.showInputDialog("digite o nome do aluno a ser pesquisado para ser apagado");
        int posicaoExcluir = -1;
        for (int i = 0; i < n; i++) {
            if ((nomes[i].equalsIgnoreCase(nomepesquisa)) == true) {
                posicaoExcluir = i;
            }
        }
        if (posicaoExcluir != -1) {
            for (int i = posicaoExcluir; i < n - 1; ++i) {
                nomes[i] = nomes[i + 1];
                idades[i] = idades[i + 1];
            }
            n = n - 1;
        } else {
            System.out.println("nenhum aluno encontrado com o nome: " + nomepesquisa);
        }
    }

    public static void alterar() {
        String nomepesquisa = JOptionPane.showInputDialog("digite o nome do aluno a ser pesquisado para ser modificado");
        int posicaoAlterar = -1;
        for (int i = 0; i < n; i++) {
            if ((nomes[i].equalsIgnoreCase(nomepesquisa)) == true) {
                posicaoAlterar = i;
            }
            if (posicaoAlterar != -1) {
                String nome = JOptionPane.showInputDialog("digite um nome de alterar: ");
                int idade = Integer.parseInt(JOptionPane.showInputDialog("digite uma idade de alterar: "));
                nomes[posicaoAlterar] = nome;
                idades[posicaoAlterar] = idade;
                System.out.println("Alteração do alun com sucesso!");
            } else {
                System.out.println("nenhum aluno encontrado com o nome: " + nomepesquisa);
            }
        }
    }

    public static void main(String[] args) {
        int opçao1;
        do {
            Biblioteca.menu();
            opçao1 = Integer.parseInt(JOptionPane.showInputDialog("digite um opção"));
            switch (opçao1) {
                case 1:
                    System.out.println("cadasro de conta");
                    if (n < 100) {
                        Biblioteca.cadastar(n,idades,nomes);
                    } else {
                        System.out.println("cadastro cheio");
                    }
                    break;
                case 2:
                    System.out.println("lista de aluno");
                    Biblioteca.listar(n,nomes,idades);
                    break;
                case 3:
                    System.out.println("consultar aluno");
                    int opçao2;
                    opçao2 = Integer.parseInt(JOptionPane.showInputDialog("digite um opção"));
                    do {
                        Biblioteca.consultar();
                        switch (opçao2) {
                            case 1:
                                System.out.println("consultar por nome");
                                pornomes();
                                break;
                            case 2:
                                System.out.println("consultar por idade");
                                poridades();
                                break;
                            case 3:
                                System.out.println("sair da cnsulta");
                                break;
                            case 4:
                                System.out.println("opção invalida");
                                break;
                        }
                    } while (opçao2 != 3);
                    break;
                case 4: {
                    System.out.println("Excluir aluno");
                    exclusao();
                }
                break;
                case 5: {
                    System.out.println("Alterar Aluno");
                    alterar();
                }
            break;
          case 9:
                    System.out.println("sair do programa");
                    break;
                case 6:
                    System.out.println("opção invalida");
                    break;
            }
    }while (opçao1 != 8);
    }
}