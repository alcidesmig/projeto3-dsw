package br.ufscar.dc.dsw


import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_TEATRO', 'ROLE_ADMIN'])
class PromocaoController extends RestfulController {
    static responseFormats = ['json', 'xml']
    PromocaoController() {
        super(Promocao)
    }

    @Secured(['ROLE_TEATRO', 'ROLE_SITE', 'ROLE_ADMIN', 'ROLE_GUEST'])
    index() {
        super.index();
    }

}
