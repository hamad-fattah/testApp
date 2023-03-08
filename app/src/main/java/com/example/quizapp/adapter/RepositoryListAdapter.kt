package com.example.quizapp.adapter

import coil.load
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.data.RepositoryModel
import kotlinx.android.synthetic.main.repository_list_row.view.*

class RepositoryListAdapter: RecyclerView.Adapter<RepositoryListAdapter.MyViewHolder>() {

    private var repositoryList : List<RepositoryModel>? = null

    fun setRepositoryList(repositoryList : List<RepositoryModel>?){
        this.repositoryList = repositoryList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repository_list_row,parent,false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(repositoryList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return if(repositoryList == null ) 0
        else repositoryList?.size!!
    }

    class MyViewHolder(view:View): RecyclerView.ViewHolder(view) {
        val repositoryName: TextView? = view.name
        val repositoryDate: TextView? = view.date
        val repositoryAvatar : ImageView? = view.avatarImage

        fun bind(data : RepositoryModel){
            repositoryName?.text = data.name
            repositoryDate?.text = data.created_at
            val repositoryAvatar = data.owner?.avatar_url
            itemView.avatarImage.load(repositoryAvatar)

        }

    }
    private var onItemClickListener : ((RepositoryModel)->Unit)? = null

    fun setOnItemClickListener(listener : (RepositoryModel)->Unit){
        onItemClickListener = listener
    }
}