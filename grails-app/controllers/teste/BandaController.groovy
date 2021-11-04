package teste

class BandaController {

    def index() {

        def lista = Banda.list()

        render(view: "/banda/index", model:[bandas:lista])
    }

    def procurarPorNomeEGenero(){

        String nomeBanda = params.nome
        def generos = params['listaGeneros[]']

        def generosConvertidosParaEnum = null

        if(generos != null){
           try {
               for (String genero : generos) {
                   generosConvertidosParaEnum = Banda.Genero.valueOf(genero)
               }
           }catch(Exception e){
               generosConvertidosParaEnum = Banda.Genero.valueOf(generos)

           }
       }

        def lista = Banda.createCriteria().list {
            ilike("nome", "%"+nomeBanda+"%")
            and{
                'in'("genero",generosConvertidosParaEnum)
            }
            order("id","asc")
        }

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
        Banda banda = null

        if (params.id){
            banda = Banda.get(params.id)
        }else{
            banda = new Banda()
        }

        banda.nome = params.nome
        banda.genero = Banda.Genero.valueOf(params.genero)

        banda.validate()
        if (!banda.hasErrors()){

            banda.save(flush:true)
            render("Salvo")
        }else{
            render("Ops... deu pau!")
            banda.errors.allErrors.each {
                println it
            }
        }

    }

    def excluir(){
        Banda banda = Banda.get(params.id)

        banda.delete(flush:true)

        def lista = Banda.list()
        render(template: "/banda/lista", model:[bandas: lista])
    }

    def alterar(){

        Banda banda = Banda.get(params.id)
        render(template:"/banda/form", model:[banda: banda])
    }
}
