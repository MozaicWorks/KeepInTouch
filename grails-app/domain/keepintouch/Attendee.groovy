package keepintouch

import com.sun.istack.internal.Nullable;
import java.security.MessageDigest;

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

  def gravatarUrl() {
    MessageDigest md = MessageDigest.getInstance('MD5')
    md.update(this.email.bytes)
    String emailAsMD5 = new BigInteger(1, md.digest()).toString(16).padLeft(32, '0')
    "https://secure.gravatar.com/avatar/${emailAsMD5}?s=500"
  }

}
