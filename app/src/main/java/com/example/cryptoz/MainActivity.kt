package com.example.cryptoz

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoz.Adapter.CryptoListAdapter
import com.example.cryptoz.ViewModel.MainViewModel
import com.example.cryptoz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    private val mainViewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initRecyclerviewCrypto()

    }

    private fun initRecyclerviewCrypto() {
        binding.view.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.view.adapter = CryptoListAdapter(mainViewModel.loadData())
    }
}