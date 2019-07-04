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

    @Secured(['ROLE_ANONYMOUS', 'ROLE_TEATRO', 'ROLE_ADMIN', 'ROLE_SITE'])
    def index() {
        super.index();
    }

    /*
    @Transactional
    def save(Promocao promocao) {
        def query = Promocao.where{
                (dia_hora == promocao.dia_hora && site == promocao.site) ||
                (dia_hora == promocao.dia_hora && teatro == promocao.teatro) 
        };
        if(query.find() != NULL) {
            promocao.save();
        } else {
            <retornar erro>; 
        }
    }
    */

}
