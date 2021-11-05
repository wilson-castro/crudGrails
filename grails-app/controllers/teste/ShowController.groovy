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

        Show show = new Show()

        Date dataShow = Date.parse("yyyy-MM-dd",params.dataShow)
        Local localDoShow = Local.get(params.localID)
        List listaBandas = params.List_BandaIDs.toList()

        listaBandas.eachWithIndex { id,i->
            if (id?.toInteger() > 0) {
                Integer idBandaInt = listaBandas[i].toInteger()
                Long idBanda = (Long) idBandaInt

                Banda bandaDoShow = Banda.get(idBanda)

                def listabanda = null
                listabanda.add(bandaDoShow)
            }
        }

        println show.bandasNoShow
    }
}
