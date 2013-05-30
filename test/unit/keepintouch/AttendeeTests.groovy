package keepintouch



import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Attendee)
  class AttendeeTests {

    void testSomething() {
      Attendee attendee = new Attendee(name:"Alex", age: 20)
      assertEquals("Alex", attendee.name)
    }
  }
