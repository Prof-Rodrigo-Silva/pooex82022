package classe.excutavel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classe.modelo.Aluno;
import classe.modelo.Disciplina;

public class ClasseExecutavel {

	public static void main(String[] args) {
		

		List<Aluno> alunos = new ArrayList<Aluno>();
		
		int nroAluno = Integer.parseInt(JOptionPane.showInputDialog("Qual o nro de alunos?"));
		int nroDisciplinas = Integer.parseInt(JOptionPane.showInputDialog("Qual o nro de disciplinas por aluno?"));
		
		
		for(int i = 0; i < nroAluno; i++) {
			String nome = JOptionPane.showInputDialog("Qual o nome do aluno? ");
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Qual idade? "));
			long cpf = Long.parseLong(JOptionPane.showInputDialog("Qual o CPF? "));
			String dataMatricula = JOptionPane.showInputDialog("Qual a data de matrícula? ");
			String nomeEscola = JOptionPane.showInputDialog("Qual o nome da escola? ");
			String serieMatriculado = JOptionPane.showInputDialog("Qual a série? ");
			
			Aluno aluno = new Aluno(nome, idade, cpf, dataMatricula, nomeEscola, serieMatriculado);
			
			for(int j = 0; j < nroDisciplinas; j++) {
				String nomeDisciplina = JOptionPane.showInputDialog("Nome da "+(j+1)+"º Disciplina?");
				//Disciplina disciplina = new Disciplina();
				//disciplina.setNomeDisciplina(nomeDisciplina);
				double[] notas = new double[4];
				for(int w = 0; w <= 3; w++) {
					double nota = Double.parseDouble(JOptionPane.showInputDialog((w+1)+"º Nota da Disciplina?"));
					notas[w] = nota;						
				}
				//disciplina.setNotas(notas);
				Disciplina disciplina = new Disciplina(nomeDisciplina, notas);
					
				aluno.getDisciplinas().add(disciplina);
			}
			alunos.add(aluno);
		}
		System.out.println("------------LISTA DE ALUNOS------------");
		for(Aluno aluno : alunos) {
			System.out.println("------------ALUNO------------");
			System.out.println("Nome do aluno: "+aluno.getNome());
			System.out.println("Idade do aluno: "+aluno.getIdade());
			System.out.println("CPF do aluno: "+aluno.getNumCPF());
			System.out.println("Data de matricula do aluno: "+aluno.getDataMatricula());
			System.out.println("Nome da escola: "+aluno.getNomeEscola());
			System.out.println("Série do aluno: "+aluno.getSerieMatriculado());
			System.out.println("Média Geral: "+aluno.CalculaMediaGeral());
			if(aluno.CalculaMediaGeral1()) {
				System.out.println("Aluno Aprovado!");
			}else {
				System.out.println("Aluno Reprovado!");
			}
			System.out.println("------------LISTA DE DISCIPLINAS------------");
			for(Disciplina disciplina : aluno.getDisciplinas()) {
				System.out.println("Disciplina: "+disciplina.getNomeDisciplina());
				System.out.println("Média da disciplina: "+disciplina.GetMediaNotas());
				for(int y = 0; y < disciplina.getNotas().length; y++) {
					System.out.println((y+1)+"º Nota: "+disciplina.getNotas()[y]);
					}
				System.out.println("--------------------------------------------");
				}
			}

	}

}
