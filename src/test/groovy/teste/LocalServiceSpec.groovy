package teste

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class LocalServiceSpec extends Specification implements ServiceUnitTest<LocalService>{

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
