databaseChangeLog = {

	changeSet(author: "alexb (generated)", id: "1369761711111a-1") {
		createTable(tableName: "ATTENDEE") {
			column(autoIncrement: "true", name: "ID", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "CONSTRAINT_4")
			}

			column(name: "VERSION", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "NAME", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "alexb (generated)", id: "1369761711111a-2") {
		createTable(tableName: "PERSISTENT_SESSION") {
			column(name: "ID", type: "VARCHAR(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "CONSTRAINT_3")
			}

			column(name: "CREATION_TIME", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "INVALIDATED", type: "BOOLEAN") {
				constraints(nullable: "false")
			}

			column(name: "LAST_ACCESSED_TIME", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "MAX_INACTIVE_INTERVAL", type: "INT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "alexb (generated)", id: "1369761711111a-3") {
		createTable(tableName: "PERSISTENT_SESSION_ATTRIBUTE") {
			column(autoIncrement: "true", name: "ID", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "CONSTRAINT_F")
			}

			column(name: "VERSION", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "NAME", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "SESSION_ID", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "alexb (generated)", id: "1369761711111a-4") {
		createTable(tableName: "PERSISTENT_SESSION_ATTRIBUTE_VALUE") {
			column(autoIncrement: "true", name: "ID", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "CONSTRAINT_5")
			}

			column(name: "VERSION", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "ATTRIBUTE_ID", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "SERIALIZED", type: "bytea(20000)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "alexb (generated)", id: "1369761711111a-5") {
		addForeignKeyConstraint(baseColumnNames: "SESSION_ID", baseTableName: "PERSISTENT_SESSION_ATTRIBUTE", baseTableSchemaName: "PUBLIC", constraintName: "FK50C6048B92381D29", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "PERSISTENT_SESSION", referencedTableSchemaName: "PUBLIC", referencesUniqueColumn: "false")
	}

	changeSet(author: "alexb (generated)", id: "1369761711111a-6") {
		addForeignKeyConstraint(baseColumnNames: "ATTRIBUTE_ID", baseTableName: "PERSISTENT_SESSION_ATTRIBUTE_VALUE", baseTableSchemaName: "PUBLIC", constraintName: "FK1EFE24BDF830ABF5", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "PERSISTENT_SESSION_ATTRIBUTE", referencedTableSchemaName: "PUBLIC", referencesUniqueColumn: "false")
	}
}
