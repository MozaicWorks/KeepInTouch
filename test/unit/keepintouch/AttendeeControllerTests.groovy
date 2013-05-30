package keepintouch



import org.junit.*
import grails.test.mixin.*

@TestFor(AttendeeController)
@Mock(Attendee)
class AttendeeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        params["name"] = 'Alex'
        params["age"] = 25
        params["location"] = 'Bucharest'
        params["email"]='alexboly@gmail.com'
    }

    void testIndex() {
        controller.index()
        assert "/attendee/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.attendeeInstanceList.size() == 0
        assert model.attendeeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.attendeeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.attendeeInstance != null
        assert view == '/attendee/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/attendee/show/1'
        assert controller.flash.message != null
        assert Attendee.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/attendee/list'

        populateValidParams(params)
        def attendee = new Attendee(params)

        assert attendee.save() != null

        params.id = attendee.id

        def model = controller.show()

        assert model.attendeeInstance == attendee
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/attendee/list'

        populateValidParams(params)
        def attendee = new Attendee(params)

        assert attendee.save() != null

        params.id = attendee.id

        def model = controller.edit()

        assert model.attendeeInstance == attendee
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/attendee/list'

        response.reset()

        populateValidParams(params)
        def attendee = new Attendee(params)

        assert attendee.save() != null

        // test invalid parameters in update
        params.id = attendee.id
        //TODO: add invalid values to params object
        params.name = "xxx"
        params.email = "13"
        params.age = -1

        controller.update()

        assert view == "/attendee/edit"
        assert model.attendeeInstance != null

        attendee.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/attendee/show/$attendee.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        attendee.clearErrors()

        populateValidParams(params)
        params.id = attendee.id
        params.version = -1
        controller.update()

        assert view == "/attendee/edit"
        assert model.attendeeInstance != null
        assert model.attendeeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/attendee/list'

        response.reset()

        populateValidParams(params)
        def attendee = new Attendee(params)

        assert attendee.save() != null
        assert Attendee.count() == 1

        params.id = attendee.id

        controller.delete()

        assert Attendee.count() == 0
        assert Attendee.get(attendee.id) == null
        assert response.redirectedUrl == '/attendee/list'
    }
}
