package teste

class Banda {

    String nome
    Genero genero

    static hasMany = [showsDaBanda:Show]

    static belongsTo = [Show]

    static constraints = {
        nome nullable: false, blank: false
    }

    static mapping = {
        table name:"bandas"
        showsDaBanda joinTable:
                [name: "bandas_e_show",
                 key:"id_banda",column: "id_show"];
    }

    enum Genero{
        ROCK("ROCK"), AXE("AXÉ"), FORRO("FORRÓ")

        private String descricao

        Genero(String descricao){
            this.descricao = descricao
        }

        String getDescricao() {
            return descricao
        }
    }

}
