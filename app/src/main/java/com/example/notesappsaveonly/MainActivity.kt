package com.example.notesappsaveonly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edNotes:EditText
    lateinit var btnSumbmit:Button
    lateinit var notesList:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edNotes=findViewById(R.id.edNots)
        btnSumbmit=findViewById(R.id.btnSubmit)
        
        btnSumbmit.setOnClickListener(){
            if (edNotes.text.isNotEmpty()){
                val note=edNotes.text.toString()
                val dbhelper=DataBaseHelper(this)
                val status =  dbhelper.saveNote(note)
                Toast.makeText(applicationContext, "notes added successfully: $status", Toast.LENGTH_SHORT).show()
            }
        }

    }
}