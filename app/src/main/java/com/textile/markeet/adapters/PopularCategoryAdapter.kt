package com.textile.markeet.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.textile.markeet.R
import com.textile.markeet.data.models.categories.PopularCategory
import kotlinx.android.synthetic.main.item_popular_layout.view.*

class PopularCategoryAdapter(val context: Context) :
    RecyclerView.Adapter<PopularCategoryAdapter.ParentCategoryViewHolder>() {

    private var popularCategoryList: List<PopularCategory> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentCategoryViewHolder {
        return ParentCategoryViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_popular_layout,
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ParentCategoryViewHolder, position: Int) {

        holder.setCategory(popularCategoryList[position])

        /*holder.setCategoryName(popularCategoryList[position].categoryString)
        holder.setContent(popularCategoryList[position].count)
        holder.setImageContent(holder.itemView, popularCategoryList[position].categoryIcon)*/
    }

    override fun getItemCount(): Int {

        return popularCategoryList.size
    }

    fun setData(parentCategoryList: List<PopularCategory>) {

        this.popularCategoryList = parentCategoryList
        notifyDataSetChanged()
    }

    class ParentCategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val mView = view
        val circularProgressDrawable = CircularProgressDrawable(mView.context)

        init {

            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()
        }

        fun setCategory(popularCategory: PopularCategory?) {

            popularCategory?.let {
                mView.tv_ads_title.text = it.categoryString
                mView.tv_ads_count.text = it.count

                Glide
                    .with(mView.context)
                    .load(it.categoryIcon)
                    .centerCrop()
                    .override(100, 100)
                    .placeholder(circularProgressDrawable)
                    .into(mView.iv_category_icon)
            }
        }
    }
}