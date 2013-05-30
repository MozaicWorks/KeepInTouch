package keepintouch

class Attendee {
    String name
    String email
    String location

    static constraints = {
        email email: true, blank: true
        location blank : true
    }
}
