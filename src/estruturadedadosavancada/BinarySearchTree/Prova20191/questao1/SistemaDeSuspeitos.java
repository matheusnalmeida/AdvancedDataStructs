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
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Matheus Nunes
 */
public class SistemaDeSuspeitos {

    ArrayList<Suspeito> suspeitos_cadastrados;
    BinarySearchTree<String, List<Suspeito>> arvoreDeSuspeitos;

    public SistemaDeSuspeitos() {
        this.suspeitos_cadastrados = new ArrayList<>();
        this.arvoreDeSuspeitos = new BinarySearchTree<>();
    }

    public boolean contemSuspeito(Suspeito suspeito) {
        try {
            BinaryNodeSearchTree<String, List<Suspeito>> elemento_atual = this.arvoreDeSuspeitos.find_recursivo(suspeito.getNome());
            if (elemento_atual != null) {
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
                List<Suspeito> lista_atual = new ArrayList<>();
                lista_atual.add(suspeito);
                this.arvoreDeSuspeitos.insert(new BinaryNodeSearchTree<>(suspeito.getNome(), lista_atual));
                return "Suspeito com nome " + suspeito.getNome() + " cadastrado com sucesso";
            }
            BinaryNodeSearchTree<String, List<Suspeito>> elemento_encontrado = this.arvoreDeSuspeitos.find_recursivo(suspeito.getNome());
            if (elemento_encontrado == null) {
                List<Suspeito> lista_atual = new ArrayList<>();
                lista_atual.add(suspeito);
                this.arvoreDeSuspeitos.insert(new BinaryNodeSearchTree<>(suspeito.getNome(), lista_atual));
                this.suspeitos_cadastrados.add(suspeito);
                return "Suspeito com nome " + suspeito.getNome() + " cadastrado com sucesso";
            } else {
                List<Suspeito> suspeitos_atual = elemento_encontrado.getValor();
                if (!suspeitos_atual.contains(suspeito)) {
                    suspeitos_atual.add(suspeito);
                    return "Suspeito cadastrado com sucesso";
                } else {
                    return "Ja existe suspeito com o id informado com o respectivo nome";
                }
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
            BinaryNodeSearchTree<String, List<Suspeito>> elemento_encontrado = this.arvoreDeSuspeitos.find_recursivo(suspeito.getNome());
            if (elemento_encontrado != null) {
                List<Suspeito> suspeito_encontrado = elemento_encontrado.getValor();
                for (int i = 0; i < suspeito_encontrado.size(); i++) {
                    if (suspeito_encontrado.get(i).equals(suspeito)) {
                        Suspeito suspeito_atual = suspeito_encontrado.get(i);
                        if (suspeito_atual.contemCumplice(cumplice)) {
                            return "Cumplice ja cadastrado no suspeito informado";
                        } else {
                            suspeito_atual.cadastrarCumplice(cumplice);
                            return "Cumplice " + cumplice.getNome() + " cadastrado com sucesso no suspeito " + suspeito.getNome();
                        }
                    }
                }
                return "Nao existe suspeito com o id do suspeito informado";
            } else {
                return "Nao existe suspeito com o nome informado";
            }
        } catch (EmptyTreeException ex) {
            return ex.getMessage();
        }
    }

    public String listarCumplicesOrdenado(Suspeito suspeito) {
        try {
            BinaryNodeSearchTree<String, List<Suspeito>> elemento_encontrado = this.arvoreDeSuspeitos.find_recursivo(suspeito.getNome());
            if (elemento_encontrado == null) {
                return "Nao existe suspeito com o nome informado";
            } else {
                List<Suspeito> lista_de_suspeitos = elemento_encontrado.getValor();
                for (int i = 0; i < lista_de_suspeitos.size(); i++) {
                    if (lista_de_suspeitos.get(i).equals(suspeito)) {
                        return lista_de_suspeitos.get(i).listarCumplicesOrdenado();
                    }
                }
                return "Nao ha suspeito com o id do suspeito informado";
            }
        } catch (EmptyTreeException ex) {
            return "Nao a suspeitos cadastrados";
        }
    }

    public String listarCrimes(Suspeito suspeito) {
        try {
            BinaryNodeSearchTree<String, List<Suspeito>> elemento_encontrado = this.arvoreDeSuspeitos.find_recursivo(suspeito.getNome());
            if (elemento_encontrado == null) {
                return "Nao existe suspeito com o nome informado";
            } else {
                List<Suspeito> lista_de_suspeitos = elemento_encontrado.getValor();
                for (int i = 0; i < lista_de_suspeitos.size(); i++) {
                    if (lista_de_suspeitos.get(i).equals(suspeito)) {
                        return lista_de_suspeitos.get(i).listarCrimes();
                    }
                }
                return "Nao ha suspeito com o id do suspeito informado";
            }
        } catch (EmptyTreeException ex) {
            return "Nao a suspeitos cadastrados";
        }
    }

    public String listarCumplicesEmComum(Suspeito suspeito1, Suspeito suspeito2) {
        try {
            BinaryNodeSearchTree<String, List<Suspeito>> elemento_encontrado1 = this.arvoreDeSuspeitos.find_recursivo(suspeito1.getNome());
            BinaryNodeSearchTree<String, List<Suspeito>> elemento_encontrado2 = this.arvoreDeSuspeitos.find_recursivo(suspeito2.getNome());
            if (elemento_encontrado1 != null && elemento_encontrado2 != null) {
                if (elemento_encontrado1.getValor().contains(suspeito1) && elemento_encontrado2.getValor().contains(suspeito2)) {
                    //Procurando suspeitos com o id em especifico aos passados como parametro
                    Suspeito suspeito_a1 = null;
                    Suspeito suspeito_a2 = null;
                    for (int i = 0; i < elemento_encontrado1.getValor().size(); i++) {
                        if (elemento_encontrado1.getValor().get(i).equals(suspeito1)) {
                            suspeito_a1 = elemento_encontrado1.getValor().get(i);
                        }
                    }
                    for (int i = 0; i < elemento_encontrado2.getValor().size(); i++) {
                        if (elemento_encontrado2.getValor().get(i).equals(suspeito2)) {
                            suspeito_a2 = elemento_encontrado2.getValor().get(i);
                        }
                    }
                    BinarySearchTree<String, List<Suspeito>> arvore_de_cumplices_1 = suspeito_a1.getArvoreDeCumplices();
                    BinarySearchTree<String, List<Suspeito>> arvore_de_cumplices_2 = suspeito_a2.getArvoreDeCumplices();
                    if (arvore_de_cumplices_1.isEmpty() || arvore_de_cumplices_2.isEmpty()) {
                        return "Nao ha suspeitos em comum";
                    }
                    Iterator<BinaryNodeSearchTree<String, List<Suspeito>>> it = arvore_de_cumplices_1.iterator();
                    ArrayList<Suspeito> lista_de_suspeitos = new ArrayList();
                    while (it.hasNext()) {
                        BinaryNodeSearchTree<String, List<Suspeito>> actual_node = it.next();
                        BinaryNodeSearchTree<String, List<Suspeito>> no_encontrado = arvore_de_cumplices_2.find_recursivo(actual_node.getChave());
                        if (no_encontrado != null) {
                            List<Suspeito> lista_atual = actual_node.getValor();
                            List<Suspeito> lista_atual_encontrada = no_encontrado.getValor();
                            for (int i = 0; i < lista_atual.size(); i++) {
                                if (lista_atual_encontrada.contains(lista_atual.get(i))) {
                                    lista_de_suspeitos.add(lista_atual.get(i));
                                }
                            }
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
                    return "Um dos suspeitos informados nao possui id valido";
                }
            } else {
                return "Um dos elementos informados e invalido";
            }
        } catch (EmptyTreeException ex) {
            return "Nao a suspeitos cadastrados";
        }
    }

    public String informarAlcance(Suspeito suspeito, int distanciaMaxima) {
        try {
            BinaryNodeSearchTree<String, List<Suspeito>> elemento_encontrado = this.arvoreDeSuspeitos.find_recursivo(suspeito.getNome());
            if (elemento_encontrado != null) {
                if (elemento_encontrado.getValor().contains(suspeito)) {
                    //Procurando suspeitos com o id em especifico aos passados como parametro
                    Suspeito suspeito_encontrado = null;
                    for (int i = 0; i < elemento_encontrado.getValor().size(); i++) {
                        if (elemento_encontrado.getValor().get(i).equals(suspeito)) {
                            suspeito_encontrado = elemento_encontrado.getValor().get(i);
                        }
                    }
                    StringBuilder construtor = new StringBuilder();
                    construtor.append("--------------Abaixo seguem os suspeitos e suas respectivas distancias do suspeito ")
                            .append(suspeito_encontrado.getNome()).append(" ------------------\n");
                    Iterator<BinaryNodeSearchTree<String, List<Suspeito>>> iterator_atual = suspeito_encontrado.getArvoreDeCumplices().iterator();
                    Queue<Suspeito> fila_de_suspeitos = new LinkedList<>();
                    while (iterator_atual.hasNext()) {
                        BinaryNodeSearchTree<String, List<Suspeito>> elemento_atual = iterator_atual.next();
                        for (int i = 0; i < elemento_atual.getValor().size(); i++) {
                            fila_de_suspeitos.add(elemento_atual.getValor().get(i));
                        }
                    }
                    int distanciaAtual = 1;
                    while (!fila_de_suspeitos.isEmpty() && distanciaAtual <= distanciaMaxima) {
                        int quantidadeNivelAtual = fila_de_suspeitos.size();
                        construtor.append("Suspeitos a distancia ").append(distanciaAtual++).append(" do suspeito ").append(suspeito.getNome()).append("\n");
                        for (int i = 0; i < quantidadeNivelAtual; i++) {
                            Suspeito suspeito_atual = fila_de_suspeitos.poll();
                            construtor.append(suspeito_atual).append(", ");
                            Iterator<BinaryNodeSearchTree<String, List<Suspeito>>> it_atual = suspeito_atual.getArvoreDeCumplices().iterator();
                            while (it_atual.hasNext()) {
                                BinaryNodeSearchTree<String, List<Suspeito>> elemento_atual = it_atual.next();
                                for (int y = 0; y < elemento_atual.getValor().size(); y++) {
                                    fila_de_suspeitos.add(elemento_atual.getValor().get(y));
                                }
                            }
                        }
                        construtor.append("\n");
                    }
                    return construtor.toString();
                } else {
                    return "Um dos suspeitos informados nao possui id valido";
                }
            } else {
                return "Nao existe suspeito com o nome informado";
            }
        } catch (EmptyTreeException ex) {
            return "Nao ha suspeitos cadastrados";
        }
    }

}
