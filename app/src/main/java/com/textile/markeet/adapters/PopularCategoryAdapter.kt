package com.textile.markeet.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
        holder.setCategoryName(popularCategoryList[position].categoryString)
        holder.setContent(popularCategoryList[position].count)
        holder.setImageContent(holder.itemView, popularCategoryList[position].categoryIcon)
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

        fun setCategoryName(name: String?) {

            name?.let {
                mView.id_title_text.text = name

            }
        }

        fun setContent(contentText: String?) {

            contentText?.let {
                mView.id_content_text.text = contentText

            }
        }

        fun setImageContent(itemView: View, categoryString: String?) {


//            Picasso.with(itemView.context) // give it the context
//                .load(File(categoryString)) // load the image
//                .into(mView.id_popular_image) // select the ImageView to load it into

        }

//        fun setImageContent(contentText: String?) {
//
//            Picasso.with()
//                .placeholder(R.mipmap.ic_launcher) // give it the context
//                .load(contentText) // load the image
//                .into(mView.id_popular_image) // select the ImageView to load it into
//
//
//        }

    }
}