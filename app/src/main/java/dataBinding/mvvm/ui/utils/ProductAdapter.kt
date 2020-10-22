package dataBinding.mvvm.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.differentlibraries.databinding.ActivityLayoutItemBinding
import dataBinding.mvvm.core.Product

class ProductAdapter(private var products: MutableList<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private lateinit var listener: AdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
         ProductViewHolder(
             ActivityLayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
         )

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    fun updateProducts(newProducts: MutableList<Product>) {
        products.clear()
        products.addAll(newProducts)
        notifyDataSetChanged()
    }

    fun setAdapterListener(listener: AdapterListener) {
        this.listener = listener
    }

    inner class ProductViewHolder(private val productBinding: ActivityLayoutItemBinding) : RecyclerView.ViewHolder(productBinding.root) {
        fun bind(product: Product) {
            productBinding.product = product
            productBinding.root.setOnClickListener {
                productBinding.product?.let {
                    listener.onItemClick(it)
                }
            }
        }
    }
}

interface AdapterListener {

    fun onItemClick(model: Product)
}