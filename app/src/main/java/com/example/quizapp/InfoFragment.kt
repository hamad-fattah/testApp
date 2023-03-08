package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.load
import kotlinx.android.synthetic.main.fragment_info.*
import kotlinx.android.synthetic.main.repository_list_row.view.*

class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args : InfoFragmentArgs by navArgs()
        val repository = args.selectedRepository
        name.text = repository.name
        date.text = repository.created_at
        count.text = repository.stargazers_count.toString()
        avatarImage.load(repository.owner.avatar_url)
    }

}