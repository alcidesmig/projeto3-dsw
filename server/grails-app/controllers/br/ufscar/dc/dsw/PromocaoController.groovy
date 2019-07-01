package br.ufscar.dc.dsw


import grails.rest.*
import grails.converters.*

class PromocaoController extends RestfulController {
    static responseFormats = ['json', 'xml']
    PromocaoController() {
        super(Promocao)
    }
}
