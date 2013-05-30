databaseChangeLog = {
	changeSet(author: "rm (generated)", id: "1369917554576-1") {
        addColumn(tableName: "attendee") {
            column(name: "age", type: "int") {
                constraints nullable: false
            }
        }

        addColumn(tableName: "attendee") {
            column(name: "blog", type: "varchar(100)") {
                constraints nullable: true
            }
        }

        addColumn(tableName: "attendee") {
            column(name: "twitter", type: "varchar(100)") {
                constraints nullable: true
            }
        }

	}
}
