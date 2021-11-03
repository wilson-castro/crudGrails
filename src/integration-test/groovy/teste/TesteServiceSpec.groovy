package teste

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TesteServiceSpec extends Specification {

    TesteService testeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Teste(...).save(flush: true, failOnError: true)
        //new Teste(...).save(flush: true, failOnError: true)
        //Teste teste = new Teste(...).save(flush: true, failOnError: true)
        //new Teste(...).save(flush: true, failOnError: true)
        //new Teste(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //teste.id
    }

    void "test get"() {
        setupData()

        expect:
        testeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Teste> testeList = testeService.list(max: 2, offset: 2)

        then:
        testeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        testeService.count() == 5
    }

    void "test delete"() {
        Long testeId = setupData()

        expect:
        testeService.count() == 5

        when:
        testeService.delete(testeId)
        sessionFactory.currentSession.flush()

        then:
        testeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Teste teste = new Teste()
        testeService.save(teste)

        then:
        teste.id != null
    }
}
