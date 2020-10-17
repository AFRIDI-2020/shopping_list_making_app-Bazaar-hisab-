package com.example.bazarhisab.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bazarhisab.R
import com.example.bazarhisab.db.AllList
import com.example.bazarhisab.db.BazaarHisabDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_name_layout.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var job: Job
    private lateinit var dialog : AlertDialog

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        job = Job()

        val toolbar: Toolbar = findViewById(R.id.mainPageToolbar)
        toolbar.title = "বাজার-হিসাব"
        setSupportActionBar(toolbar)

        add_list_button.setOnClickListener {
            showListNameAlertDialog()
        }

        all_list_recyclerView.layoutManager = LinearLayoutManager(this)

        launch {
            applicationContext?.let {
                val getListName = BazaarHisabDatabase(it).allUserDao().getAllList()
                all_list_recyclerView.adapter = AllListAdapter(getListName)
            }
        }

    }

    private fun showListNameAlertDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        val view: View = layoutInflater.inflate(R.layout.list_name_layout, null)
        builder.setView(view)
        dialog = builder.create()
        dialog.show()
        view.add_new_list_TV.setOnClickListener {
            val newListName: String = view.add_new_list_name_ET.text.toString()
            if (!TextUtils.isEmpty(newListName)) {

                launch {
                    val listName = AllList(newListName)

                    applicationContext.let {
                        BazaarHisabDatabase(it).allUserDao().addList(listName)
                        it.toast("saved")
                    }
                }

                val intent = Intent(this, ListDetailsActivity::class.java)
                intent.putExtra("listName",newListName)
                startActivity(intent)

            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }


}