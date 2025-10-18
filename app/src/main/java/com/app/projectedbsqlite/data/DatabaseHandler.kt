package com.app.projectedbsqlite.data

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.projectedbsqlite.utils.Constants

class DatabaseHandler(val context: Context) : SQLiteOpenHelper(context, Constants.DATABASE_NAME,null,Constants.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        TODO("Not yet implemented")
    }
}