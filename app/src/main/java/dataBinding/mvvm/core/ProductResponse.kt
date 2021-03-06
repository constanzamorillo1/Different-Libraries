package dataBinding.mvvm.core

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductResponse(
    @SerializedName("results") val results: MutableList<Product>
) : Serializable