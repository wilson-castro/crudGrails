package teste

import grails.gorm.transactions.Transactional

@Transactional
class LocalService extends GenericService<Local, Long> {

   List<Local> findByName(String nomeLocal){
       return  Local.findAllByNomeIlike("%"+nomeLocal+"%")
   }
}
