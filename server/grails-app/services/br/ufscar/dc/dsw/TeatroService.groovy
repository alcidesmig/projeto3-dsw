package br.ufscar.dc.dsw

import grails.gorm.services.Service

@Service(Teatro)
interface TeatroService {

    Teatro get(Serializable id)

    List<Teatro> list(Map args)

    Long count()

    void delete(Serializable id)

    Teatro save(Teatro teatro)

}