package teste

class Local {

    String nome
    Integer capacidade

    static hasMany = [showsNoLocal:Local]

    static constraints = {
        nome nullable: false, blank: false
        capacidade min: 0
    }

    static mapping = {
        table name:"locais"

    }

}
