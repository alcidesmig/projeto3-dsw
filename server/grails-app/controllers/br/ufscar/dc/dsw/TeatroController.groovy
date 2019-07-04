package br.ufscar.dc.dsw


import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured
import grails.gorm.transactions.*

@Secured(['ROLE_ADMIN'])
class TeatroController extends RestfulController {
    static responseFormats = ['json', 'xml']
    TeatroController() {
        super(Teatro)
    }

    @Secured(['ROLE_ANONYMOUS', 'ROLE_ADMIN'])
    def index() {
        super.index();
    }

    @Transactional
	def save(Teatro teatro) {
	     teatro.save() // salva o teatro
	     Role role = Role.findByAuthority('ROLE_TEATRO') // recupera o role criado no Bootstrap
	     UserRole.create(teatro, role, true) // associa o teatro ao papel
	}
}
