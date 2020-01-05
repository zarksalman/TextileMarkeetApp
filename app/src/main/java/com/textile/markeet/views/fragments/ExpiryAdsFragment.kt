package com.textile.markeet.views.fragments

import AdsData
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.textile.markeet.R
import com.textile.markeet.adapters.AdsAdapter
import com.textile.markeet.helpers.AppConstants
import com.textile.markeet.viewmodels.ExpiryAdsViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class ExpiryAdsFragment(context: Context) : BaseFragment() {

    private var adsAdapter: AdsAdapter? = null
    var mcontext = context
    private val TAG = "ExpiryAdsFragment"
    private var expiryAdsViewModel: ExpiryAdsViewModel? = null
    private var adsDataContainerList: List<AdsData>? = null
    private var token: String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ending_layout, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        token = getString(AppConstants.TOKEN)


        expiryAdsViewModel =
            ViewModelProviders.of(this).get(ExpiryAdsViewModel::class.java)
        initAdapter()
        getExpiryAds()


    }

    private fun initAdapter() {

        adsAdapter = AdsAdapter(mcontext)
        recyclerview.layoutManager =GridLayoutManager(context, 2)
            //LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recyclerview.adapter = adsAdapter
    }

    private fun getExpiryAds() {


        expiryAdsViewModel?.getExpiryAdsCategories(token)
            ?.observe(this, Observer { expiryAdsContainer ->
                if (expiryAdsContainer != null) {

                    adsDataContainerList = expiryAdsContainer.data

                    adsDataContainerList?.let {
                        adsAdapter?.setData(it)
                    }
                    //    Log.d(TAG, popularDataCategoryContainer.message)
                }
                hideProgressBar()
            })
    }


}
