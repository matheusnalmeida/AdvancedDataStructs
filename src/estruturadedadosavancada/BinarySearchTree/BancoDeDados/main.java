/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.BancoDeDados;

/**
 *
 * @author Matheus Nunes
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Criacao do banco de dados
        BancoDeDados bancoDeDados = new BancoDeDados();
        //Criando alguns elementos que serao adicionados nas suas respectivas tabelas
        Aluno a = new Aluno("matheus", 122, "02301213");
        Aluno a1 = new Aluno("aldo", 233, "02354553");
        Aluno a2 = new Aluno("erik", 333, "12356532");
        Cidade c = new Cidade(2, "aracaju", "ar");
        Cidade c1 = new Cidade(1, "bangkok", "bg");
        Cidade c2 = new Cidade(3, "londres", "ld");

        //Cadastrando tabelas
        System.out.println(bancoDeDados.criar_tabela(new Tabela<Aluno>("aluno")));
        System.out.println(bancoDeDados.criar_tabela(new Tabela<Cidade>("cidade")));

        //Cadastrando elementos nas suas respectivas tabelas
        System.out.println(bancoDeDados.inserir_elemento("aluno", "matricula", a));
        System.out.println(bancoDeDados.inserir_elemento("aluno", "matricula", a1));
        System.out.println(bancoDeDados.inserir_elemento("aluno", "matricula", a2));
        System.out.println(bancoDeDados.inserir_elemento("cidade", "id", c));
        System.out.println(bancoDeDados.inserir_elemento("cidade", "id", c1));
        System.out.println(bancoDeDados.inserir_elemento("cidade", "id", c2));

        //Buscando elemento nas respectivas tabelas pela chave primaria
        System.out.println("------------------------------Elementos buscados pela chavce primaria-------------------------------");
        System.out.println(bancoDeDados.buscar_elemento("aluno", "matricula", "122"));
        System.out.println(bancoDeDados.buscar_elemento("cidade", "id", "2"));

        //Buscando elemento nas respectivas tabelas por outras colunas
        System.out.println("------------------------------Elementos buscados por outras colunas-------------------------------");
        System.out.println(bancoDeDados.buscar_elemento("aluno", "cpf", "12356532"));
        System.out.println(bancoDeDados.buscar_elemento("aluno", "nome", "aldo"));
        System.out.println(bancoDeDados.buscar_elemento("cidade", "sigla", "bg"));
        System.out.println(bancoDeDados.buscar_elemento("cidade", "nome", "aracaju"));

        //Atualizando elementos nas tabelas
        Aluno novo_aluno = new Aluno("Rodrigo", 100, "123333123");
        Cidade cidade_nova = new Cidade(4, "azeiopa", "az");
        System.out.println(bancoDeDados.atualizar_elemento("aluno", a, novo_aluno));
        System.out.println(bancoDeDados.atualizar_elemento("cidade", c, cidade_nova));

        //Listando dados do banco de dados
        System.out.println("-------------------------------------Dadoa do banco de dados--------------------------------------------");
        System.out.println(bancoDeDados.listarMetadados());

    }

}
