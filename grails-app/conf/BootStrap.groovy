import keepintouch.*

class BootStrap {

    def init = { servletContext ->
	if(!Attendee.count()){
		new Attendee(name: "Alexandru Bolboaca", location: "Bucharest, Romania").save(failOnError:true)
	}
    }
    def destroy = {
    }
}
