package teste

import org.springframework.validation.ObjectError

import java.lang.reflect.ParameterizedType

abstract class GenericService<DOMAIN,PK> {

    private Class<?> clazz
    public hasErrors = false
    private List<ObjectError> allErrors

    GenericService() {

        this.clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]
        this.allErrors = new ArrayList<ObjectError>()
    }

    ////////////////////////////////////////////////////////////////
    ///////////////////////// SERVICE METHODS //////////////////////

    List<ObjectError> getAllErros(){
        return this.allErrors
    }

    ////////////////////////////////////////////////////////////////
    ///////////////////////// CRUD METHODS /////////////////////////

    // save or update a domain
    void save(DOMAIN domainInstance){
        domainInstance.validate()
        if (!domainInstance.hasErrors()){

            domainInstance.save(flush:true)
            this.hasErrors = false
        }else{
            domainInstance.errors.allErrors.each {
                println it
                this.allErrors.add(it)
            }

          this.hasErrors = true
        }
    }

    // delete domain
    void delete(DOMAIN domainInstance){
        domainInstance.delete(flush:true)
    }


}
