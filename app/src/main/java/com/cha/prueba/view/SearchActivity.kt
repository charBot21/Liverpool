package com.cha.prueba.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cha.prueba.R
import com.cha.prueba.adapter.ItemsAdapter
import com.cha.prueba.data.network.model.Record
import com.cha.prueba.databinding.ActivitySearchBinding
import com.cha.prueba.model.interfaces.SearchListener
import com.cha.prueba.utils.hide
import com.cha.prueba.utils.show
import com.cha.prueba.utils.toast
import com.cha.prueba.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity(), SearchListener {

    private lateinit var viewModel  : SearchViewModel
    private lateinit var binding    : ActivitySearchBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: ItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView( this, R.layout.activity_search )
        viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        binding.searchvm = viewModel
        viewModel.searchListener = this

        recyclerView = findViewById(R.id.rv_list_items)
        layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    override fun onStarted() {
        search_progress.show()
    }

    override fun onSuccess(records: List<Record>) {
        search_progress.hide()
        recyclerView.layoutManager = layoutManager
        adapter = ItemsAdapter(records)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onFailure(errorCode: Int) {
        val errorMessageConnection = getString(R.string.error_connection)
        val emptyField = getString(R.string.empty_field)

        search_progress.hide()

        if ( errorCode == 1 ) {
            toast(emptyField)
        } else if ( errorCode == 2 ) {
            toast(errorMessageConnection)
        }
    }
}