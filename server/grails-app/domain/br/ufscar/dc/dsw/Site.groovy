package br.ufscar.dc.dsw


import grails.rest.*

@Resource(uri = '/site', readOnly = false, formats = ['json', 'xml'])
class Site extends User{
    static constraints = {
         email blank: false, unique: true
         url blank: false
         nome blank: false
         telefone blank: false
         id unique: true
    }
    String email;
    String url;
    String nome;
    String telefone;
}
