package dataBinding.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.differentlibraries.R
import com.example.differentlibraries.databinding.ActivityDetailBinding
import dataBinding.mvvm.core.Product

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        intent.extras?.let { extras ->
            val model = extras.get("PRODUCT") as Product
            binding.product = model
        }
    }
}
