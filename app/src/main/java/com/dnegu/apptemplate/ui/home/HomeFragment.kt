package com.dnegu.apptemplate.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dnegu.apptemplate.R
import com.dnegu.apptemplate.common.*
import com.dnegu.apptemplate.databinding.FragmentHomeBinding
import com.dnegu.core.movie.Movie
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModelMovie: MovieListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModelMovie

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeToData()
        setupList()

        //viewModel.getAll()
        val id = 1
        viewModelMovie.getAll(id)
    }

    private fun subscribeToData() {
        /*viewModel.viewState.observe(viewLifecycleOwner, { viewState ->
            when (viewState) {
                is Loading -> emptyView.visibility = View.VISIBLE
                is Success -> {
                    if (viewState.data.isNotEmpty()) {
                        emptyView.visibility = View.GONE
                        showWorkersList(viewState.data)
                    }
                }
                is Error -> {
                    Toast.makeText(context, viewState.error.message, Toast.LENGTH_SHORT).show()
                }
                is NoInternetState -> {
                    Toast.makeText(context, "Offline", Toast.LENGTH_SHORT).show()
                }
            }
        })*/
        viewModelMovie.viewState.observe(viewLifecycleOwner, { viewState ->
            when (viewState) {
                is Loading -> emptyView.visibility = View.VISIBLE
                is Success -> {
                    if (viewState.data.isNotEmpty()) {
                        emptyView.visibility = View.GONE
                        showMoviesList(viewState.data)
                    }
                }
                is Error -> {
                    Toast.makeText(context, viewState.error.message, Toast.LENGTH_SHORT).show()
                }
                is NoInternetState -> {
                    Toast.makeText(context, "Offline", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setupList() {
        val divider = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        val linearLayoutManager = LinearLayoutManager(context)
        rvWorkers.layoutManager = linearLayoutManager
        rvWorkers.addItemDecoration(divider)
        rvWorkers.adapter = GenericAdapter()
    }

    private fun showMoviesList(data: List<Movie>) {
        val adapter = GenericAdapter()
        rvWorkers.adapter = adapter
        adapter.setItems(data)
    }
}