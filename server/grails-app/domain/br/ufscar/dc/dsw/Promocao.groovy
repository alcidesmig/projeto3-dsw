package br.ufscar.dc.dsw


import grails.rest.*

@Resource(uri='/promocao', readOnly = false, formats = ['json', 'xml'])
class Promocao {
    Site site;
    Teatro teatro;
    String nome;
    Double preco;
    String dia_hora;
}