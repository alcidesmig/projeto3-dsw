package br.ufscar.dc.dsw


import grails.rest.*

@Resource(uri = '/teatro', readOnly = false, formats = ['json', 'xml'])
class Teatro extends User {
    static constraints = {
         email blank: false 
         cnpj blank: false
         nome blank: false
         cidade blank: false
    }

    java.lang.Long id;
    String email;
    String cnpj;
    String nome;
    String cidade;
}