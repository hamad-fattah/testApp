package com.example.quizapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.adapter.RepositoryListAdapter
import com.example.quizapp.viewModel.RepositoryViewModel
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
        lateinit var recyclerAdapter : RepositoryListAdapter
        private val message : String = "error"

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
                view.repositoryListRV.layoutManager = LinearLayoutManager(activity)
                recyclerAdapter = RepositoryListAdapter()
                view.repositoryListRV.adapter = recyclerAdapter

        val viewModel : RepositoryViewModel = ViewModelProvider(this)[RepositoryViewModel::class.java]
        viewModel.getLiveDataObserver().observe(viewLifecycleOwner) {
            if (it != null) {
                recyclerAdapter.setRepositoryList((it))
                recyclerAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            }
        }
        viewModel.makeAPICall()
        recyclerAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("selected_repository",it)
            }
            findNavController().navigate(
                R.id.action_homeFragment_to_infoFragment,
                bundle
            )
        }


        return view
    }

}