package com.example.praktikum6

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createPhoneData()
        rv_parts.layoutManager = LinearLayoutManager(this)
        rv_parts.setHasFixedSize(true)
        rv_parts.adapter = ContactAdapter(testData, {phoneItem : PhoneData -> phoneItemClicked(phoneItem)})
    }
    private fun phoneItemClicked(phoneItem : PhoneData) {
        val showDetailActivityIntent = Intent(this, PheneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT,phoneItem.phone.toString())
        startActivity(showDetailActivityIntent)
    }
    private fun createPhoneData() : List<PhoneData> {
        val partList = ArrayList<PhoneData>()
        partList.add(PhoneData(8993704720, "Helmy"))
        partList.add(PhoneData(8998812488, "Rika"))
        partList.add(PhoneData(9864934, "Alpha"))
        partList.add(PhoneData(1341933, "Bravo"))
        partList.add(PhoneData(1401624, "Charlie"))
        return partList
    }
}
