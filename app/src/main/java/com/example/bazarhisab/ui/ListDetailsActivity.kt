package com.example.bazarhisab.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bazarhisab.R
import com.example.bazarhisab.db.BazaarHisabDatabase
import com.example.bazarhisab.ui.fragments.DesiredItemsFragment
import com.example.bazarhisab.ui.fragments.ItemDetailsFragment
import kotlinx.android.synthetic.main.activity_list_details.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListDetailsActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var job: Job


    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_details)

        job = Job()
        val listName = intent.getStringExtra("listName")
        list_name_TV.text = listName

        launch {
            applicationContext?.let {
                val listId = BazaarHisabDatabase(it).allUserDao().getId(listName).toString()
                it.toast(listId)
            }

        }

        back_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        viewPagerAdapter.addFragment(DesiredItemsFragment(),"কাঙ্ক্ষিত পণ্য")
        viewPagerAdapter.addFragment(ItemDetailsFragment(),"সম্পূর্ণ তালিকা")

        view_pager.adapter = viewPagerAdapter
        tab_layout.setupWithViewPager(view_pager)
    }



    override fun onBackPressed() {
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }




}