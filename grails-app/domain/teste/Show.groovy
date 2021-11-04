package teste

class Show {

    Date dataDoShow

    static belongsTo = [localDoShow:Local]

    static hasMany = [bandasNoShow:Banda]

    static constraints = {
        locaDoShow nullable:false
    }

    static mapping = {
        table name:"shows"
        bandasNoShow joinTable:
                [name:"bandas_e_show",
                 key:"id_show",column:"id_banda"]
    }
}
