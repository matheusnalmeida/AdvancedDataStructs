/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree;

/**
 *
 * @author 1181123221
 */
import estruturadedadosavancada.EmptyTreeException;
import estruturadedadosavancada.InvalidNodeException;
import java.util.ArrayList;
import java.util.List;
import estruturadedadosavancada.BinarySearchTree_int;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<Index extends Comparable<Index>, E> implements BinarySearchTree_int<Index, E> {

    private int tamanho;
    private BinaryNodeSearchTree<Index, E> root;

    public BinarySearchTree() {
        this.tamanho = 0;
        this.root = null;
    }

    @Override
    public int size() {
        return this.tamanho;
    }

    @Override
    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    @Override
    public Iterable<BinaryNodeSearchTree<Index, E>> nodes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E replace(BinaryNodeSearchTree<Index, E> node, E v) throws InvalidNodeException, EmptyTreeException {
        BinaryNodeSearchTree<Index, E> actual_node = this.find_iterativo(node.getChave());
        if (actual_node == null) {
            throw new InvalidNodeException("No nao existente na arvore");
        }

        node.setValor(v);

        return v;
    }

    @Override
    public BinaryNodeSearchTree<Index, E> root() throws EmptyTreeException {
        if (this.tamanho == 0) {
            throw new EmptyTreeException("A arvore esta vazia");
        }

        return this.root;
    }

    @Override
    public BinaryNodeSearchTree<Index, E> parent(BinaryNodeSearchTree<Index, E> node) throws InvalidNodeException, EmptyTreeException {
        BinaryNodeSearchTree<Index, E> actual_node = this.find_iterativo(node.getChave());
        if (actual_node == null) {
            throw new InvalidNodeException("No nao existente");
        }

        return actual_node.getFather();
    }

    @Override
    public Iterable<BinaryNodeSearchTree<Index, E>> children(BinaryNodeSearchTree<Index, E> node) throws InvalidNodeException, EmptyTreeException {
        if (this.tamanho == 0) {
            throw new EmptyTreeException("Arvore vazia");
        }
        List<BinaryNodeSearchTree<Index, E>> filhos = new ArrayList<>();
        BinaryNodeSearchTree<Index, E> actual_node = this.find_iterativo(node.getChave());
        if (actual_node == null) {
            throw new InvalidNodeException("No nao existente");
        }
        if (actual_node.getEsquerda() != null) {
            filhos.add(actual_node.getEsquerda());
        }
        if (actual_node.getDireita() != null) {
            filhos.add(actual_node.getDireita());
        }

        return filhos;
    }

    @Override
    public boolean isInternal(BinaryNodeSearchTree<Index, E> node) throws InvalidNodeException, EmptyTreeException {
        if (this.isRoot(node)) {
            return false;
        }
        BinaryNodeSearchTree<Index, E> actual_node = this.find_iterativo(node.getChave());
        if (actual_node == null) {
            throw new InvalidNodeException("No nao exstente");
        }

        if (actual_node.getEsquerda() != null || actual_node.getDireita() != null) {
            return true;
        }

        return false;
    }

    @Override
    public Iterator<BinaryNodeSearchTree<Index, E>> iterator() {
        return new BinarySearchTreeIterator<Index, E>(this.root);
    }

    @Override
    public boolean isExternal(BinaryNodeSearchTree<Index, E> node) throws InvalidNodeException, EmptyTreeException {
        if (this.isRoot(node)) {
            return false;
        }
        BinaryNodeSearchTree<Index, E> actual_node = this.find_iterativo(node.getChave());
        if (actual_node == null) {
            throw new InvalidNodeException("No nao exstente");
        }

        if (actual_node.getEsquerda() == null && actual_node.getDireita() == null) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isRoot(BinaryNodeSearchTree<Index, E> node) throws EmptyTreeException {
        return this.root().getChave().equals(node.getChave());
    }

    @Override
    public void insert(BinaryNodeSearchTree<Index, E> new_node) throws InvalidNodeException {
        if (this.root == null) {
            this.root = new_node;
            this.tamanho++;
        } else {
            BinaryNodeSearchTree<Index, E> current = this.root;
            while (true) {
                if (new_node.getChave().compareTo(current.getChave()) < 0) {
                    if (current.getEsquerda() == null) {
                        current.setEsquerda(new_node);
                        new_node.setFather(current);
                        this.tamanho++;
                        return;
                    }
                    current = current.getEsquerda();
                } else if (new_node.getChave().compareTo(current.getChave()) > 0) {
                    if (current.getDireita() == null) {
                        current.setDireita(new_node);
                        new_node.setFather(current);
                        this.tamanho++;
                        return;
                    }
                    current = current.getDireita();
                } else {
                    throw new InvalidNodeException("Ja existe no com a chave informada");
                }
            }
        }
    }

    @Override
    public BinaryNodeSearchTree<Index, E> find_iterativo(Index index) throws EmptyTreeException {
        if (this.tamanho == 0) {
            throw new EmptyTreeException("Arvore Vazia");
        }
        BinaryNodeSearchTree<Index, E> current = this.root;
        while (current.getChave().compareTo(index) != 0) {
            if (index.compareTo(current.getChave()) < 0) {
                current = current.getEsquerda();
            } else {
                current = current.getDireita();
            }
            if (current == null) {
                return null;
            }
        }

        return current;
    }

    @Override
    public BinaryNodeSearchTree<Index, E> find_recursivo(Index index) throws EmptyTreeException {
        if (this.tamanho == 0) {
            throw new EmptyTreeException("Arvore Vazia");
        }

        return find_recursivo(this.root, index);
    }

    private BinaryNodeSearchTree<Index, E> find_recursivo(BinaryNodeSearchTree<Index, E> actual_node, Index index_find) {
        if (actual_node == null) {
            return null;
        }
        if (index_find.compareTo(actual_node.getChave()) < 0) {
            return find_recursivo(actual_node.getEsquerda(), index_find);
        } else if (index_find.compareTo(actual_node.getChave()) > 0) {
            return find_recursivo(actual_node.getDireita(), index_find);
        } else {
            return actual_node;
        }
    }

    //Algoritimos de navegacao
    @Override
    public List<BinaryNodeSearchTree<Index, E>> pre_ordem() {
        List<BinaryNodeSearchTree<Index, E>> nos_pre_ordem = new ArrayList<>();
        return this.pre_ordem(this.root, nos_pre_ordem);
    }

    private List<BinaryNodeSearchTree<Index, E>> pre_ordem(BinaryNodeSearchTree<Index, E> current, List<BinaryNodeSearchTree<Index, E>> nos_pre_ordem) {
        if (current != null) {
            nos_pre_ordem.add(current);
            pre_ordem(current.getEsquerda(), nos_pre_ordem);
            pre_ordem(current.getDireita(), nos_pre_ordem);
        }
        return nos_pre_ordem;
    }

    @Override
    public List<BinaryNodeSearchTree<Index, E>> pos_ordem() {
        List<BinaryNodeSearchTree<Index, E>> nos_pos_ordem = new ArrayList<>();
        return this.pos_ordem(this.root, nos_pos_ordem);
    }

    private List<BinaryNodeSearchTree<Index, E>> pos_ordem(BinaryNodeSearchTree<Index, E> current, List<BinaryNodeSearchTree<Index, E>> nos_pos_ordem) {
        if (current != null) {
            pre_ordem(current.getEsquerda(), nos_pos_ordem);
            pre_ordem(current.getDireita(), nos_pos_ordem);
            nos_pos_ordem.add(current);

        }
        return nos_pos_ordem;
    }

    @Override
    public List<BinaryNodeSearchTree<Index, E>> em_ordem() {
        List<BinaryNodeSearchTree<Index, E>> nos_em_ordem = new ArrayList<>();
        return this.em_ordem(this.root, nos_em_ordem);
    }

    private List<BinaryNodeSearchTree<Index, E>> em_ordem(BinaryNodeSearchTree<Index, E> current, List<BinaryNodeSearchTree<Index, E>> nos_em_ordem) {
        if (current != null) {
            pre_ordem(current.getEsquerda(), nos_em_ordem);
            nos_em_ordem.add(current);
            pre_ordem(current.getDireita(), nos_em_ordem);
        }
        return nos_em_ordem;
    }

    @Override
    public boolean remove(Index index) {
        BinaryNodeSearchTree<Index, E> current = this.root;
        boolean ehEsquerdo = true;
        while (current.getChave().compareTo(index) != 0) {
            if (index.compareTo(current.getChave()) < 0) {
                current = current.getEsquerda();
                ehEsquerdo = true;
            } else {
                current = current.getDireita();
                ehEsquerdo = false;
            }
            if (current == null) {
                return false;
            }
        }
        //Verificando se o no e folha
        if (current.getEsquerda() == null && current.getDireita() == null) {
            if (current.getChave() == this.root.getChave()) {
                this.root = null;
            } else if (ehEsquerdo) {
                current.getFather().setEsquerda(null);
            } else {
                current.getFather().setDireita(null);
            }
            this.tamanho--;
            return true;
        } //Verificando se o no possui uma sub arvore ou a direita ou a esquerda
        else if (current.getEsquerda() != null && current.getDireita() == null) {
            if (current.getChave() == this.root.getChave()) {
                this.root = current.getEsquerda();
            }else if (ehEsquerdo) {
                current.getFather().setEsquerda(current.getEsquerda());
            } else {
                current.getFather().setDireita(current.getEsquerda());
            }
            this.tamanho--;
            return true;
        } else if (current.getDireita() != null && current.getEsquerda() == null) {
            if (current.getChave() == this.root.getChave()) {
                this.root = current.getDireita();
            }else if (ehEsquerdo) {
                current.getFather().setEsquerda(current.getDireita());
            } else {
                current.getFather().setDireita(current.getDireita());
            }
            this.tamanho--;
            return true;
        }//Condicao a ser executada caso o no possua mais de uma sub arvore
        else{
            BinaryNodeSearchTree<Index,E> sucessor = this.acharSucessor(current);
            if(current.getChave().compareTo(this.root.getChave()) == 0){
                this.root = sucessor;
            }else if(ehEsquerdo){
                current.getFather().setEsquerda(sucessor);
            }else{
                current.getFather().setDireita(sucessor);
            }
            sucessor.setEsquerda(current.getEsquerda());
            this.tamanho--;
            return true;
        }
    }
    
    private BinaryNodeSearchTree<Index,E> acharSucessor(BinaryNodeSearchTree<Index,E> no_removido){
        if(no_removido.getDireita() == null){
            return no_removido;
        }else{
            BinaryNodeSearchTree<Index,E> no_atual = no_removido.getDireita();
            while(no_atual.getEsquerda() != null){
                no_atual = no_atual.getEsquerda();
            }
            
            if(no_atual.getChave().compareTo(no_removido.getDireita().getChave()) != 0){
                no_atual.getFather().setEsquerda(no_atual.getDireita());
                no_atual.setDireita(no_removido.getDireita());
            }
            return no_atual;
        }
    }
    
    public String printarArvore() {
        try {
            int tamanhoDoBuffer = 150;
            StringBuilder construtor = new StringBuilder();
            for (int i = 0; i < tamanhoDoBuffer; i++) {
                construtor.append(" ");
            }

            Iterator<BinaryNodeSearchTree<Index, E>> iterator = this.iterator();
            E elementoNaoFormatado = this.root().getValor();

            String complete_tree = "";
            Queue<ArrayList<Integer>> filaDePosicoes = new LinkedList<>();
            int quantidadeDeNosNivel = 1;
            
            String nome_formatado_root = formata_nome(elementoNaoFormatado.toString());
            int meioDaPalavra = ((nome_formatado_root.length()) / 2) - 1;

            int posicaoInicioRaiz = (tamanhoDoBuffer / 2) - ((meioDaPalavra + 1) - 1);
            int posicaoFimRaiz = ((tamanhoDoBuffer / 2) + (nome_formatado_root.length() - (meioDaPalavra + 1)) + 1);
            ArrayList<Integer> posicoes = new ArrayList<>();
            posicoes.add(posicaoInicioRaiz);
            posicoes.add(posicaoFimRaiz);
            filaDePosicoes.add(posicoes);

            while (!filaDePosicoes.isEmpty()) {
                int posicaoDaPalavra = 0;
                //Pegando todos os nos do nivel atual para serem posteriormente inseridos na linha
                ArrayList<BinaryNodeSearchTree<Index, E>> nos_atuais = new ArrayList<>();
                ArrayList<ArrayList<Integer>> posicoesAtuais = new ArrayList<>();
                for (int i = 0; i < quantidadeDeNosNivel; i++) {
                    BinaryNodeSearchTree<Index, E> no_atual = iterator.next();
                    nos_atuais.add(no_atual);
                    posicoesAtuais.add(filaDePosicoes.poll());
                }

                for (int i = 0; i < nos_atuais.size(); i++) {
                    if (nos_atuais.get(i).getChave().equals(this.root().getChave())) {
                        for (int y = posicoesAtuais.get(i).get(0); y < posicoesAtuais.get(i).get(1); y++) {
                            construtor.setCharAt(y, nome_formatado_root.charAt(posicaoDaPalavra++));
                        }
                        posicaoDaPalavra = 0;
                    } else {
                        for (int y = posicoesAtuais.get(i).get(0); y < posicoesAtuais.get(i).get(1); y++) {
                            construtor.setCharAt(y, nos_atuais.get(i).getValor().toString().charAt(posicaoDaPalavra++));
                        }
                        posicaoDaPalavra = 0;
                    }
                }
                construtor.append("\n");

                quantidadeDeNosNivel = 0;
                for (int i = 0; i < nos_atuais.size(); i++) {
                    List<BinaryNodeSearchTree<Index, E>> elementosAtuais = (List<BinaryNodeSearchTree<Index, E>>) this.children(nos_atuais.get(i));
                    quantidadeDeNosNivel += elementosAtuais.size();
                    for (int y = 0; y < elementosAtuais.size(); y++) {
                        int tamanhoDaPalavraFilhoAtual = elementosAtuais.get(y).getValor().toString().length();
                        if (nos_atuais.get(i).getEsquerda() != null && nos_atuais.get(i).getEsquerda().equals(elementosAtuais.get(y))) {
                            int posicaoFimFilhoEsquerdo = posicoesAtuais.get(i).get(0) - 1;
                            int posicaoInicioFilhoEsquerdo = (posicaoFimFilhoEsquerdo - (tamanhoDaPalavraFilhoAtual));
                            ArrayList<Integer> posicoes_filho = new ArrayList<>();
                            posicoes_filho.add(posicaoInicioFilhoEsquerdo);
                            posicoes_filho.add(posicaoFimFilhoEsquerdo);
                            filaDePosicoes.add(posicoes_filho);
                        }
                        if (nos_atuais.get(i).getDireita() != null && nos_atuais.get(i).getDireita().equals(elementosAtuais.get(y))) {
                            int posicaoInicioFilhoDireito = posicoesAtuais.get(i).get(1) + 1;
                            int posicaoFinalFilhoDireito = (posicaoInicioFilhoDireito + tamanhoDaPalavraFilhoAtual);
                            ArrayList<Integer> posicoes_filho = new ArrayList<>();
                            posicoes_filho.add(posicaoInicioFilhoDireito);
                            posicoes_filho.add(posicaoFinalFilhoDireito);
                            filaDePosicoes.add(posicoes_filho);
                        }
                    }
                }

                complete_tree += construtor.toString();
                construtor = new StringBuilder();
                for (int i = 0; i < tamanhoDoBuffer; i++) {
                    construtor.append(" ");
                }
            }

            return complete_tree;
        } catch (EmptyTreeException | InvalidNodeException ex) {
            return ex.getMessage();
        }
    }

    private String formata_nome(String nome) {
        StringBuilder nome_da_cidade_formatado = new StringBuilder();
        //Inserindo espacos antes da palavra
        int quantidade_de_espacos = nome.length();
        for (int i = 0; i < quantidade_de_espacos; i++) {
            nome_da_cidade_formatado.append(" ");
        }
        //Passando palavra para a nova string
        for (int i = 0; i < nome.length(); i++) {
            nome_da_cidade_formatado.append(nome.charAt(i));
        }
        //Inserindo espacos depois
        for (int i = 0; i < quantidade_de_espacos; i++) {
            nome_da_cidade_formatado.append(" ");
        }

        return nome_da_cidade_formatado.toString();
    }
        

}
