package br.ufscar.dc.dsw

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class SiteController {

    SiteService siteService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_SITE', 'ROLE_TEATRO'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond siteService.list(params), model:[siteCount: siteService.count()]
    }

    def show(Long id) {
        respond siteService.get(id)
    }

    def save(Site site) {
        if (site == null) {
            render status: NOT_FOUND
            return
        }

        try {
            siteService.save(site)
            Role role = Role.findByAuthority('ROLE_SITE') // recupera o role criado no Bootstrap
            UserRole.create(site, role, true)
        } catch (ValidationException e) {
            respond site.errors, view:'create'
            return
        }

        respond site, [status: CREATED, view:"show"]
    }

    def update(Site site) {
        if (site == null) {
            render status: NOT_FOUND
            return
        }

        try {
            siteService.save(site)
        } catch (ValidationException e) {
            respond site.errors, view:'edit'
            return
        }

        respond site, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        siteService.delete(id)

        render status: NO_CONTENT
    }
}
