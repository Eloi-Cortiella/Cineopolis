package com.app.projectedbsqlite.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.projectedbsqlite.utils.Constants

class BaseDeDades(context: Context) :
    SQLiteOpenHelper(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        // Create table matching data class Pelicula:
        // id INTEGER PRIMARY KEY AUTOINCREMENT,
        // titol TEXT NOT NULL,
        // any INTEGER,
        // director TEXT,
        // valoracio FLOAT
        val createTable = """
                    CREATE TABLE ${Constants.TABLE_PELICULES} (
                        ${Constants.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                        ${Constants.COLUMN_TITOL} TEXT NOT NULL,
                        ${Constants.COLUMN_ANY} INTEGER NOT NULL,
                        ${Constants.COLUMN_DIRECTOR} TEXT NOT NULL,
                        ${Constants.COLUMN_VALORACIO} FLOAT NOT NULL
                    )
                """
        db?.execSQL(createTable)

        // Inserir dades de prova amb execSQL
        val insertData = """
                    INSERT INTO ${Constants.TABLE_PELICULES}
                    (${Constants.COLUMN_TITOL},
                    ${Constants.COLUMN_ANY},
                    ${Constants.COLUMN_DIRECTOR},
                    ${Constants.COLUMN_VALORACIO}) VALUES
                    ('Inception', 2010, 'Christopher Nolan', 8.8),
                    ('The Matrix', 1999, 'The Wachowskis', 8.7),
                    ('Interstellar', 2014, 'Christopher Nolan', 8.6),
                    ('Zoolander', 2001, 'Ben Stiller', 10)
                """
        db?.execSQL(insertData)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL("DROP TABLE IF EXISTS ${Constants.TABLE_PELICULES}")

        onCreate(db)
    }
}