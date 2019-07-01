package br.ufscar.dc.dsw


import grails.rest.*

@Resource(uri='/promocao', readOnly = false, formats = ['json', 'xml'])
class Promocao {
    static constraints = {
         nome blank: false 
         site nullable: false
         teatro nullable: false
         preco blank: false
         dia_hora blank: false
         preco min: 0.00
    }
    int id;
    Site site;
    Teatro teatro;
    String nome;
    Double preco;
    Date dia_hora;
}