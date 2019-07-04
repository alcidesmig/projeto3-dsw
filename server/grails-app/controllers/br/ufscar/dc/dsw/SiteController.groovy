package br.ufscar.dc.dsw


import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured
import grails.gorm.transactions.*

@Secured(['ROLE_ADMIN'])
class SiteController extends RestfulController {
    static responseFormats = ['json', 'xml']
    SiteController() {
        super(Site)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_SITE'])
    def index() {
        super.index();
    }

    @Transactional
	def save(Site site) {
	     super.save()
	     
	}

}
