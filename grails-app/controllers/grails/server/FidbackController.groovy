package grails.server

import grails.converters.JSON
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

/*failOnError*/
class FidbackController {

    FidbackService fidbackService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def show(Long id) {
        respond fidbackService.get(id)
    }

    def save() {
        if (params.email == null || params.email == "") {
            render ([status: false, message: "Email address not found !"] as JSON)
            return
        } else if (params.message == null || params.message == ""){
            render ([status: false, message: "Message not found !"] as JSON)
            return
        }
        def fidbackInstance = Fidback.findByEmail(params.email)
        if (fidbackInstance){
            println("1221")
            update(fidbackInstance, params.message)
            return
        } else {
            try {
                Fidback fidback = new Fidback()
                fidback.email = params.email
                fidback.message = params.message
                fidbackService.save(fidback)
            } catch (ValidationException e) {
                //render ([status: fidback.errors] as JSON)
                render ([status: false, message: "Not a valid email !"] as JSON)
                return
            }
        }
        println "called"
        respond ([status: true, message: "message send successfully !"] as JSON)
    }


    def update(Fidback fidback, String message) {
        try {
            fidback.message = message
            fidbackService.save(fidback)
        } catch (ValidationException e) {
            println "bingo"
            render ([status: false, message: "Not a valid message !"] as JSON)
            return
        }
        println("hello")
        render([status: true, message: "Message send successfully !"] as JSON)
    }
}
