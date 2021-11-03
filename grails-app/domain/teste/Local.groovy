package teste

class Local {

    String nome
    String nomeShow
    Integer capacidade

    static constraints = {
        nome nullable: false, blank: false
        nomeShow nullable: false, blank: false
        capacidade min: 0
    }

    static mapping = {
        table name:"locais"
    }

}
