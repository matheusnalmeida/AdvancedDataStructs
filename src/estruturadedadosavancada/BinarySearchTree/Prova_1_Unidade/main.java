/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.Prova_1_Unidade;

import estruturadedadosavancada.BinarySearchTree.BinaryNodeSearchTree;
import estruturadedadosavancada.BinarySearchTree.BinarySearchTree;
import estruturadedadosavancada.EmptyTreeException;
import estruturadedadosavancada.InvalidNodeException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Nunes
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinarySearchTree<Integer, Integer> arvore = new BinarySearchTree<>();
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
                        System.out.println("A arvore possui " + arvore.size() + " nos");
                        break;
                    case 2:
                        int chaveNoAlterar;
                        int novoValor;
                        System.out.println("Digite a chave do no a ser alterado o valor:");
                        chaveNoAlterar = scan.nextInt();
                        System.out.println("Digite o novo valor a ser inserido no nó:");
                        novoValor = scan.nextInt();
                         {
                            try {
                                arvore.replace(new BinaryNodeSearchTree<>(chaveNoAlterar, null),
                                        novoValor);
                                System.out.println("Valor alterado com sucesso");
                            } catch (InvalidNodeException | EmptyTreeException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                        break;
                    case 3:
                        int chaveNoParente;
                        System.out.println("Digite a chave do no a ser buscado o pai:");
                        chaveNoParente = scan.nextInt();
                        try {
                            BinaryNodeSearchTree<Integer, Integer> node_father
                                    = arvore.parent(new BinaryNodeSearchTree<>(chaveNoParente, null));
                            if (node_father == null) {
                                System.out.println("O no a ser buscado o pai é o raiz,"
                                        + " portanto o mesmo nao possui no pai");
                            } else {
                                System.out.println("Foi encontrado como pai o no de chave " + node_father.getChave()
                                        + "e valor " + node_father.getValor());
                            }
                        } catch (InvalidNodeException | EmptyTreeException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case 4:
                        int chaveNoFilhos;
                        System.out.println("Digite a chave do no a ser buscado o(s) filho(s):");
                        chaveNoFilhos = scan.nextInt();
                        try {
                            List<BinaryNodeSearchTree<Integer, Integer>> filhos
                                    = (List<BinaryNodeSearchTree<Integer, Integer>>) arvore.children(new BinaryNodeSearchTree<>(chaveNoFilhos, null));
                            if (filhos.isEmpty()) {
                                System.out.println("O no informado nao possui filhos");
                            } else {
                                for (int i = 0; i < filhos.size(); i++) {
                                    System.out.println("------------Filho " + (i + 1) + "-----------------");
                                    System.out.println("Chave: " + filhos.get(i).getChave() + " | "
                                            + "Valor: " + filhos.get(i).getValor());
                                }
                            }
                        } catch (InvalidNodeException | EmptyTreeException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case 5:
                        int chaveNoInterno;
                        System.out.println("Digite a chave do no a ser verificado se é interno: ");
                        chaveNoInterno = scan.nextInt();
                        try {
                            if (arvore.isInternal(new BinaryNodeSearchTree<>(chaveNoInterno, null))) {
                                System.out.println("O no informado e interno");
                            } else {
                                System.out.println("O no informado nao e interno");
                            }
                        } catch (InvalidNodeException | EmptyTreeException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case 6:
                        int chaveNoFolha;
                        System.out.println("Digite a chave do no a ser verificado se é folha: ");
                        chaveNoFolha = scan.nextInt();
                        try {
                            if (arvore.isExternal(new BinaryNodeSearchTree<>(chaveNoFolha, null))) {
                                System.out.println("O no informado e folha");
                            } else {
                                System.out.println("O no informado nao e folha");
                            }
                        } catch (InvalidNodeException | EmptyTreeException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case 7:
                        int chaveNovoNo;
                        int valorNovoNo;
                        System.out.println("Digite a chave do novo no a ser inserido");
                        chaveNovoNo = scan.nextInt();
                        System.out.println("Digite o valor do novo no a ser inserido");
                        valorNovoNo = scan.nextInt();
                        try {
                            arvore.insert(new BinaryNodeSearchTree<>(chaveNovoNo, valorNovoNo));
                            System.out.println("No inserido com sucesso");
                        } catch (InvalidNodeException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case 8:
                        int chaveNoBuscar;
                        System.out.println("Digite a chave do no a ser buscado na arvore");
                        chaveNoBuscar = scan.nextInt();
                        try {
                            BinaryNodeSearchTree noEncontrado = arvore.find_recursivo(chaveNoBuscar);
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
                    case 9:
                        List<BinaryNodeSearchTree<Integer, Integer>> nos_pre_ordem = arvore.pre_ordem();
                        if (nos_pre_ordem.isEmpty()) {
                            System.out.println("Nao ha nos na arvore");
                        } else {
                            System.out.println("Nos em pre-ordem pela chave");
                            for (BinaryNodeSearchTree<Integer, Integer> no_atual : nos_pre_ordem) {
                                System.out.print(no_atual.getChave() + " , ");
                            }
                            System.out.println();
                        }
                        break;
                    case 10:
                        List<BinaryNodeSearchTree<Integer, Integer>> nos_em_ordem = arvore.em_ordem();
                        if (nos_em_ordem.isEmpty()) {
                            System.out.println("Nao ha nos na arvore");
                        } else {
                            System.out.println("Nos em em-ordem pela chave");
                            for (BinaryNodeSearchTree<Integer, Integer> no_atual : nos_em_ordem) {
                                System.out.print(no_atual.getChave() + " , ");
                            }
                            System.out.println();
                        }
                        break;
                    case 11:
                        List<BinaryNodeSearchTree<Integer, Integer>> nos_pos_ordem = arvore.pos_ordem();
                        if (nos_pos_ordem.isEmpty()) {
                            System.out.println("Nao ha nos na arvore");
                        } else {
                            System.out.println("Nos em pos-ordem pela chave");
                            for (BinaryNodeSearchTree<Integer, Integer> no_atual : nos_pos_ordem) {
                                System.out.print(no_atual.getChave() + " , ");
                            }
                            System.out.println();
                        }
                        break;
                    case 12:
                        int chaveNoRemover;
                        System.out.println("Digite a chave do no a ser removido: ");
                        chaveNoRemover = scan.nextInt();
                        if (arvore.remove(chaveNoRemover)) {
                            System.out.println("No removido com sucesso");
                        } else {
                            System.out.println("Nao existe no com cahve informada na arvore");
                        }
                        break;
                    case 13:
                        if (arvore.isEmpty()) {
                            System.out.println("A arvore nao possui nenhum no");
                        } else {
                            BinaryNodeSearchTree<Integer, Integer> maiorNo = arvore.retornaMaior();
                            System.out.println("O maior no da arvore é o no de chave "
                                    + maiorNo.getChave() + " e valor " + maiorNo.getValor());
                        }
                        break;
                    case 14:
                        if (arvore.isEmpty()) {
                            System.out.println("A arvore nao possui nenhum no");
                        } else {
                            BinaryNodeSearchTree<Integer, Integer> menorNo = arvore.retornaMenor();
                            System.out.println("O menor no da arvore é o no de chave "
                                    + menorNo.getChave() + " e valor " + menorNo.getValor());
                        }
                        break;
                    case 15:
                        if (arvore.isEmpty()) {
                            System.out.println("A arvore nao possui nenhum no");
                        } else {
                            System.out.println("A media dos valores das chaves dos nos e " + arvore.retornaMedia());
                        }
                        break;
                    case 16:
                        if (arvore.isEmpty()) {
                            System.out.println("A arvore nao possui nenhum no");
                        } else {
                            System.out.println("A arvore possui um total de "
                                    + arvore.retornaNumeroDeFolhas() + " folhas");
                        }
                        break;
                    case 17:
                        if (arvore.isEmpty()) {
                            System.out.println("A arvore nao possui nenhum no");
                        } else {
                            System.out.println("A arvore possui altura total de " + arvore.retornaAltura());
                        }
                        break;
                    case 18:
                        System.out.println(arvore.printarArvore());
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
        System.out.println("1 - Quantidade De Nos");
        System.out.println("2 - Sunstituir valor de um no da arvore(OBS: Valor e nao chave)");
        System.out.println("3 - Retornar parente de um dado no");
        System.out.println("4 - Retornar os filhos de um dado no");
        System.out.println("5 - Verificar se um dado no e interno");
        System.out.println("6 - Verificar se um dado no e folha");
        System.out.println("7 - Inserir no");
        System.out.println("8 - Buscar um dado no");
        System.out.println("9 - Navegar em pre-ordem");
        System.out.println("10 - Navegar em em-ordem");
        System.out.println("11 - Navegar em pos-ordem");
        System.out.println("12 - Remover no da arvore");
        System.out.println("13 - Retornar Maior No");
        System.out.println("14 - Retornar Menor No");
        System.out.println("15 - Retornar Media dos valores da arvore");
        System.out.println("16 - Retornar numero de folhas");
        System.out.println("17 - Retornar altura da arvore");
        System.out.println("18 - Mostrar Arvore(Funciona melhor com uma quantidade maxima de 7 nos "
                + "como uma arvore completa)");
        System.out.println("Escolha uma opção do menu: ");
    }

}
