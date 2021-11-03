package teste

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TesteController {

    TesteService testeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond testeService.list(params), model:[testeCount: testeService.count()]
    }

    def show(Long id) {
        respond testeService.get(id)
    }

    def create() {
        respond new Teste(params)
    }

    def save(Teste teste) {
        if (teste == null) {
            notFound()
            return
        }

        try {
            testeService.save(teste)
        } catch (ValidationException e) {
            respond teste.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'teste.label', default: 'Teste'), teste.id])
                redirect teste
            }
            '*' { respond teste, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond testeService.get(id)
    }

    def update(Teste teste) {
        if (teste == null) {
            notFound()
            return
        }

        try {
            testeService.save(teste)
        } catch (ValidationException e) {
            respond teste.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'teste.label', default: 'Teste'), teste.id])
                redirect teste
            }
            '*'{ respond teste, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        testeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'teste.label', default: 'Teste'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'teste.label', default: 'Teste'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
