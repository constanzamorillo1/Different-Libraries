package dataBinding.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.differentlibraries.R
import com.example.differentlibraries.databinding.ActivityFirstBinding
import dataBinding.mvvm.core.User

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityFirstBinding = DataBindingUtil.setContentView(this, R.layout.activity_first)
        val user = User("Constanza", "Morillo", 27)
        binding.user = user
    }
}