/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.calculating_time;

import estruturadedadosavancada.BinarySearchTree.BinaryNodeSearchTree;
import estruturadedadosavancada.BinarySearchTree.BinarySearchTree;
import estruturadedadosavancada.EmptyTreeException;
import estruturadedadosavancada.InvalidNodeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Matheus Nunes
 */
public class Calculadora_De_Tempo {
      BinarySearchTree<Integer,Integer> arvore;
      HashMap<Integer,Integer> valores_da_arvore;

    public Calculadora_De_Tempo() {
        this.arvore = new BinarySearchTree<>();
        this.valores_da_arvore = new HashMap<>();
    }
      
    
    public void gerandoArvore() throws InvalidNodeException{
        Random gerador = new Random();
        for(int i = 0; i < 2000000;i++){
            int numero_aleatorio = gerador.nextInt(10000000);
            if(!valores_da_arvore.containsKey(numero_aleatorio)){
                valores_da_arvore.put(numero_aleatorio, numero_aleatorio);
                this.arvore.insert(new BinaryNodeSearchTree<>(numero_aleatorio,numero_aleatorio));
            }else{
                while(valores_da_arvore.containsKey(numero_aleatorio)){
                    numero_aleatorio = gerador.nextInt(10000000);
                }
                this.arvore.insert(new BinaryNodeSearchTree<>(numero_aleatorio,numero_aleatorio));
                valores_da_arvore.put(numero_aleatorio, numero_aleatorio);                
            }
        }
    }
      
    public String calculaTempoDeBusca() throws InvalidNodeException, EmptyTreeException{
        Random gerador = new Random();
        //Inicialmente serao buscados 10 elementos existentes
        List<Integer> elementos_buscar = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            int numero_aleatorio = gerador.nextInt(10000000);
            if(this.valores_da_arvore.containsKey(numero_aleatorio)){
                elementos_buscar.add(numero_aleatorio);
            }else{
                while(!this.valores_da_arvore.containsKey(numero_aleatorio)){
                    numero_aleatorio = gerador.nextInt(10000000);
                }
                elementos_buscar.add(numero_aleatorio);
            }
        }
        
        //Buscando os elementos usando iterativo
        long media_tempo_iterativo = 0;
        for(int i = 0;i < elementos_buscar.size();i++){
            long tempo_inicio_iterativo = System.nanoTime();
            this.arvore.find_iterativo(elementos_buscar.get(i));
            long tempo_fim_iterativo = System.nanoTime();
            media_tempo_iterativo += (tempo_fim_iterativo-tempo_inicio_iterativo);
        }
        
        media_tempo_iterativo = (media_tempo_iterativo/elementos_buscar.size());
        
        //Buscando os elementos usando recursivo
        long media_tempo_recursivo = 0;
        for(int i = 0;i < elementos_buscar.size();i++){
            long tempo_inicio_recursivo = System.nanoTime();
            this.arvore.find_recursivo(elementos_buscar.get(i));
            long tempo_fim_recursivo = System.nanoTime();
            media_tempo_recursivo += (tempo_fim_recursivo-tempo_inicio_recursivo);
        }
        
        media_tempo_recursivo = (media_tempo_recursivo/elementos_buscar.size());
        
        return "O tempo medio de busca da versao iterativa foi de " + media_tempo_iterativo + " nanosegundos.\n" + "O tempo medio"
                + " de busca da versao recursiva foi de " + media_tempo_recursivo + " nanosegundos.";
    }
}
