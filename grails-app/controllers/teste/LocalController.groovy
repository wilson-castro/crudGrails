package teste

class LocalController {

    def index() {

        def lista = Local.list()

        render(view:"/local/index", model:[locais:lista])
    }

    def adicionar(){

        Local novoLocal = new Local()
        novoLocal.nome = ""
        novoLocal.nomeShow = ""
        novoLocal.capacidade = 1

        render(template:"/local/form", model:[local:novoLocal])
    }

    def salvar(){

        Local local = new Local();

        String nomeLocal = params.nome
        String nomeShow = params.nomeShow
        Integer capacidadeDoShow = params.capacidade.toInteger()

        local.nome = nomeLocal
        local.nomeShow = nomeShow
        local.capacidade = capacidadeDoShow

        local.validate()
        if (!local.hasErrors()){

            local.save(flush:true)
            render("Salvo")
        }else{
            render("Ops... deu pau!")
            local.errors.allErrors.each {
                println it
            }
        }
    }
}
