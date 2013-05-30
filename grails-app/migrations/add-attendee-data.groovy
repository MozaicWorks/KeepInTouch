databaseChangeLog = {

    changeSet(author: "rinkkasatiainen", id: "add-attendee-data") {
        addColumn(tableName: "attendee") {
            column(name: "email", type: "varchar(255)") {
                constraints nullable: true
            }
            column(name: "location", type: "varchar(255)") {
                constraints nullable: true
            }
        }
    }
}
