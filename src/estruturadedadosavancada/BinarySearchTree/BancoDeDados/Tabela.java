/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.BancoDeDados;

import estruturadedadosavancada.BinarySearchTree.BinaryNodeSearchTree;
import estruturadedadosavancada.BinarySearchTree.BinarySearchTree;
import estruturadedadosavancada.EmptyTreeException;
import estruturadedadosavancada.InvalidNodeException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 *
 * @author Matheus Nunes
 */
public class Tabela<E> {

    private Class<?> type;
    private String nome;
    private ArrayList<E> vetor_de_elementos;
    private ArrayList<String> vetor_de_tipos;
    private ArrayList<BinarySearchTree<Chave<E>, E>> arvores_binarias;

    public Tabela(String nome) {
        this.nome = nome;
        this.arvores_binarias = new ArrayList<>();
        this.vetor_de_elementos = new ArrayList<>();
        this.vetor_de_tipos = new ArrayList<>();
    }

    public String inserirElemento(BinaryNodeSearchTree<Chave<E>, E> new_node) throws InvalidNodeException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        if (type != null) {
            if (!type.equals(new_node.getValor().getClass())) {
                return "O tipo do elemento a ser inserido nao pertence ao tipo da tabela";
            }
        }
        if (!this.contemValorDaColuna(new_node.getValor(), this.vetor_de_elementos)) {
            if (this.arvores_binarias.isEmpty()) {
                this.type = new_node.getValor().getClass();
                this.arvores_binarias.add(new BinarySearchTree<>());
                BinarySearchTree<Chave<E>, E> arvore_primaria = this.arvores_binarias.get(0);
                arvore_primaria.insert(new_node);
                /*
            Adicionando os elementos nos vetores de referencia da classe somente apos a insercao na arvore, pois caso seja lancada
            uma excessao os elementos nao serao adicionados
                 */
                this.vetor_de_elementos.add(new_node.getValor());
                this.vetor_de_tipos.add(new_node.getChave().getTipo());
                return "Elemento cadastrado com sucesso na tabela de " + this.nome;
                //Somente serao permitidos serem cadastrados elementos pela sua chave primaria   
            } else if (this.vetor_de_tipos.get(0).equals(new_node.getChave().getTipo())) {
                if (this.arvores_binarias.size() == 1) {
                    BinarySearchTree<Chave<E>, E> arvore_primaria = this.arvores_binarias.get(0);
                    arvore_primaria.insert(new_node);
                    this.vetor_de_elementos.add(new_node.getValor());
                    return "Elemento cadastrado com sucesso na tabela de " + this.nome;
                } else {
                    BinarySearchTree<Chave<E>, E> arvore_primaria = this.arvores_binarias.get(0);
                    arvore_primaria.insert(new_node);
                    this.vetor_de_elementos.add(new_node.getValor());
                    for (int i = 1; i < this.arvores_binarias.size(); i++) {
                        Chave<E> nova_chave = new Chave<E>(this.vetor_de_tipos.get(i), new_node.getValor());
                        BinaryNodeSearchTree<Chave<E>, E> no_atual = new BinaryNodeSearchTree<Chave<E>, E>(nova_chave, new_node.getValor());
                        this.arvores_binarias.get(i).insert(no_atual);
                    }
                    return "Elemento cadastrado com sucesso na tabela de " + this.nome;
                }
            }
            return "Nao eh permitido cadastrar elementos com a chave possuindo um tipo diferente da chave primaria";
        }
        return "Ja existe um elemento no banco com o valor de uma das colunas igual a o valor do novo elemento";
    }

    /*
    Metodo responsavel por verificar se o elemento a ser inserido na tabela possui algum valor de suas colunas 
    igual ao de outro elemento ja existente no vetor de elementos. Retorna true caso exista e false caso nao exista.
     */
    private boolean contemValorDaColuna(E elemento, ArrayList<E> vetor_de_elementos) {
        Class<?> element_class = elemento.getClass();
        Field[] nome_colunas = element_class.getDeclaredFields();
        try {
            for (int i = 0; i < vetor_de_elementos.size(); i++) {
                Class<?> elemento_atual = vetor_de_elementos.get(i).getClass();
                /*
            Comparando os valores de cada coluna dos elementos ja existentes na tabela com as colunas 
            do elemento a ser adicionado
                 */
                for (int y = 0; y < nome_colunas.length; y++) {
                    //Pegando valores da coluna do elemento atual
                    Field field_elemento_atual = elemento_atual.getDeclaredField(nome_colunas[y].getName());
                    field_elemento_atual.setAccessible(true);
                    String valor_coluna_elemento_atual = field_elemento_atual.get(vetor_de_elementos.get(i)).toString();
                    //Pegando valores da coluna do elemento a ser adicionado
                    Field field_elemento = element_class.getDeclaredField(nome_colunas[y].getName());
                    field_elemento.setAccessible(true);
                    String valor_coluna_elemento_novo = field_elemento.get(elemento).toString();
                    /*
                Verificando se a coluna atual do novo elemento a ser adicionado e igual a do elemento ja 
                existente na tabela
                     */
                    if (valor_coluna_elemento_atual.equals(valor_coluna_elemento_novo)) {
                        return true;
                    }
                }

            }
        } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException ex) {
        }

        return false;
    }

    // Caso o usuario queira buscar por um tipo que a tabela nao contem, sera retornada uma excessao
    public BinaryNodeSearchTree buscarElemento(Chave<E> chave) throws InvalidNodeException, EmptyTreeException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        if (this.vetor_de_tipos.contains(chave.getTipo())) {
            BinarySearchTree arvoreAtual = this.arvores_binarias.get(this.vetor_de_tipos.indexOf(chave.getTipo()));
            return arvoreAtual.find_recursivo(chave);
        } else {
            BinarySearchTree<Chave<E>, E> nova_arvore = new BinarySearchTree<>();
            for (int i = 0; i < this.vetor_de_elementos.size(); i++) {
                E elementoAtual = this.vetor_de_elementos.get(i);
                Chave<E> novaChave = new Chave<>(chave.getTipo(), elementoAtual);
                BinaryNodeSearchTree<Chave<E>, E> novo_no = new BinaryNodeSearchTree<>(novaChave, this.vetor_de_elementos.get(i));
                nova_arvore.insert(novo_no);
            }
            this.vetor_de_tipos.add(chave.getTipo());
            this.arvores_binarias.add(nova_arvore);
            return nova_arvore.find_recursivo(chave);
        }
    }

    public void atualizarElemento(E antigo_elemento, E novo_elemento) throws InvalidNodeException {
        int elemento_atualizado = this.vetor_de_elementos.indexOf(antigo_elemento);
        if (elemento_atualizado != -1) {
            //Verificando se o elemento a ser inserido nao contem o valor de alguma de suas colunas igual ao de outro elemento existente
            ArrayList<E> vetor_copia = (ArrayList<E>) this.vetor_de_elementos.clone();
            vetor_copia.remove(elemento_atualizado);
            boolean contemValorDaColuna = this.contemValorDaColuna(novo_elemento, vetor_copia);
            if (!contemValorDaColuna) {
                this.vetor_de_elementos.set(elemento_atualizado, novo_elemento);
                for (int i = 0; i < this.arvores_binarias.size(); i++) {
                    BinarySearchTree nova_arvore = new BinarySearchTree();
                    for (int y = 0; y < this.vetor_de_elementos.size(); y++) {
                        try {
                            Chave nova_chave = new Chave(this.vetor_de_tipos.get(i), this.vetor_de_elementos.get(y));
                            BinaryNodeSearchTree node = new BinaryNodeSearchTree(nova_chave, this.vetor_de_elementos.get(y));
                            nova_arvore.insert(node);
                        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ex) {}
                    }
                    this.arvores_binarias.set(i, nova_arvore);
                }
            } else {
                throw new InvalidNodeException("Ja existe um elemento no banco com o valor de uma das colunas igual a o valor do novo elemento");
            }
        } else {
            throw new InvalidNodeException("O no a ser atualizado nao existe");
        }
    }

    public String mostrarColunasChaves() {
        StringBuilder construtor = new StringBuilder();
        construtor.append("---------------------------Tabela da chave primaria(").append(this.vetor_de_tipos.get(0)).append(")----------------------\n");
        construtor.append(this.listarColuna(this.arvores_binarias.get(0))).append("\n");
        for (int i = 1; i < this.arvores_binarias.size(); i++) {
            construtor.append("---------------------------Tabela da chave (").append(this.vetor_de_tipos.get(i)).append(")----------------------\n");
            construtor.append(this.listarColuna(this.arvores_binarias.get(i))).append("\n");
        }
        return construtor.toString();
    }

    private String listarColuna(BinarySearchTree<Chave<E>, E> coluna) {
        try {
            int tamanhoDoBuffer = 150;
            StringBuilder construtor = new StringBuilder();
            for (int i = 0; i < tamanhoDoBuffer; i++) {
                construtor.append(" ");
            }

            Iterator<BinaryNodeSearchTree<Chave<E>, E>> iterator = coluna.iterator();
            //Formatando previamente o elemento raiz para evitar sobreposicao de elementos no console
            Chave chave_nao_formatada = coluna.root().getChave();

            String complete_tree = "";
            Queue<ArrayList<Integer>> filaDePosicoes = new LinkedList<>();
            int quantidadeDeNosNivel = 1;

            String chave_formatada = formata_nome(chave_nao_formatada.getNome());
            int meioDaPalavra = ((chave_formatada.length()) / 2) - 1;

            int posicaoInicioRaiz = (tamanhoDoBuffer / 2) - ((meioDaPalavra + 1) - 1);
            int posicaoFimRaiz = ((tamanhoDoBuffer / 2) + (chave_formatada.length() - (meioDaPalavra + 1)) + 1);
            ArrayList<Integer> posicoes = new ArrayList<>();
            posicoes.add(posicaoInicioRaiz);
            posicoes.add(posicaoFimRaiz);
            filaDePosicoes.add(posicoes);

            while (!filaDePosicoes.isEmpty()) {
                int posicaoDaPalavra = 0;
                //Pegando todos os nos do nivel atual para serem posteriormente inseridos na linha
                ArrayList<BinaryNodeSearchTree<Chave<E>, E>> nos_atuais = new ArrayList<>();
                ArrayList<ArrayList<Integer>> posicoesAtuais = new ArrayList<>();
                for (int i = 0; i < quantidadeDeNosNivel; i++) {
                    BinaryNodeSearchTree<Chave<E>, E> no_atual = iterator.next();

                    nos_atuais.add(no_atual);
                    posicoesAtuais.add(filaDePosicoes.poll());
                }

                for (int i = 0; i < nos_atuais.size(); i++) {
                    if (nos_atuais.get(i).getChave().getNome().equals(coluna.root().getChave().getNome())) {
                        for (int y = posicoesAtuais.get(i).get(0); y < posicoesAtuais.get(i).get(1); y++) {
                            construtor.setCharAt(y, chave_formatada.charAt(posicaoDaPalavra++));
                        }
                        posicaoDaPalavra = 0;
                    } else {
                        for (int y = posicoesAtuais.get(i).get(0); y < posicoesAtuais.get(i).get(1); y++) {
                            construtor.setCharAt(y, nos_atuais.get(i).getChave().getNome().charAt(posicaoDaPalavra++));
                        }
                        posicaoDaPalavra = 0;
                    }
                }
                construtor.append("\n");

                quantidadeDeNosNivel = 0;
                for (int i = 0; i < nos_atuais.size(); i++) {
                    List<BinaryNodeSearchTree<Chave<E>, E>> elementoVizinho = (List<BinaryNodeSearchTree<Chave<E>, E>>) coluna.children(nos_atuais.get(i));
                    quantidadeDeNosNivel += elementoVizinho.size();
                    for (int y = 0; y < elementoVizinho.size(); y++) {
                        int tamanhoDaPalavraFilhoAtual = elementoVizinho.get(y).getChave().getNome().length();
                        if (nos_atuais.get(i).getEsquerda() != null && nos_atuais.get(i).getEsquerda().equals(elementoVizinho.get(y))) {
                            int posicaoFimFilhoEsquerdo = posicoesAtuais.get(i).get(0) - 1;
                            int posicaoInicioFilhoEsquerdo = (posicaoFimFilhoEsquerdo - (tamanhoDaPalavraFilhoAtual));
                            ArrayList<Integer> posicoes_filho = new ArrayList<>();
                            posicoes_filho.add(posicaoInicioFilhoEsquerdo);
                            posicoes_filho.add(posicaoFimFilhoEsquerdo);
                            filaDePosicoes.add(posicoes_filho);
                        }
                        if (nos_atuais.get(i).getDireita() != null && nos_atuais.get(i).getDireita().equals(elementoVizinho.get(y))) {
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
        final Tabela<?> other = (Tabela<?>) obj;
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
