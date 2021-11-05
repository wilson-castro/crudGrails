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

    def alterar(){

        Show show = Show.get(params.id)

        def listaBandas = Banda.list()
        def listaLocais = Local.list()

        render(template:"/show/form", model:[show:show,bandas:listaBandas, locais:listaLocais])
    }


    def salvar(){

        Show show = null

        if(params.id){
            show = Show.get(params.id)
        }else{
            show = new Show()
        }

        Date dataShow = Date.parse("yyyy-MM-dd",params.dataShow)
        Local localDoShow = Local.get(params.localID)
        List listBandas = params.List_BandaIDs.toList()

        ShowService showService = new ShowService()

        showService.save(show,  dataShow, localDoShow, listBandas)

        if (showService.hasErrors){
            render("Ops... deu pau!")
        }else{
            render("Salvo")
        }
    }

    def excluir(){
        Show show = Show.get(params.id)

        ShowService showService = new ShowService()

        showService.delete(show)

        def lista = Show.list()
        render(template: "/show/lista", model:[shows: lista])
    }
}
