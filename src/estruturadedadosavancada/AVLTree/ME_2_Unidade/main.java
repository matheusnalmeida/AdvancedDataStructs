/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.AVLTree.ME_2_Unidade;

import estruturadedadosavancada.AVLTree.AVLNode;
import estruturadedadosavancada.AVLTree.AVLTree;
import estruturadedadosavancada.EmptyTreeException;
import estruturadedadosavancada.InvalidNodeException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Matheus Nunes
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AVLTree<Integer, Integer> arvore = new AVLTree<>();
        Scanner scan = new Scanner(System.in);
        boolean running = true;
        int opcao;
        while (running) {
            menu();
            try {
                opcao = scan.nextInt();
                switch (opcao) {
                    case 0:
                        System.out.println("Programa Finalizado");
                        running = false;
                        break;
                    case 1:
                        int chaveNovoNo;
                        int valorNovoNo;
                        System.out.println("Digite a chave do novo no a ser inserido");
                        chaveNovoNo = scan.nextInt();
                        System.out.println("Digite o valor do novo no a ser inserido");
                        valorNovoNo = scan.nextInt();
                        try {
                            arvore.insert(new AVLNode<>(chaveNovoNo, valorNovoNo));
                            System.out.println("No inserido com sucesso");
                        } catch (InvalidNodeException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case 2:
                        int chaveNoRemover;
                        System.out.println("Digite a chave do no a ser removido: ");
                        chaveNoRemover = scan.nextInt();
                        if (arvore.remove(chaveNoRemover)) {
                            System.out.println("No removido com sucesso");
                        } else {
                            System.out.println("Nao existe no com cahve informada na arvore");
                        }
                        break;
                    case 3:
                        int chaveNoBuscar;
                        System.out.println("Digite a chave do no a ser buscado na arvore");
                        chaveNoBuscar = scan.nextInt();
                        try {
                            AVLNode noEncontrado = arvore.find_recursivo(chaveNoBuscar);
                            if (noEncontrado == null) {
                                System.out.println("Nao existe no na arvore com o valor de chave informado");
                            } else {
                                System.out.println("Foi encontrado o no de chave " + noEncontrado.getChave()
                                        + " e valor " + noEncontrado.getValor());
                            }
                        } catch (EmptyTreeException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case 4:
                        arvore.limparArvore();
                        break;
                    case 5:
                        System.out.println("-----------------------------------------------------------");
                        arvore.print2D();
                        System.out.println("-----------------------------------------------------------");
                        break;

                    default:
                        System.out.println("Opção invalida!");
                        break;
                }
            } catch (InputMismatchException ex) {
                scan.next();
                System.out.println("Digite um valor numerico e que esteja contido em uma das opções do menu");
            }
        }
    }

    public static void menu() {
        System.out.println("0 - Finalizar Programa");
        System.out.println("1 - Inserir um no");
        System.out.println("2 - Remover um no");
        System.out.println("3 - Pesquisar um no");
        System.out.println("4 - Limpar a arvore");
        System.out.println("5 - Printar a arvore");
        System.out.println("Escolha uma opção do menu: ");
    }

}
