import org.codehaus.groovy.grails.commons.GrailsApplication;

import keepintouch.*

class BootStrap {
	def grailsApplication

    def init = { servletContext ->
		def uploadDir = new File(grailsApplication.config.keepintouch.upload.path)
		if (!uploadDir.exists()) {
			println "ERROR: Application file upload directory " + uploadDir + " does not exist ... picture upload will not work"
		}
    }
    def destroy = {
    }
}
