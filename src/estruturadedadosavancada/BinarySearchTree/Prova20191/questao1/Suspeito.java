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
import java.util.List;

/**
 *
 * @author Matheus Nunes
 */
public class Suspeito implements Comparable<Suspeito> {

    private int id;
    private String nome;
    private List<Crime> listaDeCrimes;
    private BinarySearchTree<String, List<Suspeito>> arvoreDeCumplices;

    public Suspeito(String nome, int id) {
        this.id = id;
        this.nome = nome;
        this.arvoreDeCumplices = new BinarySearchTree<>();
        this.listaDeCrimes = new ArrayList<>();
    }

    @Override
    public int compareTo(Suspeito o) {
        return this.nome.compareTo(o.nome);
    }

    public String getNome() {
        return nome;
    }

    public boolean cadastrarCumplice(Suspeito cumplice) {
        try {
            BinaryNodeSearchTree<String, List<Suspeito>> elemento_atual = this.arvoreDeCumplices.find_iterativo(cumplice.getNome());
            if (elemento_atual != null) {
                if (!elemento_atual.getValor().contains(cumplice)) {
                    elemento_atual.getValor().add(cumplice);
                    return true;
                } else {
                    return false;
                }
            } else {
                List<Suspeito> lista_nova = new ArrayList<>();
                lista_nova.add(cumplice);
                BinaryNodeSearchTree<String, List<Suspeito>> novo_elemento = new BinaryNodeSearchTree<>(cumplice.getNome(), lista_nova);
                this.arvoreDeCumplices.insert(novo_elemento);
                return true;
            }
        } catch (EmptyTreeException ex) {
            List<Suspeito> lista_nova = new ArrayList<>();
            lista_nova.add(cumplice);
            BinaryNodeSearchTree<String, List<Suspeito>> novo_elemento = new BinaryNodeSearchTree<>(cumplice.getNome(), lista_nova);
            try {
                this.arvoreDeCumplices.insert(novo_elemento);
                return true;
            } catch (InvalidNodeException ex1) {
                return false;
            }
        } catch (InvalidNodeException ex) {
           return false;
        }
    }

    public boolean contemCumplice(Suspeito cumplice) {
        try {
            BinaryNodeSearchTree<String, List<Suspeito>> elemento_atual = this.arvoreDeCumplices.find_iterativo(cumplice.getNome());
            if (elemento_atual != null) {
                return elemento_atual.getValor().contains(cumplice);
            }
            return false;
        } catch (EmptyTreeException ex) {
            return false;
        }
    }

    public String listarCumplicesOrdenado() {
        List<BinaryNodeSearchTree<String, List<Suspeito>>> listaDeCumplices = this.arvoreDeCumplices.em_ordem();
        if (listaDeCumplices.isEmpty()) {
            return "O suspeito nao possui cumplices";
        }
        StringBuilder construtor = new StringBuilder();
        construtor.append("---------------------Segue os cumplices do suspeito ").
                append(this.nome).append(" -----------------\n");
        for (int i = 0; i < listaDeCumplices.size(); i++) {
            construtor.append(listaDeCumplices.get(i)).append(", ");
        }
        return construtor.toString();
    }

    public BinarySearchTree<String, List<Suspeito>> getArvoreDeCumplices() {
        return arvoreDeCumplices;
    }

    public String listarCrimes() {
        StringBuilder construtor = new StringBuilder();
        if (this.listaDeCrimes.isEmpty()) {
            return "O suspeito " + this.nome + " nao possui crimes cadastrados";
        } else {
            construtor.append("---------------------Segue os crimes do suspeito ").
                    append(this.nome).append(" -----------------\n");
            for (int i = 0; i < this.listaDeCrimes.size(); i++) {
                construtor.append(this.listaDeCrimes.get(i)).append(", ");
            }
            return construtor.toString();
        }
    }

    public boolean cadastrarCrime(Crime crime) {
        if (!this.listaDeCrimes.contains(crime)) {
            this.listaDeCrimes.add(crime);
            return true;
        } else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Suspeito other = (Suspeito) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
