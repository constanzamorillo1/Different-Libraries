package dataBinding.mvvm.core

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.differentlibraries.BR

class Progress : BaseObservable() {

    var progress: String = "0"
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.progress)
        }
}