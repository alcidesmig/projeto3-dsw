package br.ufscar.dc.dsw


import grails.rest.*

@Resource(uri = '/site', readOnly = false, formats = ['json', 'xml'])
class Site {
    static constraints = {
         email blank: false 
         senha blank: false
         url blank: false
         nome blank: false
         telefone blank: false
    }
    int id;
    String email;
    String senha;
    String url;
    String nome;
    String telefone;
}
