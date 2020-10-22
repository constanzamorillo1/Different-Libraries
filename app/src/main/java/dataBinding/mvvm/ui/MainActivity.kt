package dataBinding.mvvm.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tesis.R
import kotlinx.android.synthetic.main.activity_main.*
import dataBinding.mvvm.core.Product
import dataBinding.mvvm.domain.ProductRepository
import dataBinding.mvvm.ui.utils.AdapterListener
import dataBinding.mvvm.ui.utils.ProductAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ProductsViewModel
    private lateinit var factory: ProductsViewModelFactory
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = TITLE
        factory = ProductsViewModelFactory(ProductRepository())
        viewModel = ViewModelProvider(this, factory).get(ProductsViewModel::class.java)
        init()
    }

    private fun init() {
        recyclerViewComponents()
        viewModel.products.observe(this, { state ->
            when (state) {
                is State.SuccessState -> {
                    adapter.updateProducts(state.value.results)
                }
                is State.ErrorState -> {
                    // Nothing here
                }
            }
        })

        viewModel.loading.observe(this, { state ->
            progressBar.visibility = when(state) {
                is State.Loading.Hide -> {
                    View.INVISIBLE
                }
                is State.Loading.Show -> {
                    View.VISIBLE
                }
            }
        })

        searchButton.setOnClickListener {
            viewModel.getProducts(searchText.text.toString())
        }
    }

    private fun recyclerViewComponents() {
        val layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = ProductAdapter(mutableListOf())
        adapter.setAdapterListener(object: AdapterListener{
            override fun onItemClick(model: Product) {
                val bundle = Bundle()
                bundle.putSerializable(KEY, model)
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, layoutManager.orientation))

    }

    companion object {
        private const val KEY = "PRODUCT"
        private const val TITLE = "Test"
    }
}
