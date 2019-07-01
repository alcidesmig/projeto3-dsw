package br.ufscar.dc.dsw


import grails.rest.*
import grails.converters.*

class SalaController extends RestfulController {
    static responseFormats = ['json', 'xml']
    SalaController() {
        super(Sala)
    }
}
