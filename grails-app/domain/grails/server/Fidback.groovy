package grails.server

import org.apache.commons.lang.time.DateUtils

class Fidback {
    String email
    String message
    Date dateCreated

    static constraints = {
        email email: true, nullable: false, blank: false
        message nullable: false, blank: false
    }
    static mapping = {
        message type: "text"
    }
}
