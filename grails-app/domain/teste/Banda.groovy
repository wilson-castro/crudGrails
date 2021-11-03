package teste

class Banda {

    String nome
    String genero
    String shows

    static constraints = {
        nome nullable: false, blank: false
        genero inList: ["FORRO","AXE","ROCK"]
    }

    static mapping = {
        table name:"bandas"
    }
}
