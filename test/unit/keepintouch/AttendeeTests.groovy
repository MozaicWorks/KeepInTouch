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
  }
