package dataBinding.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.differentlibraries.R
import com.example.differentlibraries.databinding.ActivityThirdBinding
import dataBinding.mvvm.core.Progress

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityThirdBinding = DataBindingUtil.setContentView(this, R.layout.activity_third)
        binding.model = Progress()
    }
}