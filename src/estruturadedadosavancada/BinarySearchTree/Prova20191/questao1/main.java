/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.Prova20191.questao1;

import java.util.Scanner;

/**
 *
 * @author Matheus Nunes
 */
public class main {

    public static void main(String[] args) {
        SistemaDeSuspeitos sistema = new SistemaDeSuspeitos();
        //Criando alguns crimes
        Crime furto = new Crime("furto", 1);
        Crime roubo = new Crime("roubo", 2);
        Crime latrocinio = new Crime("latrocinio", 3);
        Crime receptacao = new Crime("receptacao", 4);
        Crime dano = new Crime("dano", 5);
        //Criando alguns Suspeitos que tbm podem ser Cumplices
        Suspeito joao = new Suspeito("joao",1);
        Suspeito pedro = new Suspeito("pedro",2);
        Suspeito lucas = new Suspeito("lucas",3);
        Suspeito ana = new Suspeito("ana",4);
        Suspeito ricardo = new Suspeito("ricardo",5);

        //Cadastrando crimes nos suspeitos
        joao.cadastrarCrime(furto);
        joao.cadastrarCrime(roubo);
        joao.cadastrarCrime(latrocinio);
        joao.cadastrarCrime(dano);
        pedro.cadastrarCrime(receptacao);
        lucas.cadastrarCrime(latrocinio);
        ana.cadastrarCrime(roubo);
        ricardo.cadastrarCrime(furto);
        //Cadastrando suspeitos
        System.out.println("Cadastrando suspeitos");
        System.out.println(sistema.cadastrarSuspeito(joao));
        System.out.println(sistema.cadastrarSuspeito(pedro));
        System.out.println(sistema.cadastrarSuspeito(lucas));
        System.out.println(sistema.cadastrarSuspeito(ana));
        System.out.println(sistema.cadastrarSuspeito(ricardo));
        //Adicionado cumplices
        System.out.println("Cadastrando cumplices");
        System.out.println(sistema.cadastrarCumplice(joao, pedro));
        System.out.println(sistema.cadastrarCumplice(joao, lucas));
        System.out.println(sistema.cadastrarCumplice(pedro, ana));
        System.out.println(sistema.cadastrarCumplice(pedro, ricardo));
        System.out.println(sistema.cadastrarCumplice(joao, ricardo));
        //Listando cumplices na ordem alfabetica
        System.out.println("Listando cumplices de um determinado suspeito na ordem alfabetica");
        System.out.println(sistema.listarCumplicesOrdenado(joao));
        //Listando crimes de um suspeito
        System.out.println("Listando crimes de um suspeito");
        System.out.println(sistema.listarCrimes(joao));
        //Listando suspeitos em comum
        System.out.println("Listando suspeitos em comum");
        System.out.println(sistema.listarCumplicesEmComum(joao, pedro));
        //Listando o alcance de um suspeito
        System.out.println("Listando os alcances de suspeitos");
        System.out.println(sistema.informarAlcance(joao, 2));
    }

}
