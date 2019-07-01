package br.ufscar.dc.dsw


import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class TeatroController extends RestfulController {
    static responseFormats = ['json', 'xml']
    TeatroController() {
        super(Teatro)
    }

    @Secured(['ROLE_GUEST', 'ROLE_ADMIN', 'ROLE_SITE'])
    index() {
        super.index();
    }
}
