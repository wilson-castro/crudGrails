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

    def procurarPorNome(){
        LocalService localService = new LocalService()

        String nomeLocal = params.nome

        def lista = localService.findByName(nomeLocal)

        render(template: "/local/lista", model:[locais:lista])
    }

    def prepararForm(){

        Local novoLocal = new Local()
        novoLocal.nome = ""
        novoLocal.capacidade = 1

        render(template:"/local/form", model:[local:novoLocal])

    }

    def excluir(){
        Local local = Local.get(params.id)

        LocalService localService = new LocalService()
        localService.delete(local)

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
        Integer capacidadeDoShow = params.capacidade.toInteger()

        local.nome = nomeLocal
        local.capacidade = capacidadeDoShow

        LocalService localService = new LocalService()
        localService.save(local)

        if (localService.hasErrors){
            render("Ops... deu pau!")
        }else{
            render("Salvo")
        }

    }

}
