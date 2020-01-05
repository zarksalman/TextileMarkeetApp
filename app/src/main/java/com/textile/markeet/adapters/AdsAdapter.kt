package com.textile.markeet.adapters

import AdsData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.textile.markeet.R
import kotlinx.android.synthetic.main.item_parent_category_layout.view.*

class AdsAdapter(val context: Context) :
    RecyclerView.Adapter<AdsAdapter.ParentCategoryViewHolder>() {

    private var adsDataList: List<AdsData> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentCategoryViewHolder {
        return ParentCategoryViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_parent_category_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ParentCategoryViewHolder, position: Int) {
        holder.setCategoryName(adsDataList[position].title)
    }

    override fun getItemCount(): Int {

        return adsDataList.size
    }

    fun setData(adsDataList: List<AdsData>) {

        this.adsDataList = adsDataList
        notifyDataSetChanged()
    }

    class ParentCategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val mView = view

        fun setCategoryName(title: String?) {

            title?.let {
                mView.tv_parent_category_name.text = title
            }
        }

    }
}