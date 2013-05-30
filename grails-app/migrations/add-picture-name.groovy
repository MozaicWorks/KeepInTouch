databaseChangeLog = {

	changeSet(author: "rm (generated)", id: "1369919513081-6") {
        addColumn(tableName: "attendee") {
            column(name: "picture", type: "varchar(255)") {
                constraints nullable: true
            }
        }
    }
}
