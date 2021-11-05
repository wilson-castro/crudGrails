package teste

class BandaController {

    def index() {

        def lista = Banda.list()

        render(view: "/banda/index", model:[bandas:lista])
    }

    def procurarPorNomeEGenero(){
        BandaService bandaService = new BandaService()

        String nomeBanda = params.nome

        def generos = params['listaGeneros[]']

       def lista = bandaService.findByNameAndGenero(nomeBanda, generos)

        render(template: "/banda/lista", model:[bandas:lista])
    }

    def prepararForm(){

        Banda novaBanda = new Banda()
        novaBanda.nome = ""

        render(template:"/banda/form", model:[banda:novaBanda])
    }

    def listar(){

        def lista = Banda.list()

        render(template: "/banda/lista", model:[bandas:lista])

    }

    def salvar(){
        BandaService bandaService = new BandaService()
        Banda banda = null

        if (params.id){
            banda = Banda.get(params.id)
        }else{
            banda = new Banda()
        }

        banda.nome = params.nome
        banda.genero = Banda.Genero.valueOf(params.genero)

        bandaService.save(banda)

        if(bandaService.hasErrors){
            render("Ops... deu pau!")
        }else{
           render("Salvo")
        }

    }

    def excluir(){
        Banda banda = Banda.get(params.id)
        BandaService bandaService = new BandaService()

        def listaDeShow = Show.list()

        bandaService.delete(listaDeShow,banda)

        def lista = Banda.list()
        render(template: "/banda/lista", model:[bandas: lista])
    }

    def alterar(){

        Banda banda = Banda.get(params.id)
        render(template:"/banda/form", model:[banda: banda])
    }
}
