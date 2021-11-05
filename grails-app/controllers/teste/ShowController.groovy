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

        def listaDeBandas = new ArrayList<Banda>();

        listBandas.eachWithIndex { id,i->
            if (id?.toInteger() > 0) {
                Integer idBandaInt = listBandas[i].toInteger()
                Long idBanda = (Long) idBandaInt

                Banda bandaDoShow = Banda.get(idBanda)

                listaDeBandas.add(bandaDoShow)
            }
        }

        show.dataDoShow = dataShow
        show.localDoShow = localDoShow
        show.bandasNoShow = listaDeBandas.toSet()

        show.validate()
        if (!show.hasErrors()){

            show.save(flush:true)
            render("Salvo")
        }else{
            render("Ops... deu pau!")
            show.errors.allErrors.each {
                println it
            }
        }
    }

    def excluir(){
        Show show = Show.get(params.id)

        show.delete(flush:true)

        def lista = Show.list()
        render(template: "/show/lista", model:[shows: lista])
    }
}
