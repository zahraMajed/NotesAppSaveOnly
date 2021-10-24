package com.example.notesappsaveonly

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
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

    @SuppressLint("Range")
    fun getData(): ArrayList<String> {
        var data= arrayListOf<String>()
        val sqlite:SQLiteDatabase=writableDatabase
        val cursor:Cursor=sqlite.query("notes" , null,null, null, null, null,null)
        if (cursor.moveToFirst()) {
            do {
                data.add(cursor.getString(cursor.getColumnIndex("Note")))
            }while (cursor.moveToNext())
        }
        return data
    }

}