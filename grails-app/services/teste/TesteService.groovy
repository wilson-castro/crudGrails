package teste

import grails.gorm.services.Service

@Service(Teste)
interface TesteService {

    Teste get(Serializable id)

    List<Teste> list(Map args)

    Long count()

    void delete(Serializable id)

    Teste save(Teste teste)

}