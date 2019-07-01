package br.ufscar.dc.dsw


import grails.rest.*
import grails.converters.*

class SiteController extends RestfulController {
    static responseFormats = ['json', 'xml']
    SiteController() {
        super(Site)
    }
}
