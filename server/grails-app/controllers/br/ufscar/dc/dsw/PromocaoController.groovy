package br.ufscar.dc.dsw

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.converters.JSON

@Secured(['ROLE_ANONYMOUS'])
class PromocaoController {

    PromocaoService promocaoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ANONYMOUS', 'ROLE_TEATRO', 'ROLE_ADMIN', 'ROLE_SITE'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond promocaoService.list(params), model:[promocaoCount: promocaoService.count()]
    }

    def show(Long id) {
        respond promocaoService.get(id)
    }

    def save(Promocao promocao) {
        if (promocao == null) {
            render status: NOT_FOUND
            return
        }

        try {
            def query = Promocao.where{
                (dia_hora == promocao.dia_hora && site == promocao.site) ||
                (dia_hora == promocao.dia_hora && teatro == promocao.teatro) 
            };
            if(query.find() != NULL) {
                promocaoService.save(promocao)
            } else {
                def error = [error: 'Erro: conflito data']
                render(status:500,text:(error as JSON).toString(),contentType: 'application/json')
            }
        } catch (ValidationException e) {
            respond promocao.errors, view:'create'
            return
        }

        respond promocao, [status: CREATED, view:"show"]
    }

    def update(Promocao promocao) {
        if (promocao == null) {
            render status: NOT_FOUND
            return
        }

        try {
            promocaoService.save(promocao)
        } catch (ValidationException e) {
            respond promocao.errors, view:'edit'
            return
        }

        respond promocao, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        promocaoService.delete(id)

        render status: NO_CONTENT
    }
}
