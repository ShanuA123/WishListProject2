package com.example.wishlistproject2

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var items : List<Items>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvMYrv = findViewById<RecyclerView>(R.id.rv_Items)
        val etName = findViewById<EditText>(R.id.et_ItemName)
        val etPrice = findViewById<EditText>(R.id.et_Price)
        val etStore = findViewById<EditText>(R.id.et_StoreName)
        val btSubmit = findViewById<Button>(R.id.bt_Submit)

        btSubmit.setOnClickListener{
            val hideKB = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            val item = Items(etName.text.toString(),etPrice.text.toString().toFloat(),etStore.text.toString())
            ItemsFetcher.item.add(item)
            items = ItemsFetcher.item
            val myCA = CustomAdapter(items)
            rvMYrv.adapter =  myCA
            rvMYrv.layoutManager = LinearLayoutManager(this)
            etName.setText("")
            etPrice.setText("")
            etStore.setText("")
            hideKB.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }


    }
}