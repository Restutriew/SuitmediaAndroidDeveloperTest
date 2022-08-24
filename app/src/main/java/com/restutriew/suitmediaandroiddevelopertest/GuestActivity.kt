package com.restutriew.suitmediaandroiddevelopertest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.restutriew.suitmediaandroiddevelopertest.databinding.ActivityGuestBinding
import org.json.JSONException


class GuestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuestBinding
    private var requestQueue: RequestQueue? = null
    private var guestList: ArrayList<GuestModel>? = null
    var guestAdapter: GuestAdapter? = null
    private var mGridLayoutManager: GridLayoutManager? = null
    lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        session = SessionManager(applicationContext)

        guestList = java.util.ArrayList<GuestModel>()

        binding.imgBack.setOnClickListener {
            finish()
        }

        mGridLayoutManager = GridLayoutManager(this, 2)
        binding.rvGuest.layoutManager = mGridLayoutManager
        binding.rvGuest.setHasFixedSize(true)

        requestQueue = Volley.newRequestQueue(this)
        getGuestData()
    }

    private fun getGuestData() {
        val url = "https://reqres.in/api/users?page=1&per_page=12"
        val request = JsonObjectRequest(Request.Method.GET, url, null, { response ->
            try {
                val jsonArray = response.getJSONArray("data")
                for (i in 0 until jsonArray.length()) {

                    val jsonObject = jsonArray.getJSONObject(i)
                    val id = jsonObject.getString("id")
                    val email = jsonObject.getString("email")
                    val first_name = jsonObject.getString("first_name")
                    val last_name = jsonObject.getString("last_name")
                    val avatar = jsonObject.getString("avatar")

                    Log.d("kimatest", "getGuestData: " + id)
                    Log.d("kimatest", "getGuestData: " + email)
                    Log.d("kimatest", "getGuestData: " + first_name)
                    Log.d("kimatest", "getGuestData: " + last_name)
                    Log.d("kimatest", "getGuestData: " + avatar)

                    guestList?.add(
                        GuestModel(
                            id, email, first_name, last_name, avatar
                        )
                    )

                    guestAdapter =
                        GuestAdapter(this@GuestActivity, guestList)
                    binding.rvGuest.setAdapter(guestAdapter)

                    guestAdapter!!.setOnItemClickCallback { data ->
                        session.createSessionGuest(data.first_name)
                        Log.d("kimatest", "getGuestData: " + data.getFirst_name())
                    }


                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }, { error -> error.printStackTrace() })
        requestQueue?.add(request)
    }
}