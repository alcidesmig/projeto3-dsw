package br.ufscar.dc.dsw


import grails.rest.*

@Resource(uri='/promocao', readOnly = false, formats = ['json', 'xml'])
class Promocao {
    int id;
    Site site;
    Teatro teatro;
    String nome;
    Double preco;
    Date dia_hora;
}