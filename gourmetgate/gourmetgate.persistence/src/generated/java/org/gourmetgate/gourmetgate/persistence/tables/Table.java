/*
 * This file is generated by jOOQ.
 */
package org.gourmetgate.gourmetgate.persistence.tables;


import org.gourmetgate.gourmetgate.persistence.Keys;
import org.gourmetgate.gourmetgate.persistence.Schema;
import org.gourmetgate.gourmetgate.persistence.tables.records.TableRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Table extends TableImpl<TableRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>Schema.table</code>
     */
    public static final Table TABLE = new Table();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TableRecord> getRecordType() {
        return TableRecord.class;
    }

    /**
     * The column <code>Schema.table.TABLE_ID</code>.
     */
    public final TableField<TableRecord, String> TABLE_ID = createField(DSL.name("TABLE_ID"), SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column <code>Schema.table.NAME</code>.
     */
    public final TableField<TableRecord, String> NAME = createField(DSL.name("NAME"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>Schema.table.STATUS</code>.
     */
    public final TableField<TableRecord, String> STATUS = createField(DSL.name("STATUS"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    private Table(Name alias, org.jooq.Table<TableRecord> aliased) {
        this(alias, aliased, null);
    }

    private Table(Name alias, org.jooq.Table<TableRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>Schema.table</code> table reference
     */
    public Table(String alias) {
        this(DSL.name(alias), TABLE);
    }

    /**
     * Create an aliased <code>Schema.table</code> table reference
     */
    public Table(Name alias) {
        this(alias, TABLE);
    }

    /**
     * Create a <code>Schema.table</code> table reference
     */
    public Table() {
        this(DSL.name("table"), null);
    }

    public <O extends Record> Table(org.jooq.Table<O> child, ForeignKey<O, TableRecord> key) {
        super(child, key, TABLE);
    }

    @Override
    public org.jooq.Schema getSchema() {
        return aliased() ? null : Schema.SCHEMA;
    }

    @Override
    public UniqueKey<TableRecord> getPrimaryKey() {
        return Keys.TABLE_PK;
    }

    @Override
    public Table as(String alias) {
        return new Table(DSL.name(alias), this);
    }

    @Override
    public Table as(Name alias) {
        return new Table(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Table rename(String name) {
        return new Table(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Table rename(Name name) {
        return new Table(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
