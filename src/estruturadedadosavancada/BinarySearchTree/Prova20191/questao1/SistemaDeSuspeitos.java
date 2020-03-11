/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.Prova20191.questao1;

import estruturadedadosavancada.BinarySearchTree.BinaryNodeSearchTree;
import estruturadedadosavancada.BinarySearchTree.BinarySearchTree;
import estruturadedadosavancada.EmptyTreeException;
import estruturadedadosavancada.InvalidNodeException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Nunes
 */
public class SistemaDeSuspeitos {

    ArrayList<Suspeito> suspeitos_cadastrados;
    BinarySearchTree<String, Suspeito> arvoreDeSuspeitos;

    public SistemaDeSuspeitos() {
        this.suspeitos_cadastrados = new ArrayList<>();
        this.arvoreDeSuspeitos = new BinarySearchTree<>();
    }

    public boolean contemSuspeito(Suspeito suspeito){
        try {
            BinaryNodeSearchTree<String,Suspeito> elemento_atual = this.arvoreDeSuspeitos.find_recursivo(suspeito.getNome());
            if(elemento_atual != null){
                return true;
            }
            return false;
        } catch (EmptyTreeException ex) {
            return false;   
        }
    }
    
    public String cadastrarSuspeito(Suspeito suspeito) {
        try {
            if (this.arvoreDeSuspeitos.isEmpty()) {
                this.arvoreDeSuspeitos.insert(new BinaryNodeSearchTree<>(suspeito.getNome(), suspeito));
                return "Suspeito com nome " + suspeito.getNome() + " cadastrado com sucesso";
            }
            BinaryNodeSearchTree<String, Suspeito> elemento_encontrado = this.arvoreDeSuspeitos.find_recursivo(suspeito.getNome());
            if (elemento_encontrado == null) {
                this.arvoreDeSuspeitos.insert(new BinaryNodeSearchTree<>(suspeito.getNome(),suspeito));
                this.suspeitos_cadastrados.add(suspeito);
                return "Suspeito com nome " + suspeito.getNome() + " cadastrado com sucesso";
            } else {
                return "Ja existe suspeito com o nome informado na arvore de suspeitos";
            }
        } catch (EmptyTreeException | InvalidNodeException ex) {
            return ex.getMessage();
        }
    }

    public String cadastrarCumplice(Suspeito suspeito, Suspeito cumplice) {
        try {
            if (this.arvoreDeSuspeitos.isEmpty()) {
                return "Cadastre ao menos um suspeito para que se possa cadastrar um cumplice";
            }
            BinaryNodeSearchTree<String, Suspeito> elemento_encontrado = this.arvoreDeSuspeitos.find_recursivo(suspeito.getNome());
            if (elemento_encontrado != null) {
                Suspeito suspeito_encontrado = elemento_encontrado.getValor();
                if (suspeito_encontrado.contemCumplice(cumplice)) {
                    return "Cumplice ja cadastrado no suspeito informado";
                } else {
                    suspeito_encontrado.cadastrarCumplice(cumplice);
                    return "Cumplice "+ cumplice.getNome() + " cadastrado com sucesso no suspeito " + suspeito.getNome();
                }
            } else {
                return "Nao existe suspeito com o nome informado";
            }
        } catch (EmptyTreeException ex) {
            return ex.getMessage();
        }
    }

    public String listarCumplicesOrdenado(Suspeito suspeito) {
        try {
            BinaryNodeSearchTree<String, Suspeito> elemento_encontrado = this.arvoreDeSuspeitos.find_recursivo(suspeito.getNome());
            if (elemento_encontrado == null) {
                return "Nao existe suspeito com o nome informado";
            } else {
                return elemento_encontrado.getValor().listarCumplicesOrdenado();
            }
        } catch (EmptyTreeException ex) {
            return "Nao a suspeitos cadastrados";
        }
    }

    public String listarCrimes(Suspeito suspeito) {
        try {
            BinaryNodeSearchTree<String, Suspeito> elemento_encontrado = this.arvoreDeSuspeitos.find_recursivo(suspeito.getNome());
            if (elemento_encontrado == null) {
                return "Nao existe suspeito com o nome informado";
            } else {
                return elemento_encontrado.getValor().listarCrimes();
            }
        } catch (EmptyTreeException ex) {
            return "Nao a suspeitos cadastrados";
        }
    }

    public String listarCumplicesEmComum(Suspeito suspeito1, Suspeito suspeito2) {
        try {
            BinaryNodeSearchTree<String, Suspeito> elemento_encontrado1 = this.arvoreDeSuspeitos.find_recursivo(suspeito1.getNome());
            BinaryNodeSearchTree<String, Suspeito> elemento_encontrado2 = this.arvoreDeSuspeitos.find_recursivo(suspeito2.getNome());
            if (elemento_encontrado1 != null && elemento_encontrado2 != null) {
                BinarySearchTree<String, Suspeito> arvore_de_cumplices_1 = elemento_encontrado1.getValor().getArvoreDeCumplices();
                BinarySearchTree<String, Suspeito> arvore_de_cumplices_2 = elemento_encontrado2.getValor().getArvoreDeCumplices();
                if (arvore_de_cumplices_1.isEmpty() || arvore_de_cumplices_2.isEmpty()) {
                    return "Nao ha suspeitos em comum";
                }
                Iterator<BinaryNodeSearchTree<String, Suspeito>> it = arvore_de_cumplices_1.iterator();
                ArrayList<Suspeito> lista_de_suspeitos = new ArrayList();
                while (it.hasNext()) {
                    BinaryNodeSearchTree<String, Suspeito> actual_node = it.next();
                    BinaryNodeSearchTree<String, Suspeito> no_encontrado = arvore_de_cumplices_2.find_recursivo(actual_node.getChave());
                    if (no_encontrado != null) {
                        lista_de_suspeitos.add(no_encontrado.getValor());
                    }
                }
                StringBuilder construtor = new StringBuilder();
                construtor.append("--------------Abaixo seguem os suspeitos em comum do suspeito ")
                        .append(suspeito1.getNome()).append(" e do suspeito ").append(suspeito2.getNome()).append(" ------------------\n");
                for (int i = 0; i < lista_de_suspeitos.size(); i++) {
                    construtor.append(lista_de_suspeitos.get(i)).append(", ");
                }
                return construtor.toString();
            } else {
                return "Um dos elementos informados e invalido";
            }
        } catch (EmptyTreeException ex) {
            return "Nao a suspeitos cadastrados";
        }
    }

    public String informarAlcance(Suspeito suspeito, int distanciaMaxima) {
        try {
            BinaryNodeSearchTree<String, Suspeito> elemento_encontrado = this.arvoreDeSuspeitos.find_recursivo(suspeito.getNome());
            if (elemento_encontrado != null) {
                StringBuilder construtor = new StringBuilder();
                 construtor.append("--------------Abaixo seguem os suspeitos e suas respectivas distancias do suspeito ")
                        .append(suspeito.getNome()).append(" ------------------\n");
                Iterator<BinaryNodeSearchTree<String, Suspeito>> iterator_atual = elemento_encontrado.getValor().getArvoreDeCumplices().iterator();
                Queue<Suspeito> fila_de_suspeitos = new LinkedList<>();
                while (iterator_atual.hasNext()) {
                    fila_de_suspeitos.add(iterator_atual.next().getValor());
                }
                int distanciaAtual = 1;
                while (!fila_de_suspeitos.isEmpty() && distanciaAtual <= distanciaMaxima) {
                    int quantidadeNivelAtual = fila_de_suspeitos.size();
                    construtor.append("Suspeitos a distancia ").append(distanciaAtual++).append(" do suspeito ").append(suspeito.getNome()).append("\n");
                    for (int i = 0; i < quantidadeNivelAtual; i++) {
                        Suspeito suspeito_atual = fila_de_suspeitos.poll();
                        construtor.append(suspeito_atual).append(", ");
                        Iterator<BinaryNodeSearchTree<String, Suspeito>> it_atual = suspeito_atual.getArvoreDeCumplices().iterator();
                        while(it_atual.hasNext()){
                            fila_de_suspeitos.add(it_atual.next().getValor());
                        }
                    }
                    construtor.append("\n");
                }
                return construtor.toString();
            } else {
                return "Nao existe suspeito com o nome informado";
            }
        } catch (EmptyTreeException ex) {
            return "Nao ha suspeitos cadastrados";
        }
    }

}
