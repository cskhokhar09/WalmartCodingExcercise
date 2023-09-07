package com.csk.walmartcodingexercise.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csk.walmartcodingexercise.R
import com.csk.walmartcodingexercise.ui.adapter.CountryInfoAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var countryInfoAdapter: CountryInfoAdapter

    private val countryInfoVieModel: CountryInfoViewModel by viewModels { CountryInfoViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progress_bar)
        recyclerView = findViewById(R.id.rv_countryInfoList)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.STARTED) {

                countryInfoVieModel.countryInfoUiState.collect { countryInfoUiState ->
                    when (countryInfoUiState) {
                        is CountryInfoUIState.Loading -> progressBar.visibility = View.VISIBLE
                        is CountryInfoUIState.Success -> {
                            progressBar.visibility = View.GONE
                            countryInfoAdapter =
                                CountryInfoAdapter(countryInfoList = countryInfoUiState.countryInfo)
                            recyclerView.adapter = countryInfoAdapter
                        }

                        is CountryInfoUIState.Error -> {
                            progressBar.visibility = View.GONE
                            Toast.makeText(
                                this@MainActivity,
                                getString(R.string.error_message),
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                }
            }
        }
    }

}