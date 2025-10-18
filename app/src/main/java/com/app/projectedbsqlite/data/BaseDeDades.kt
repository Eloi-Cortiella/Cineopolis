package com.app.projectedbsqlite.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.projectedbsqlite.utils.Constants

class BaseDeDades(val context: Context) : SQLiteOpenHelper(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        // Create table matching data class Pelicula:
        // id INTEGER PRIMARY KEY AUTOINCREMENT,
        // titol TEXT NOT NULL,
        // any INTEGER,
        // director TEXT,
        // valoracio REAL
        val createTable = "CREATE TABLE ${Constants.TABLE_PELICULES} (" +
                "${Constants.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${Constants.COLUMN_TITOL} TEXT NOT NULL, " +
                "${Constants.COLUMN_ANY} INTEGER, " +
                "${Constants.COLUMN_DIRECTOR} TEXT, " +
                "${Constants.COLUMN_VALORACIO} REAL)"
        db?.execSQL(createTable)

        // Inserir dades de prova amb execSQL
        val insertData = "INSERT INTO ${Constants.TABLE_PELICULES} " +
                "(${Constants.COLUMN_TITOL}, ${Constants.COLUMN_ANY}, ${Constants.COLUMN_DIRECTOR}, ${Constants.COLUMN_VALORACIO}) VALUES " +
                "('Inception', 2010, 'Christopher Nolan', 8.8), " +
                "('The Matrix', 1999, 'The Wachowskis', 8.7), " +
                "('Interstellar', 2014, 'Christopher Nolan', 8.6)"
        db?.execSQL(insertData)

        // Inserir dades de prova amb ContentValues
        /*
        val pelicula = ContentValues().apply {
            put(Constants.COLUMN_TITOL, "The Dark Knight")
            put(Constants.COLUMN_ANY, 2008)
            put(Constants.COLUMN_DIRECTOR, "Christopher Nolan")
            put(Constants.COLUMN_VALORACIO, 9.0)
        }
        db?.insert(Constants.TABLE_PELICULES, null, pelicula)
         */
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        db?.execSQL("DROP TABLE IF EXISTS ${Constants.TABLE_PELICULES}")
        onCreate(db)
    }

}
