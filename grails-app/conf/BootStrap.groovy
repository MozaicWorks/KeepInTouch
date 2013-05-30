import keepintouch.*

class BootStrap {

    def init = { servletContext ->
        def storagePath = servletContext.getRealPath("/")
        def storagePathDirectory = new File("${storagePath}/upload/")
        if (!storagePathDirectory.exists()) {
            print "CREATING DIRECTORY ${storagePathDirectory}: "
            if (storagePathDirectory.mkdirs()) {
                println "SUCCESS"
            } else {
                println "FAILED"
            }
        }
    }
    def destroy = {
    }
}
