package keepintouch

import com.sun.istack.internal.Nullable;

class Attendee {
  String name
  String email
  String location
  Integer age
  String twitter
  String blog
  String picture

  static constraints = {
    name()
    email(blank: true, nullable: true)
    location(blank: true, nullable: true)
    age(range: 15..90)
    twitter(blank: true, nullable: true)
    blog(blank: true, nullable: true)
    picture(nullable: true)
  }

}
