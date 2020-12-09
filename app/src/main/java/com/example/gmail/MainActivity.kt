package com.example.gmail

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gmail.model.ItemGmailResponse
import com.example.gmail.rest.ApiClient.client
import com.example.gmail.rest.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var listItem: ArrayList<ItemGmailResponse>  = ArrayList<ItemGmailResponse>()

    init {
        listItem.addAll(listOf(
            ItemGmailResponse(
                1,
                false,
                "https://api.androidhive.info/json/google.png",
                "Google Alerts",
                "Google Alert - android",
                "Now android supports multiple voice recogonization",
                "10:30 AM",
                false
            ), ItemGmailResponse(
                2,
                false,
                "https://api.androidhive.info/json/google.png",
                "Google Alerts",
                "Google Alert - android",
                "Now android supports multiple voice recogonization",
                "10:30 AM",
                true
            ), ItemGmailResponse(
                3,
                true,
                "https://api.androidhive.info/json/google.png",
                "Google Alerts",
                "Google Alert - android",
                "Now android supports multiple voice recogonization",
                "10:30 AM",
                true
            ), ItemGmailResponse(
                4,
                true,
                "https://api.androidhive.info/json/google.png",
                "Google Alerts",
                "Google Alert - android",
                "Now android supports multiple voice recogonization",
                "10:30 AM",
                false
            )
        ))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actionBar?.hide()
        supportActionBar?.hide()

        //recycle view
        recycleViewGmail.layoutManager =
            LinearLayoutManager(this)

        // adapter

        val adapter: GmailAdapter = GmailAdapter(this, listItem)
        recycleViewGmail.adapter = adapter
        recycleViewGmail.itemAnimator = DefaultItemAnimator()
//        getInbox()
        fab_reload.setOnClickListener {
//            getInbox()
            Log.d("MyTag", "setOnClickListener")

             listItem.add(
                 ItemGmailResponse(
                     listItem.size,
                     false,
                     "https://api.androidhive.info/json/google.png",
                     "Google Alerts",
                     "Boogle Alert - android",
                     "Now android supports multiple voice recogonization",
                     "10:30 AM",
                     false
                 )
            )
            Log.d("MyTag", listItem.size.toString())
            adapter.notifyItemInserted(listItem.size-1);
        }

        fab_reload.setOnLongClickListener {
            Log.d("MyTag", "setOnLongClickListener")
            adapter.notifyDataSetChanged()
            true;
        }


    }

    private fun getInbox() {
        Toast.makeText(this, "Start crawl...", Toast.LENGTH_LONG).show()
        val apiService: ApiInterface = client!!.create(ApiInterface::class.java)
        val call: Call<List<ItemGmailResponse>> = apiService.getList()
        call.enqueue(object : Callback<List<ItemGmailResponse>> {
            override fun onResponse(
                call: Call<List<ItemGmailResponse>>,
                response: Response<List<ItemGmailResponse>>
            ) {
                if (response.code() in 200..299) {

                    // clear the inbox
                    listItem.drop(listItem.size)

                    // add all the messages
                    // messages.addAll(response.body());

                    // the loop was performed to add colors to each message
                    for (item in response.body()!!) {
                        // generate a random color
                        listItem.plus(item)
                    }
                    Log.d("MYTAG", listItem.toString())
//                    mAdapter.notifyDataSetChanged()
                } else Toast.makeText(
                    applicationContext,
                    "Error " + response.message(),
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onFailure(call: Call<List<ItemGmailResponse>>, t: Throwable) {
                Toast.makeText(
                    applicationContext,
                    "Unable to fetch json: " + t.message,
                    Toast.LENGTH_LONG
                ).show()
                throw t
            }
        })
    }

}