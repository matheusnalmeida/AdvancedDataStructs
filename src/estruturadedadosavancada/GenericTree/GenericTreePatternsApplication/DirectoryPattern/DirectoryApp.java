/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.GenericTree.GenericTreePatternsApplication.DirectoryPattern;

import estruturadedadosavancada.GenericTree.GenericNode;
import estruturadedadosavancada.InvalidNodeException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Matheus Nunes
 */
public class DirectoryApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome do diretorio raiz: ");
        String nome = scan.next();
        GenericNode<String,List<Arquivo>> no_raiz = new GenericNode<>(nome);
        try {
            GerenciadorDeArquivos explorer = new GerenciadorDeArquivos(no_raiz);
            System.out.println("--------------------------- Cadastrando pastas first_directory e second_directory no diretorio raiz ----------------------------------");
            System.out.println(explorer.cadastrarPasta(new GenericNode<>(nome),"first_directory"));
            System.out.println(explorer.cadastrarPasta(new GenericNode<>(nome),"second_directory"));
            System.out.println("--------------------------- Cadastrando arquivos nos diretorios first_directory e second_directory -----------------------");
            Arquivo arquivo = new Arquivo("imagem.jpg", 1000);
            Arquivo arquivo1 = new Arquivo("artigo.txt",500);
            System.out.println(explorer.cadastrarArquivo(arquivo, new GenericNode<>("first_directory")));
            System.out.println(explorer.cadastrarArquivo(arquivo1, new GenericNode<>("second_directory")));
            System.out.println("---------------------------- Verificando total de espaco ocupado pelo root -------------------------------------------");
            System.out.println(explorer.calculaEspacoTotal(new GenericNode<>(nome)));
            System.out.println("---------------------------------Verificando os arquivos e o espaço ocupado por cada diretorio------------------------");
            System.out.println(explorer.listarTodosDiretorios());
        } catch (InvalidNodeException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
