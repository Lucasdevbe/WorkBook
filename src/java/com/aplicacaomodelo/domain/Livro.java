/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.domain;


/**
 *
 * @author silva
 */
public class Livro extends EntidadeDominio {

    public static void add(Livro p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String nome;
    private String autor;
    private String editora;
    private int ano;
    private String descricao;
    private String categoria;
    private int estoque;
    private double preco_custo;
    private double preco_final;

    

    public Livro() {

    }

    public Livro(int i, String nome, String autor, String editora, int ano , String descricao, String categoria) {

        setId(i);
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.descricao = descricao;
        this.categoria = categoria;
    }
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the editora
     */
    public String getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }
public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(double preco_custo) {
        this.preco_custo = preco_custo;
    }

    public double getPreco_final() {
        return preco_final;
    }

    public void setPreco_final(double preco_final) {
        this.preco_final = preco_final;
    }
}