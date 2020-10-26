package dataBinding.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.differentlibraries.R
import com.example.differentlibraries.databinding.ActivityFirstBinding
import dataBinding.mvvm.core.User
import dataBinding.mvvm.ui.utils.Handlers

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityFirstBinding = DataBindingUtil.setContentView(this, R.layout.activity_first)
        val user = User("Constanza", "Morillo", 27)
        val list = listOf("Coti")
        val handler = Handlers(this)
        binding.user = user
        binding.list = list
        binding.handler = handler
    }
}