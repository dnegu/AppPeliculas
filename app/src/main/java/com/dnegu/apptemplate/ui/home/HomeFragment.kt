package com.dnegu.apptemplate.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dnegu.apptemplate.R
import com.dnegu.apptemplate.common.*
import com.dnegu.apptemplate.databinding.FragmentHomeBinding
import com.dnegu.core.movie.Movie
import com.dnegu.data.common.FIRSTPAGE
import com.dnegu.data.common.LASTPAGE
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), CellClickListener {

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
        var id = FIRSTPAGE
        viewModelMovie.getAll(id)

        btnAdd.setOnClickListener {
            id = nextPage(id)
            viewModelMovie.getAll(id)
        }

        btnMinus.setOnClickListener {
            id = prevPage(id)
            viewModelMovie.getAll(id)
        }
    }

    private fun subscribeToData() {
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
        rvWorkers.adapter = GenericAdapter(this)
    }

    private fun showMoviesList(data: List<Movie>) {
        val adapter = GenericAdapter(this)
        rvWorkers.adapter = adapter
        adapter.setItems(data)
    }

    private fun nextPage(id: Int): Int{
        return if(id == LASTPAGE) LASTPAGE
        else id+1
    }

    private fun prevPage(id: Int): Int{
        return if(id == FIRSTPAGE) FIRSTPAGE
        else id-1
    }

    override fun onCellClickListener(movie: Movie) {
        val bundle = Bundle()
        bundle.putSerializable("movie", movie)
        findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard,bundle)
    }
}