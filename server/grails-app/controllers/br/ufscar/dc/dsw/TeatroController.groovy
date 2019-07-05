package br.ufscar.dc.dsw

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class TeatroController {

    TeatroService teatroService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    
    @Secured(['ROLE_ANONYMOUS', 'ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond teatroService.list(params), model:[teatroCount: teatroService.count()]
    }

    def show(Long id) {
        respond teatroService.get(id)
    }

    def save(Teatro teatro) {
        if (teatro == null) {
            render status: NOT_FOUND
            return
        }

        try {
            teatroService.save(teatro)
            Role role = Role.findByAuthority('ROLE_TEATRO') // recupera o role criado no Bootstrap
            UserRole.create(site, role, true)
        } catch (ValidationException e) {
            respond teatro.errors, view:'create'
            return
        }

        respond teatro, [status: CREATED, view:"show"]
    }

    def update(Teatro teatro) {
        if (teatro == null) {
            render status: NOT_FOUND
            return
        }

        try {
            teatroService.save(teatro)
        } catch (ValidationException e) {
            respond teatro.errors, view:'edit'
            return
        }

        respond teatro, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        teatroService.delete(id)

        render status: NO_CONTENT
    }
}
