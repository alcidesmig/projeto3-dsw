package br.ufscar.dc.dsw

import grails.gorm.services.Service

@Service(Promocao)
interface PromocaoService {

    Promocao get(Serializable id)

    List<Promocao> list(Map args)

    Long count()

    void delete(Serializable id)

    Promocao save(Promocao promocao)

}