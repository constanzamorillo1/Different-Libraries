package dataBinding.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.differentlibraries.R
import com.example.differentlibraries.databinding.ActivitySecondBinding
import dataBinding.mvvm.core.SecondUser

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySecondBinding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        val user = SecondUser()
        user.name = "Rodrigo"
        binding.user = user
    }
}