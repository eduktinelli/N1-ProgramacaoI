// Alunos:
// NOME COMPLETO DO ALUNO 1
// NOME COMPLETO DO ALUNO 2

import java.util.Scanner;
import java.util.ArrayList;


// Classe que representa um aluno da escola
class Aluno {
    private int matricula;
    private String nome;
    private double nota1;
    private double nota2;

//Construtor do objeto (as notas começam em 0 até serem cadastradas)

    public Aluno(int matricula, String nome)
    {
        this.matricula = matricula;
        this.nome = nome;
        this.nota1 = 0;
        this.nota2 = 0;
    }

//Get's das variaveis

    public int getMatricula()
    {
        return matricula;
    }

    public String getNome()
    {
        return nome;
    }

    public double getNota1()
    {
        return nota1;
    }

    public double getNota2()
    {
        return nota2;
    }

//Set's das variaveis

    public void setMatricula(int matricula)
    {
        this.matricula = matricula;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setNota1(double nota1)
    {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2)
    {
        this.nota2 = nota2;
    }

}

public class EduardoJoaoEduardo
{
    // Lista com todos os alunos cadastrados
    static ArrayList<Aluno> alunos = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int opcao;

        // Mostra o menu até o usuário escolher 0
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
                    // Cadastrar um novo aluno, sem permitir matrícula repetida
                    System.out.print("Matrícula: ");
                    int matricula = Integer.parseInt( teclado.nextLine() );

                    if (buscarPorMatricula(matricula) != null)
                    {
                        System.out.println("Já existe um aluno com essa matrícula.");
                    }
                    else
                    {
                        System.out.print("Nome: ");
                        String nome = teclado.nextLine();

                        alunos.add(new Aluno(matricula, nome));
                        System.out.println("Aluno cadastrado com sucesso!");
                    }
                    break;
                }

                case 2:
                {
                    // Cadastrar as duas notas de um aluno já cadastrado
                    System.out.print("Matrícula do aluno: ");
                    int matricula = Integer.parseInt( teclado.nextLine() );

                    Aluno aluno = buscarPorMatricula(matricula);

                    if (aluno == null)
                    {
                        System.out.println("Aluno não encontrado.");
                    }
                    else
                    {
                        System.out.print("Nota 1: ");
                        aluno.setNota1( Double.parseDouble( teclado.nextLine() ) );

                        System.out.print("Nota 2: ");
                        aluno.setNota2( Double.parseDouble( teclado.nextLine() ) );

                        System.out.println("Notas cadastradas para " + aluno.getNome() + ".");
                    }
                    break;
                }

                case 3:
                {
                    // Listar todos os alunos cadastrados
                    if (alunos.isEmpty())
                    {
                        System.out.println("Nenhum aluno cadastrado.");
                    }
                    else
                    {
                        for (Aluno aluno : alunos)
                        {
                            exibirAluno(aluno);
                        }
                    }
                    break;
                }

                case 4:
                {
                    // Buscar um aluno pela matrícula e mostrar os dados dele
                    System.out.print("Matrícula: ");
                    int matricula = Integer.parseInt( teclado.nextLine() );

                    Aluno aluno = buscarPorMatricula(matricula);

                    if (aluno == null)
                    {
                        System.out.println("Aluno não encontrado.");
                    }
                    else
                    {
                        exibirAluno(aluno);
                    }
                    break;
                }

                case 5:
                case 6:
                case 7:
                {
                    // Opções ainda não implementadas
                    System.out.println("Ainda não implementado.");
                    break;
                }

                case 0:
                {
                    System.out.println("Encerrando o programa...");
                    break;
                }

                default:
                {
                    System.out.println("Opção inválida.");
                }
            }

        } while (opcao != 0);

        teclado.close();
    }

    // Percorre a lista procurando o aluno com a matrícula informada.
    // Retorna o aluno encontrado ou null se não existir.
    static Aluno buscarPorMatricula(int matricula)
    {
        for (Aluno aluno : alunos)
        {
            if (aluno.getMatricula() == matricula)
            {
                return aluno;
            }
        }
        return null;
    }

    // Mostra na tela os dados de um aluno
    static void exibirAluno(Aluno aluno)
    {
        System.out.println("Matrícula: " + aluno.getMatricula()
                + " | Nome: " + aluno.getNome()
                + " | Nota 1: " + aluno.getNota1()
                + " | Nota 2: " + aluno.getNota2());
    }
}
