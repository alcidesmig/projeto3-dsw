package br.ufscar.dc.dsw

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TeatroServiceSpec extends Specification {

    TeatroService teatroService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Teatro(...).save(flush: true, failOnError: true)
        //new Teatro(...).save(flush: true, failOnError: true)
        //Teatro teatro = new Teatro(...).save(flush: true, failOnError: true)
        //new Teatro(...).save(flush: true, failOnError: true)
        //new Teatro(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //teatro.id
    }

    void "test get"() {
        setupData()

        expect:
        teatroService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Teatro> teatroList = teatroService.list(max: 2, offset: 2)

        then:
        teatroList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        teatroService.count() == 5
    }

    void "test delete"() {
        Long teatroId = setupData()

        expect:
        teatroService.count() == 5

        when:
        teatroService.delete(teatroId)
        sessionFactory.currentSession.flush()

        then:
        teatroService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Teatro teatro = new Teatro()
        teatroService.save(teatro)

        then:
        teatro.id != null
    }
}
