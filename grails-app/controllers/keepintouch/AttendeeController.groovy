package keepintouch

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.multipart.MultipartFile

class AttendeeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [attendeeInstanceList: Attendee.list(params), attendeeInstanceTotal: Attendee.count()]
    }

    def create() {
        [attendeeInstance: new Attendee(params)]
    }

    def save() {
        def attendeeInstance = new Attendee(params)

        def file = request.getFile("picture")
        if(file) {
            def fileName = file.getOriginalFilename()
            attendeeInstance.picture = fileName
            def rootPath = request.getSession().getServletContext().getRealPath("/")
            file.transferTo(new File("${rootPath}/upload/${fileName}"))
        }

        if (!attendeeInstance.save(flush: true)) {
            render(view: "create", model: [attendeeInstance: attendeeInstance])
            return
        }


        flash.message = message(code: 'default.created.message', args: [message(code: 'attendee.label', default: 'Attendee'), attendeeInstance.id])
        redirect(action: "show", id: attendeeInstance.id)
    }

    def show(Long id) {
        def attendeeInstance = Attendee.get(id)
        if (!attendeeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'attendee.label', default: 'Attendee'), id])
            redirect(action: "list")
            return
        }

        [attendeeInstance: attendeeInstance]
    }

    def edit(Long id) {
        def attendeeInstance = Attendee.get(id)
        if (!attendeeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'attendee.label', default: 'Attendee'), id])
            redirect(action: "list")
            return
        }

        [attendeeInstance: attendeeInstance]
    }

    def update(Long id, Long version) {
        def attendeeInstance = Attendee.get(id)
        if (!attendeeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'attendee.label', default: 'Attendee'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (attendeeInstance.version > version) {
                attendeeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'attendee.label', default: 'Attendee')] as Object[],
                          "Another user has updated this Attendee while you were editing")
                render(view: "edit", model: [attendeeInstance: attendeeInstance])
                return
            }
        }

        attendeeInstance.properties = params

        if (!attendeeInstance.save(flush: true)) {
            render(view: "edit", model: [attendeeInstance: attendeeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'attendee.label', default: 'Attendee'), attendeeInstance.id])
        redirect(action: "show", id: attendeeInstance.id)
    }

    def delete(Long id) {
        def attendeeInstance = Attendee.get(id)
        if (!attendeeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'attendee.label', default: 'Attendee'), id])
            redirect(action: "list")
            return
        }

        try {
            attendeeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'attendee.label', default: 'Attendee'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'attendee.label', default: 'Attendee'), id])
            redirect(action: "show", id: id)
        }
    }
}
