package com.example.lab5_pnguye68

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewHistory)

        // Update with the use of Grid Layout
        // Each item will be displayed as a CardView in 2-column grid
        recyclerView.layoutManager = androidx.recyclerview.widget.GridLayoutManager(this, 2)


        val prefs = getSharedPreferences("tip_history", Context.MODE_PRIVATE)
        val json = prefs.getString("records", null)

        val list: List<TipRecord> = if (json != null) {
            val type = object : TypeToken<List<TipRecord>>() {}.type
            Gson().fromJson(json, type)
        } else {
            listOf()
        }

        recyclerView.adapter = TipRecordAdapter(list)

        recyclerView.addItemDecoration(GridSpacingItemDecoration(16))

    }
}