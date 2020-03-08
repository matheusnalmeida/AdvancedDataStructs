/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.calculating_time;

import estruturadedadosavancada.EmptyTreeException;
import estruturadedadosavancada.InvalidNodeException;

/**
 *
 * @author Matheus Nunes
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidNodeException, EmptyTreeException {
        Calculadora_De_Tempo calculadora = new Calculadora_De_Tempo();
        calculadora.gerandoArvore();
        
        System.out.println(calculadora.calculaTempoDeBusca());
    }
    
}
