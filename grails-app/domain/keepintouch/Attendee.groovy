package keepintouch

class Attendee {
    String name
    String email

    static constraints = {
        email email: true, blank: true

    }
}
