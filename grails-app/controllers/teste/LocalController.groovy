package teste

class LocalController {

    def index() {

        def lista = Local.list()

        render(view:"/local/index", model:[locais:lista])
    }

    def listar(){

        def lista = Local.list()

        render(template: "/local/lista", model:[locais:lista])
    }

    def adicionar(){

        Local novoLocal = new Local()
        novoLocal.nome = ""
        novoLocal.nomeShow = ""
        novoLocal.capacidade = 1

        render(template:"/local/form", model:[local:novoLocal])
    }

    def excluir(){
        Local local = Local.get(params.id)

        local.delete(flush:true)

        def lista = Local.list()
        render(template: "/local/lista", model:[locais: lista])
    }

    def alterar(){

        Local local = Local.get(params.id)
        render(template:"/local/form", model:[local: local])
    }

    def salvar(){
        Local local = null

        if(params.id){
            local = Local.get(params.id)
        }else {
            local =  new Local();

        }

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
