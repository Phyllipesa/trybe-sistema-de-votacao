package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
/**
 * GerenciamentoVotacao.
 */

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  /**
   * Construtor da classe GerenciamentoVotacao.
   * Inicializa as listas de pessoas candidatas, pessoas eleitoras
   * e cpfs computados.
   */
  public GerenciamentoVotacao() {
    this.pessoasCandidatas = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
    this.cpfsComputados = new ArrayList<>();
  }

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata pessoa : pessoasCandidatas) {
      if (pessoa.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        break;
      }
    }

    PessoaCandidata candidata = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(candidata);
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora pessoa : pessoasEleitoras) {
      if (pessoa.getCpf() == cpf) {
        System.out.println("Pessoa eleitora já cadastrada!");
        break;
      }
    }

    PessoaEleitora eleitora = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(eleitora);
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (String cpf : cpfsComputados) {
      if (cpfPessoaEleitora == cpf) {
        System.out.println("Pessoa eleitora já votou!");
        break;
      }
    }

    for (PessoaCandidata candidata : pessoasCandidatas) {
      if (candidata.getNumero() == numeroPessoaCandidata) {
        candidata.receberVoto();
        cpfsComputados.add(cpfPessoaEleitora);
      }
    }
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.size() == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    }

    int totalDeVotos = cpfsComputados.size();

    for (PessoaCandidata pessoa : pessoasCandidatas) {
      String nome = pessoa.getNome();
      int votos = pessoa.getVotos();
      double porcentagem = Math.round((votos * 100.0) / totalDeVotos);

      System.out.println("Nome: " + nome + " - " + votos + " votos ( " + porcentagem + "% )");
    }

    System.out.println("Total de votos: " + totalDeVotos);
  }
}
