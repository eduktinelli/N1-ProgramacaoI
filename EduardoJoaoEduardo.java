import java.util.Scanner;
import java.util.ArrayList;


class Aluno {
    private String nome;
    private int ID;
    private int N1;
    private int N2;

//Construtor do objeto

    public Aluno(String nome, int ID)
    {
     this.nome = nome;
     this.ID = ID;
    }

    public Notas(int N1, int N2)
    {
     this.N1 = N1;
     this.N2 = N2;
    }



//Get's das variaveis

    public String getNome()
    {
        return nome;
    }

    public int getID()
    {
        return ID;
    }

    public int getN1();
    {
        return N1;
    }

    public int getN2()
    {
        return N2;
    }

//Set's das variaveis

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setID(int ID)
    {
     this.ID = ID;
    }

    public void setN1(int N1)
    {
        this.N1 = N1;
    }

    public void setN2(int N2)   
    {
        this.N2 = N2;
    }

}

public class EduardoJoaoEduardo
{
    public static void main(String[] args)
    {

        ArrayList< Aluno > alunos = new ArrayList<>();

        Scanner teclado = new Scanner(System.in); 


        do {
            System.out.println("\nMENU");
            System.out.println("1 - Adicionar Aluno Novo");
            System.out.println("2 - Cadastrar Notas");
            System.out.println("3 - Listar Todos os Alunos");
            System.out.println("4 - Buscar um Aluno pela Matricula");
            System.out.println("5 - Identificar o Aluno com a Maior Média Aritmética");
            System.out.println("6 - Alterar as Notas de um Aluno");
            System.out.println("7 - Remover um Aluno");
            System.out.println("0 - Sair");
            System.out.print("Opção : ");  

            opcao = Integer.parseInt( teclado.nextLine() );

            switch (opcao)
            {
                case 1: 
                {

                }
            }

    }
}