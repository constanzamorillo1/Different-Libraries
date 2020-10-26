package dataBinding.mvvm.ui.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.BindingAdapter

@BindingAdapter("setProgress")
fun setProgress(view: ProgressBar, progress: String) {
    view.progress = if (progress.isNotEmpty()) progress.toInt() else 0
}


class Handlers (val context: Context) {
    fun onClickTextView(view: View) {
        Toast.makeText(context, "Cotiiii", Toast.LENGTH_LONG).show()
    }
}