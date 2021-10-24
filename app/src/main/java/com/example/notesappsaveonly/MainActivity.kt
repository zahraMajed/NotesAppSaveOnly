package com.example.notesappsaveonly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var edNotes:EditText
    lateinit var btnSumbmit:Button
    lateinit var notesList:ArrayList<String>
    val dbhelper=DataBaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edNotes=findViewById(R.id.edNots)
        btnSumbmit=findViewById(R.id.btnSubmit)


        btnSumbmit.setOnClickListener(){
            if (edNotes.text.isNotEmpty()){
                val note=edNotes.text.toString()
                val status = dbhelper.saveNote(note)
                Toast.makeText(applicationContext, "notes added successfully: $status", Toast.LENGTH_SHORT).show()
                getData()
            }
        }
        getData()
    }

    fun getData(){
       val d=dbhelper.getData()
        rv_main.adapter=RecyclerAdapter(d)
        rv_main.layoutManager=LinearLayoutManager(this)
    }

}