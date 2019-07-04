package br.ufscar.dc.dsw


import grails.rest.*

@Resource(uri = '/site', readOnly = false, formats = ['json', 'xml'])
class Site extends User{
    static constraints = {
         email blank: false 
         url blank: false
         nome blank: false
         telefone blank: false
    }
    java.lang.Long id;
    String email;
    String url;
    String nome;
    String telefone;
}
