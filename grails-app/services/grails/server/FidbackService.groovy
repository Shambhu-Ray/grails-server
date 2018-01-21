package grails.server

import grails.gorm.services.Service

@Service(Fidback)
interface FidbackService {

    Fidback get(Serializable id)

    List<Fidback> list(Map args)

    Long count()

    void delete(Serializable id)

    Fidback save(Fidback fidback)

}