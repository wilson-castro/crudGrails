package teste

class ShowController {

    def index() {
        def lista = Show.list()

        render(view:"/show/index", model:[shows:lista])
    }

    def listar(){
        def lista = Show.list()

        render(template: "/show/lista",model: [shows: lista])
    }

    def prepararForm(){

        Show novoShow = new Show()
        novoShow.dataDoShow = new Date();

        def listaBandas = Banda.list()
        def listaLocais = Local.list()

        render(template:"/show/form", model:[show:novoShow,bandas:listaBandas, locais:listaLocais])

    }

    def salvar(){

        Date dataShow = new Date(params.dataShow)
        Local localDoShow = Local.get(params.id)

        println localDoShow.nome
        println dataShow
    }
}
