/*
 * This file is generated by jOOQ.
*/
package ru.home.db;


import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;

import ru.home.db.tables.Candy;
import ru.home.db.tables.FlywaySchemaHistory;
import ru.home.db.tables.Present;
import ru.home.db.tables.PresentItem;


/**
 * A class modelling indexes of tables of the <code>presents</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5",
        "schema version:1"
    },
    date = "2018-02-23T09:15:27.173Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index CANDY_LIST = Indexes0.CANDY_LIST;
    public static final Index CANDY_PRIMARY = Indexes0.CANDY_PRIMARY;
    public static final Index FLYWAY_SCHEMA_HISTORY_FLYWAY_SCHEMA_HISTORY_S_IDX = Indexes0.FLYWAY_SCHEMA_HISTORY_FLYWAY_SCHEMA_HISTORY_S_IDX;
    public static final Index FLYWAY_SCHEMA_HISTORY_PRIMARY = Indexes0.FLYWAY_SCHEMA_HISTORY_PRIMARY;
    public static final Index PRESENT_PRIMARY = Indexes0.PRESENT_PRIMARY;
    public static final Index PRESENT_ITEM_CANDY_ID = Indexes0.PRESENT_ITEM_CANDY_ID;
    public static final Index PRESENT_ITEM_PRIMARY = Indexes0.PRESENT_ITEM_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index CANDY_LIST = Internal.createIndex("list", Candy.CANDY, new OrderField[] { Candy.CANDY.ACTIVE, Candy.CANDY.ORDER }, false);
        public static Index CANDY_PRIMARY = Internal.createIndex("PRIMARY", Candy.CANDY, new OrderField[] { Candy.CANDY.ID }, true);
        public static Index FLYWAY_SCHEMA_HISTORY_FLYWAY_SCHEMA_HISTORY_S_IDX = Internal.createIndex("flyway_schema_history_s_idx", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, new OrderField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.SUCCESS }, false);
        public static Index FLYWAY_SCHEMA_HISTORY_PRIMARY = Internal.createIndex("PRIMARY", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, new OrderField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
        public static Index PRESENT_PRIMARY = Internal.createIndex("PRIMARY", Present.PRESENT, new OrderField[] { Present.PRESENT.ID }, true);
        public static Index PRESENT_ITEM_CANDY_ID = Internal.createIndex("candy_id", PresentItem.PRESENT_ITEM, new OrderField[] { PresentItem.PRESENT_ITEM.CANDY_ID }, false);
        public static Index PRESENT_ITEM_PRIMARY = Internal.createIndex("PRIMARY", PresentItem.PRESENT_ITEM, new OrderField[] { PresentItem.PRESENT_ITEM.PRESENT_ID, PresentItem.PRESENT_ITEM.CANDY_ID }, true);
    }
}