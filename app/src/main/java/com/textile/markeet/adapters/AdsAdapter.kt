package com.textile.markeet.adapters

import AdsData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.textile.markeet.R
import kotlinx.android.synthetic.main.item_ads_layout.view.*

class AdsAdapter(val context: Context) :
    RecyclerView.Adapter<AdsAdapter.ParentCategoryViewHolder>() {

    private var adsDataList: List<AdsData> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentCategoryViewHolder {
        return ParentCategoryViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_ads_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ParentCategoryViewHolder, position: Int) {
        holder.setTitle(adsDataList[position].title)
        holder.setContent(adsDataList[position].content)
        holder.setImage(adsDataList[position].images)
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

        fun setTitle(title: String?) {

            title?.let {
                mView.id_title_text.text = title

            }
        }

        fun setContent(content: String?) {

            content?.let {

                mView.id_content_text.text = content

            }
        }

        fun setImage(image: String?) {

            image?.let {


                //                Picasso.with(itemView.context) // give it the context
//                    .load(File(image)) // load the image
//                    .into(mView.id_popular_image) // select the ImageView to load it into
            }
        }

    }
}