package com.testspds.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.testspds.R
import com.testspds.model.Post
import com.testspds.model.TestData
import kotlinx.android.synthetic.main.data_list_item.view.*

class ListDataAdapter: RecyclerView.Adapter<ListDataAdapter.ViewHolder>(), Filterable {

    private var dataList: List<Post> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(dataService: Post) {

            if(!dataService.featuredImage.isNullOrEmpty()  ){
                Glide.with(itemView.context).load(dataService.featuredImage).into(itemView.img);
            }
        }
    }


    fun setAllDataItems(usertItems: TestData) {
        this.dataList = usertItems.posts
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }
}