import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void salvarArquivo(String nomeArquivo, Pessoa[] pessoas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(pessoas.length + "\n");
            for(Pessoa pessoa : pessoas) {
                writer.write(pessoa.toString());
            }  
            System.out.println("Dados escritos com sucesso no arquivo " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static Pessoa[] carregarArquivo(String nomeArquivo) {
        Pessoa[] pessoas;
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            int nPessoas = Integer.parseInt(reader.readLine());
            pessoas = new Pessoa[nPessoas];
            for (int i = 0; i < nPessoas; i++) {
                String nome = reader.readLine();
                String cpf = reader.readLine();
                String endereco = reader.readLine();
                int idade = Integer.parseInt(reader.readLine());
                pessoas[i] = new Pessoa(nome, idade, cpf, endereco);
            }
            return pessoas;
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Pessoa[] pessoas;
        /*
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

        salvarArquivo("pessoas.txt", pessoas);
        */
        String nomeArquivo;
        System.out.print("Digite o nome do arquivo: ");
        nomeArquivo = teclado.nextLine();
        pessoas = carregarArquivo(nomeArquivo);

        if(pessoas != null) {
            System.out.println("Dados lidos com sucesso do arquivo " + nomeArquivo);
            for(Pessoa pessoa : pessoas) {
                System.out.println(pessoa);
            }
        }

    }
}