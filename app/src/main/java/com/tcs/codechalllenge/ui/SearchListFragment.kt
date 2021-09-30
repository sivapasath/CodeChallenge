package com.tcs.codechalllenge.ui

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tcs.codechalllenge.R
import com.tcs.codechalllenge.adapter.SearchListAdapter
import com.tcs.codechalllenge.databinding.FragmentListBinding

class SearchListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var listViewModel: SearchListViewModel
    private lateinit var searchListAdapter : SearchListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.mRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)
        searchListAdapter = SearchListAdapter()
        recyclerView.adapter = searchListAdapter
        listViewModel = ViewModelProvider(this).get(SearchListViewModel::class.java)
        listViewModel.mSearchList.observe(viewLifecycleOwner, Observer {
            searchListAdapter.addList(it)
        })
        listViewModel.errorResponse.observe(viewLifecycleOwner, {
            val builder = AlertDialog.Builder(this.context)
            builder.setTitle("Error")
            builder.setMessage("Something went wrong please try again later.")
            builder.setPositiveButton(android.R.string.yes) { _, _ -> }
            builder.show()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.menu_main, menu)
        val search = menu.findItem(R.id.action_search)
        val searchView = search.actionView as SearchView
        searchView.queryHint = "Search"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText?.length!! > 0) {
                    listViewModel.getSearchList(newText)
                }
                return true
            }
        })
    }
}