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
import java.util.Objects;

/**
 *
 * @author Matheus Nunes
 */
public class Suspeito implements Comparable<Suspeito> {

    private String nome;
    private List<Crime> listaDeCrimes;
    private BinarySearchTree<String, Suspeito> arvoreDeCumplices;

    public Suspeito(String nome) {
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
            this.arvoreDeCumplices.insert(new BinaryNodeSearchTree<>(cumplice.getNome(), cumplice));
            return true;
        } catch (InvalidNodeException ex) {
            return false;
        }
    }

    public boolean contemCumplice(Suspeito cumplice) {
        try {
            BinaryNodeSearchTree<String, Suspeito> elemento_atual = this.arvoreDeCumplices.find_iterativo(cumplice.getNome());
            if (elemento_atual != null) {
                return true;
            }
            return false;
        } catch (EmptyTreeException ex) {
            return false;
        }
    }

    public String listarCumplicesOrdenado() {
        List<BinaryNodeSearchTree<String, Suspeito>> listaDeCumplices = this.arvoreDeCumplices.em_ordem();
        if (listaDeCumplices.isEmpty()) {
            return "O suspeito nao possui cumplices";
        }
        StringBuilder construtor = new StringBuilder();
        construtor.append("---------------------Segue os cumplices do suspeito ").
                append(this.nome).append(" -----------------\n");
        for (int i = 0; i < listaDeCumplices.size(); i++) {
            construtor.append(listaDeCumplices.get(i)).append(", ");
            ;
        }
        return construtor.toString();
    }

    public BinarySearchTree<String, Suspeito> getArvoreDeCumplices() {
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
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nome);
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
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    

}
