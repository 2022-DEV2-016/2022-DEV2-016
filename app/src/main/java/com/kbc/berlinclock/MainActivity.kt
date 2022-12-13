package com.kbc.berlinclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kbc.berlinclock.adapters.BerlinClockAdapter
import com.kbc.berlinclock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var berlinClockAdapter: BerlinClockAdapter
    val berlinClockViewModel: BerlinClockViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeRecyclerView()
        with(berlinClockViewModel) {
            starts()
            berlinClockLiveData.observe(this@MainActivity, this@MainActivity::manageBlocks)
        }
    }

    private fun manageBlocks(blocks: Blocks) {

    }

    private fun initializeRecyclerView() {
        with(binding.activityMainRecyclerView) {
            berlinClockAdapter = BerlinClockAdapter()
            layoutManager = LinearLayoutManager(this.context)
            adapter = berlinClockAdapter
            visibility = View.VISIBLE
        }
    }
}