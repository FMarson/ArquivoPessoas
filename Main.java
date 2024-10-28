import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Pessoa[] pessoas = new Pessoa[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Nome: ");
            String nome = teclado.nextLine();
            System.out.print("CPF: ");  
            String cpf = teclado.nextLine();
            System.out.print("Endereço: ");
            String endereco = teclado.nextLine();
            System.out.print("Idade: ");
            int idade = teclado.nextInt();
            teclado.nextLine();
            System.out.println();
            pessoas[i] = new Pessoa(nome, idade, cpf, endereco);
        }
    }
}