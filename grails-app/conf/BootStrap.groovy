import keepintouch.*

class BootStrap {

    def init = { servletContext ->
	if(!Attendee.count()){
		new Attendee(name: "Alexandru Bolboaca").save(failOnError:true)
	}
    }
    def destroy = {
    }
}
