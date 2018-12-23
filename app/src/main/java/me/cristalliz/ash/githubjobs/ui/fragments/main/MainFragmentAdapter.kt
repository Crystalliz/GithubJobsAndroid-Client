package me.cristalliz.ash.githubjobs.ui.fragments.main

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.cristalliz.ash.githubjobs.R
import me.cristalliz.ash.githubjobs.data.model.Position
import me.cristalliz.ash.githubjobs.databinding.MainItemBinding
import javax.inject.Inject

class MainFragmentAdapter @Inject constructor(): RecyclerView.Adapter<MainFragmentAdapter.ViewHolder>() {
    val items = ArrayList<Position>()

    var onItemClickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainFragmentAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)
        view.setOnClickListener(onItemClickListener)

        return ViewHolder(DataBindingUtil.bind(view)!!)
    }

    override fun onBindViewHolder(holder: MainFragmentAdapter.ViewHolder, position: Int) {
        holder.binding.position = items[position]
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(val binding: MainItemBinding) : RecyclerView.ViewHolder(binding.root)
}