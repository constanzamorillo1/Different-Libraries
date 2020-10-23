package dataBinding.mvvm.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.differentlibraries.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstActivity.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }

        secondActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        thirdActivity.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        recyclerActivity.setOnClickListener {
            startActivity(Intent(this, RecyclerActivity::class.java))
        }
    }
}