databaseChangeLog = {


    include file: 'changelog.original.groovy'
    include file: 'add-attendee-data.groovy'

	include file: '20120530-add-age-column.groovy'

	include file: 'add-picture-name.groovy'
}
