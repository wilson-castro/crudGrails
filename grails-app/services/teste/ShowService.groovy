package teste

import grails.gorm.transactions.Transactional

@Transactional
class ShowService extends GenericService<Show,Long>{

    void save(Show show, Date dataShow, Local localDoShow, List<String> listBandas) {
        def listaDeBandas = new ArrayList<Banda>();

        listBandas.eachWithIndex { id,i->
            if (id?.toInteger() > 0) {
                Integer idBandaInt = listBandas[i].toInteger()
                Long idBanda = (Long) idBandaInt

                Banda bandaDoShow = Banda.get(idBanda)

                listaDeBandas.add(bandaDoShow)
            }
        }

        show.dataDoShow = dataShow
        show.localDoShow = localDoShow
        show.bandasNoShow = listaDeBandas.toSet()

        save(show)
    }
}
