package dataBinding.mvvm.ui.utils

import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

@BindingAdapter("setProgress")
fun setProgress(view: ProgressBar, progress: String) {
     if (progress.isNotEmpty()) {
         view.progress = progress.toInt()
     } else {
         view.progress = 0
     }
}