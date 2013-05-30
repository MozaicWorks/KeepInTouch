package keepintouch



import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Attendee)
  class AttendeeTests {

    void testValidAttendee() {
      Attendee attendee = new Attendee(name:"Alex", age: 20)
      assertEquals("Alex", attendee.name)
    }

    void testNameIsMandatory() {
      Attendee attendee = new Attendee(age: 20)
      assertFalse attendee.validate()
    }

    void testAgeTooYoung() {
      Attendee attendee = new Attendee(name:"Alex", age: 14)
      assertFalse attendee.validate()
    }

    void testAgeTooOld() {
      Attendee attendee = new Attendee(name:"Alex", age: 91)
      assertFalse attendee.validate()
    }

    void testGravatarUrl() {
      String gravatarUrl = "https://secure.gravatar.com/avatar/eb2e398ce847e2ca474a74d42d47ff52?s=500"
      Attendee attendee = new Attendee(name:"aimee", age: 32, email: "aimee@aimeerivers.com")
      assertEquals(gravatarUrl, attendee.gravatarUrl())
    }
  }
