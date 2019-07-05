package br.ufscar.dc.dsw

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PromocaoServiceSpec extends Specification {

    PromocaoService promocaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Promocao(...).save(flush: true, failOnError: true)
        //new Promocao(...).save(flush: true, failOnError: true)
        //Promocao promocao = new Promocao(...).save(flush: true, failOnError: true)
        //new Promocao(...).save(flush: true, failOnError: true)
        //new Promocao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //promocao.id
    }

    void "test get"() {
        setupData()

        expect:
        promocaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Promocao> promocaoList = promocaoService.list(max: 2, offset: 2)

        then:
        promocaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        promocaoService.count() == 5
    }

    void "test delete"() {
        Long promocaoId = setupData()

        expect:
        promocaoService.count() == 5

        when:
        promocaoService.delete(promocaoId)
        sessionFactory.currentSession.flush()

        then:
        promocaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Promocao promocao = new Promocao()
        promocaoService.save(promocao)

        then:
        promocao.id != null
    }
}
