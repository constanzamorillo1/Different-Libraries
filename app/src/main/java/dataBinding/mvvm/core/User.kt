package dataBinding.mvvm.core

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.differentlibraries.BR

data class User(
    val name: String,
    val lastName: String,
    val age: Int
)

class SecondUser : BaseObservable() {

    var name: String = ""
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }
}