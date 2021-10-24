package com.example.notesappsaveonly

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context?) : SQLiteOpenHelper(context, "data.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("create table notes (Note text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun saveNote(note:String): Long {
        val ConVal=ContentValues()
        ConVal.put("Note", note)
        val sqlite:SQLiteDatabase=writableDatabase
        val status= sqlite.insert("notes",null,ConVal)
        return status
    }

}