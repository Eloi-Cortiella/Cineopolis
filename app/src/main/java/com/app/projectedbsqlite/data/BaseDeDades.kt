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
