package teste

class BandaController {

    def index() {

        def lista = Banda.list()

        render(view: "index", model:[bandas:lista])
    }
}
