/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.EmpresaDeAutomoveis;

/**
 *
 * @author Matheus Nunes
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SistemaDeVeiculos sistema = new SistemaDeVeiculos();
        //Cadastrando categorias
        Categoria scooter = new Categoria("scooter");
        Categoria naked = new Categoria("naked");
        Categoria sport = new Categoria("sport");
        Categoria hatch = new Categoria("hatch");
        Categoria sedan = new Categoria("sedan");
        Categoria suv = new Categoria("suv");
        //Cadastrando Compradores
        Comprador jose = new Comprador("Jose", "12345");
        Comprador matheus = new Comprador("Matheus", "54321");

        System.out.println("-----------------------------------Cadastrando Motocicletas--------------------------------------------------------");
        System.out.println(sistema.cadastrarMotocicleta(new Motocicleta("palpatine", 2000, 222, scooter)));
        System.out.println(sistema.cadastrarMotocicleta(new Motocicleta("jedi", 2000, 132, scooter)));
        System.out.println(sistema.cadastrarMotocicleta(new Motocicleta("padawan", 2000, 333, naked)));
        System.out.println(sistema.cadastrarMotocicleta(new Motocicleta("anakin", 2000, 153, naked)));
        System.out.println(sistema.cadastrarMotocicleta(new Motocicleta("han", 2000, 400, sport)));
        System.out.println(sistema.cadastrarMotocicleta(new Motocicleta("luke", 2000, 999, sport)));
        System.out.println("-----------------------------------Cadastrando Automoveis--------------------------------------------------------");
        System.out.println(sistema.cadastrarAutomovel(new Automovel("darth", 2000, 100, hatch)));
        System.out.println(sistema.cadastrarAutomovel(new Automovel("yoda", 2000, 450, hatch)));
        System.out.println(sistema.cadastrarAutomovel(new Automovel("lea", 2000, 441, sedan)));
        System.out.println(sistema.cadastrarAutomovel(new Automovel("r2d2", 2000, 2233, sedan)));
        System.out.println(sistema.cadastrarAutomovel(new Automovel("c3po", 2000, 188, suv)));
        System.out.println(sistema.cadastrarAutomovel(new Automovel("chew", 2000, 175, suv)));
        System.out.println("----------------------------------Cadastrando Compradores-------------------------------------------------------");
        System.out.println(sistema.cadastrarComprador(jose));
        System.out.println(sistema.cadastrarComprador(matheus));
        System.out.println("----------------------------------Realizando vendas de Motocicletas---------------------------------------------");
        System.out.println(sistema.venderMotocicleta(jose, new Motocicleta(null, -1, 132, scooter)));
        System.out.println(sistema.venderMotocicleta(jose, new Motocicleta(null, -1, 222, scooter)));
        System.out.println(sistema.venderMotocicleta(matheus, new Motocicleta(null, -1, 400, sport)));
        System.out.println(sistema.venderMotocicleta(matheus, new Motocicleta(null, -1, 153, naked)));
        System.out.println("----------------------------------Realizando vendas de Automoveis---------------------------------------------");
        System.out.println(sistema.venderAutomovel(jose, new Automovel(null, -1, 100, hatch)));
        System.out.println(sistema.venderAutomovel(jose, new Automovel(null, -1, 450, hatch)));
        System.out.println(sistema.venderAutomovel(matheus, new Automovel(null, -1, 2233, sedan)));
        System.out.println(sistema.venderAutomovel(matheus, new Automovel(null, -1, 188, suv)));
        System.out.println("----------------------------------Consultando produtos pelo chassi----------------------------------------------");
        System.out.println(sistema.consultarVeiculoChassi(333));
        System.out.println(sistema.consultarVeiculoChassi(100));
        System.out.println("----------------------------------Consultando produtos pelo cpf do comprador----------------------------------------------");
        System.out.println("----------------------------------------Automoveis De Jose--------------------------------------------------------------------");
        System.out.println(sistema.consultarVeiculosCpf("12345"));
        System.out.println("----------------------------------------Automoveis De Matheus--------------------------------------------------------------------");
        System.out.println(sistema.consultarVeiculosCpf("54321"));
        System.out.println("-----------------------------------Listando motocicleta disponiveis para venda------------------------------------------------------");
        System.out.println(sistema.listarMotocicletasDisponiveis());
        System.out.println("-----------------------------------Listando motocicleta ja vendidas------------------------------------------------------");
        System.out.println(sistema.listarMotocicletasVendidas());
        System.out.println("-----------------------------------Listando Autmoveis disponiveis para venda------------------------------------------------------");
        System.out.println(sistema.listarAutomoveisDisponiveis());
        System.out.println("-----------------------------------Listando Automoveis ja vendidas------------------------------------------------------");
        System.out.println(sistema.listarAutomoveisVendidas());
    }

}
