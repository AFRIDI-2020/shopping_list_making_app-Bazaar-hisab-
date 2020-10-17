package com.example.bazarhisab.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bazarhisab.R
import kotlinx.android.synthetic.main.activity_list_details.*

class ListDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_details)

        val listName = intent.getStringExtra("listName")
        list_name_TV.text = listName

        back_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
    }
}