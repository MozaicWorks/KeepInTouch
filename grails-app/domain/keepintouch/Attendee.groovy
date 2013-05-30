package keepintouch

class Attendee {
    String name
	String location

    static constraints = {
		location blank : true
    }
}
