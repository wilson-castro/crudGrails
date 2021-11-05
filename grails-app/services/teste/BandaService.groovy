package teste

import grails.gorm.transactions.Transactional

@Transactional
class BandaService extends GenericService<Banda, Long> {

    def delete(List<Show> listaDeShow,Banda banda){
        listaDeShow.each{show->
            if ( show.bandasNoShow.contains(banda)){
                show.bandasNoShow.remove(banda)

                show.save(flush:true)
            }
        }
        delete(banda)
    }

    List<Banda> findByNameAndGenero(String nomeBanda,def generos){
        List<Banda.Genero> generosConvertidosParaEnum = new ArrayList<>()
        def lista = null

        if(generos != null){
            try {
                for (String genero : generos) {

                    generosConvertidosParaEnum.add(Banda.Genero.valueOf(genero))
                }
            }catch(Exception e){
                generosConvertidosParaEnum.add(Banda.Genero.valueOf(generos))

            }

            lista = Banda.findAllByNomeIlikeAndGeneroInList("%"+nomeBanda+"%",generosConvertidosParaEnum)

        }else{
            lista = Banda.findAllByNomeIlike("%"+nomeBanda+"%")
        }

        return lista
    }
}
