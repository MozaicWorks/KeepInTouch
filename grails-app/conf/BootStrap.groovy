import keepintouch.*

class BootStrap {

    def init = { servletContext ->
	if(!Attendee.count()){
		new Attendee(name: "Alexandru Bolboaca", email: "alexboly@gmail.com").save(failOnError:true)
	}
    }
    def destroy = {
    }
}
