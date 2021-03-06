/*
 * This file is generated by jOOQ.
 */
package ru.home.db;


import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;

import ru.home.db.tables.Candy;
import ru.home.db.tables.FlywaySchemaHistory;
import ru.home.db.tables.Present;
import ru.home.db.tables.PresentItem;
import ru.home.db.tables.records.CandyRecord;
import ru.home.db.tables.records.FlywaySchemaHistoryRecord;
import ru.home.db.tables.records.PresentItemRecord;
import ru.home.db.tables.records.PresentRecord;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>PUBLIC</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2",
        "schema version:PUBLIC_1.5.0"
    },
    date = "2018-10-16T00:20:10.442Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CandyRecord> CONSTRAINT_5 = UniqueKeys0.CONSTRAINT_5;
    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = UniqueKeys0.FLYWAY_SCHEMA_HISTORY_PK;
    public static final UniqueKey<PresentRecord> CONSTRAINT_E = UniqueKeys0.CONSTRAINT_E;
    public static final UniqueKey<PresentItemRecord> CONSTRAINT_2 = UniqueKeys0.CONSTRAINT_2;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<PresentItemRecord, PresentRecord> CONSTRAINT_29 = ForeignKeys0.CONSTRAINT_29;
    public static final ForeignKey<PresentItemRecord, CandyRecord> CONSTRAINT_296 = ForeignKeys0.CONSTRAINT_296;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<CandyRecord> CONSTRAINT_5 = Internal.createUniqueKey(Candy.CANDY, "CONSTRAINT_5", Candy.CANDY.ID);
        public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, "flyway_schema_history_pk", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK);
        public static final UniqueKey<PresentRecord> CONSTRAINT_E = Internal.createUniqueKey(Present.PRESENT, "CONSTRAINT_E", Present.PRESENT.ID);
        public static final UniqueKey<PresentItemRecord> CONSTRAINT_2 = Internal.createUniqueKey(PresentItem.PRESENT_ITEM, "CONSTRAINT_2", PresentItem.PRESENT_ITEM.PRESENT_ID, PresentItem.PRESENT_ITEM.CANDY_ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<PresentItemRecord, PresentRecord> CONSTRAINT_29 = Internal.createForeignKey(ru.home.db.Keys.CONSTRAINT_E, PresentItem.PRESENT_ITEM, "CONSTRAINT_29", PresentItem.PRESENT_ITEM.PRESENT_ID);
        public static final ForeignKey<PresentItemRecord, CandyRecord> CONSTRAINT_296 = Internal.createForeignKey(ru.home.db.Keys.CONSTRAINT_5, PresentItem.PRESENT_ITEM, "CONSTRAINT_296", PresentItem.PRESENT_ITEM.CANDY_ID);
    }
}
