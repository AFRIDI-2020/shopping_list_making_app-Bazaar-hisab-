package com.example.bazarhisab.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.bazarhisab.R
import com.example.bazarhisab.db.BazaarHisabDatabase
import com.example.bazarhisab.ui.ListDetailsActivity
import com.example.bazarhisab.ui.toast
import kotlinx.android.synthetic.main.fragment_desired_items.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext



class DesiredItemsFragment : Fragment(), CoroutineScope {

    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        job = Job()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_desired_items, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        send_button.setOnClickListener {
            val productName = product_name_ET.text.toString().trim()
            val quantity = product_quantity_ET.text.toString().trim()
            if (productName.isEmpty()) {
                product_name_ET.error = "পণ্যের নাম লিখুন"
                product_name_ET.requestFocus()
                return@setOnClickListener
            }

            if (quantity.isEmpty()) {
                product_quantity_ET.error = "পরিমাণ লিখুন"
                product_quantity_ET.requestFocus()
                return@setOnClickListener
            }

            launch {
                context?.let {

                }
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }


}