package com.betrybe.sistemadevotacao;

public class PessoaCandidata extends Pessoa {
  public int numero;
  public int votos;

  /**
   * Construtor.
   * @param nome nome
   * @param numero indenficador para voto.
   */
  public PessoaCandidata(String nome, int numero) {
    this.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }

  public void receberVoto() {
    this.votos += 1;
  }
}
