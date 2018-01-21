package grails.server

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FidbackServiceSpec extends Specification {

    FidbackService fidbackService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Fidback(...).save(flush: true, failOnError: true)
        //new Fidback(...).save(flush: true, failOnError: true)
        //Fidback fidback = new Fidback(...).save(flush: true, failOnError: true)
        //new Fidback(...).save(flush: true, failOnError: true)
        //new Fidback(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //fidback.id
    }

    void "test get"() {
        setupData()

        expect:
        fidbackService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Fidback> fidbackList = fidbackService.list(max: 2, offset: 2)

        then:
        fidbackList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        fidbackService.count() == 5
    }

    void "test delete"() {
        Long fidbackId = setupData()

        expect:
        fidbackService.count() == 5

        when:
        fidbackService.delete(fidbackId)
        sessionFactory.currentSession.flush()

        then:
        fidbackService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Fidback fidback = new Fidback()
        fidbackService.save(fidback)

        then:
        fidback.id != null
    }
}
