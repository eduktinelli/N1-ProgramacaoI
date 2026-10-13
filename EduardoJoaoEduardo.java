// Alunos:
// Eduardo Kaua Tinelli
// Joao Eduardo De Oliveira Nascimento

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

//Calcula a média aritmética das duas notas

    public double getMedia()
    {
        return (nota1 + nota2) / 2;
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
            opcao = lerInteiro(teclado, "Opção : ");

            switch (opcao)
            {
                case 1:
                {
                    // Cadastrar um novo aluno, sem permitir matrícula repetida
                    int matricula = lerInteiro(teclado, "Matrícula: ");

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
                    int matricula = lerInteiro(teclado, "Matrícula do aluno: ");

                    Aluno aluno = buscarPorMatricula(matricula);

                    if (aluno == null)
                    {
                        System.out.println("Aluno não encontrado.");
                    }
                    else
                    {
                        aluno.setNota1( lerNota(teclado, "Nota 1: ") );
                        aluno.setNota2( lerNota(teclado, "Nota 2: ") );

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
                    int matricula = lerInteiro(teclado, "Matrícula: ");

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
                {
                    // Encontrar o aluno com a maior média aritmética
                    if (alunos.isEmpty())
                    {
                        System.out.println("Nenhum aluno cadastrado.");
                    }
                    else
                    {
                        Aluno melhorAluno = alunos.get(0);

                        for (Aluno aluno : alunos)
                        {
                            if (aluno.getMedia() > melhorAluno.getMedia())
                            {
                                melhorAluno = aluno;
                            }
                        }

                        System.out.println("Aluno com a maior média: " + melhorAluno.getNome()
                                + " | Média: " + String.format("%.2f", melhorAluno.getMedia()));
                    }
                    break;
                }

                case 6:
                {
                    // Alterar as notas de um aluno localizado pela matrícula
                    int matricula = lerInteiro(teclado, "Matrícula do aluno: ");

                    Aluno aluno = buscarPorMatricula(matricula);

                    if (aluno == null)
                    {
                        System.out.println("Aluno não encontrado.");
                    }
                    else
                    {
                        System.out.println("Notas atuais de " + aluno.getNome()
                                + ": Nota 1 = " + aluno.getNota1()
                                + " | Nota 2 = " + aluno.getNota2());

                        aluno.setNota1( lerNota(teclado, "Nova Nota 1: ") );
                        aluno.setNota2( lerNota(teclado, "Nova Nota 2: ") );

                        System.out.println("Notas alteradas com sucesso!");
                    }
                    break;
                }

                case 7:
                {
                    // Remover um aluno localizado pela matrícula
                    int matricula = lerInteiro(teclado, "Matrícula do aluno: ");

                    Aluno aluno = buscarPorMatricula(matricula);

                    if (aluno == null)
                    {
                        System.out.println("Aluno não encontrado.");
                    }
                    else
                    {
                        alunos.remove(aluno);
                        System.out.println("Aluno " + aluno.getNome() + " removido com sucesso!");
                    }
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
                + " | Nota 2: " + aluno.getNota2()
                + " | Média: " + String.format("%.2f", aluno.getMedia()));
    }

    // Lê um número inteiro do teclado, repetindo a pergunta até o valor ser válido
    static int lerInteiro(Scanner teclado, String mensagem)
    {
        while (true)
        {
            System.out.print(mensagem);

            try
            {
                return Integer.parseInt( teclado.nextLine().trim() );
            }
            catch (NumberFormatException e)
            {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
    }

    // Lê uma nota de 0 a 10 do teclado, aceitando vírgula ou ponto como separador decimal
    static double lerNota(Scanner teclado, String mensagem)
    {
        while (true)
        {
            System.out.print(mensagem);

            try
            {
                double nota = Double.parseDouble( teclado.nextLine().trim().replace(',', '.') );

                if (nota >= 0 && nota <= 10)
                {
                    return nota;
                }
                System.out.println("A nota deve estar entre 0 e 10.");
            }
            catch (NumberFormatException e)
            {
                System.out.println("Valor inválido. Digite um número.");
            }
        }
    }
}
