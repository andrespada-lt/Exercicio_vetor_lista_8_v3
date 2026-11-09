
import javax.swing.JOptionPane;

public class Biblioteca {
    
    private Main delegate;

    public Biblioteca(Main delegate) {
        this.delegate = delegate;
    }

    public Biblioteca() {
        this.delegate = new Main();
    }
    public static void menu() {
        System.out.println("sistema da escola");
        System.out.println("1- cadastro de aluno");
        System.out.println("2- lista de aluno");
        System.out.println("3- consultar aluno");
        System.out.println("4- Apagar alunos");
        System.out.println("5- Alterar alunos");
        System.out.println("9-sair");
    }

    public static void cadastar(int n, int idades[],String nomes[]) {
        String nome = JOptionPane.showInputDialog("digite um nome: ");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("digite uma idade: "));
        nomes[n] = nome;
        idades[n] = idade;
        n = n + 1;
    }

        public static void listar(int n,
        String nomes[],
        int idades[]) {
        for (int i = 0; i < n; i++) {
            System.out.println("nome: " + nomes[i] + " idade: " + idades[i]);
        }
    }

    public static void consultar() {
        System.out.println("1- Por nome");
        System.out.println("2- Por idade");
        System.out.println("3- Sair da consulta");
    }
    public static void pornomes() {
        Main.pornomes();
    }

    public static void poridades() {
        Main.poridades();
    }

    public static void exclusao() {
        Main.exclusao();
    }

    public static void alterar() {
        Main.alterar();
    }

    public static void main(String[] args) {
        Main.main(args);
    }

    public boolean equals(Object o) {
        Object target = o;
        if (o instanceof Biblioteca) {
            target = ((Biblioteca) o).delegate;
        }
        return this.delegate.equals(target);
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }
    
}
