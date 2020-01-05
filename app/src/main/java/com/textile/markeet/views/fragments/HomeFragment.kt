package com.textile.markeet.views.fragments

import AdsData
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabLayout
import com.textile.markeet.R
import com.textile.markeet.adapters.AdsAdapter
import com.textile.markeet.adapters.PopularCategoryAdapter
import com.textile.markeet.data.models.categories.PopularCategory
import com.textile.markeet.helpers.AppConstants
import com.textile.markeet.viewmodels.AdsViewModel
import com.textile.markeet.viewmodels.PopularCategoryViewModel
import com.textile.markeet.views.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*


class HomeFragment(mainActivity: MainActivity) : BaseFragment() {
    private var popularCategoryAdapter: PopularCategoryAdapter? = null
    private var popularCategoryViewModel: PopularCategoryViewModel? = null
    private var adsViewModel: AdsViewModel? = null

    var mcontext = mainActivity
    private val TAG = "HomeFragment"
    private var popularCategoryList: List<PopularCategory>? = null
    private var latestAdsList: List<AdsData>? = null
    private var endingSoonAdsList: List<AdsData>? = null

    private var token: String? = null

    private lateinit var adsAdapter: AdsAdapter

//    var tabLayout: TabLayout? = null
//    var recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val firstTab = tb_ads!!.newTab()
        firstTab.text = "Latest Ads"

        tb_ads!!.addTab(firstTab) // add  the tab at in the TabLayout
        val secondTab = tb_ads!!.newTab()
        secondTab.text = "Ending Soon Ads" // set the Text for the second Tab
        tb_ads!!.addTab(secondTab) // add  the tab  in the TabLayout

        /* var adapter = PagerAdapter(mcontext, fragmentManager, tb_ads?.getTabCount())
         simpleViewPager?.adapter = adapter
        */ // addOnPageChangeListener event change the tab on slide

        tb_ads?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                //  vp_ads?.currentItem = p0?.position ?: 0

                if (p0?.position == 0) {
                    latestAdsList?.let {
                        adsAdapter.setData(it)
                    }
                } else {
                    endingSoonAdsList?.let {
                        adsAdapter.setData(it)
                    }
                }
            }
        })

        token = getString(AppConstants.TOKEN)

        popularCategoryViewModel =
            ViewModelProviders.of(this).get(PopularCategoryViewModel::class.java)
        adsViewModel =
            ViewModelProviders.of(this).get(AdsViewModel::class.java)

        initAdapter()
        getPopularCategories()


    }

    private fun initAdapter() {

        popularCategoryAdapter = PopularCategoryAdapter(mcontext)
        recyclerview.layoutManager = GridLayoutManager(context, 2)
        recyclerview.adapter = popularCategoryAdapter

        adsAdapter = AdsAdapter(mcontext)
        adsAdapter = AdsAdapter(mcontext)


        rv_latest_ending_ads.layoutManager = GridLayoutManager(context, 2)
        rv_latest_ending_ads.adapter = adsAdapter
    }

    private fun getPopularCategories() {

//        popularCategoryViewModel!!.getAllParentCategories(token).observe(this, Observer())

        popularCategoryViewModel?.getAllParentCategories(token)
            ?.observe(this, Observer { popularDataCategoryContainer ->
                if (popularDataCategoryContainer != null) {

                    popularCategoryList = popularDataCategoryContainer.popularCategory

                    popularCategoryList?.let {
                        popularCategoryAdapter?.setData(it)
                    }
                }
                getLatestAds()
            })
    }

    private fun getLatestAds() {

        adsViewModel?.getLatestAds(token)
            ?.observe(this, Observer { adsDataContainer ->
                if (adsDataContainer != null) {
                    latestAdsList = adsDataContainer.data

                    latestAdsList?.let {
                        adsAdapter.setData(it)
                    }
                }

                getEndingSoon()
            })
    }

    private fun getEndingSoon() {

        adsViewModel?.getEndingSoonAds(token)
            ?.observe(this, Observer { adsDataContainer ->
                if (adsDataContainer != null) {
                    endingSoonAdsList = adsDataContainer.data

                    endingSoonAdsList?.let {

                        /*           val geocoder = Geocoder(context, Locale.getDefault())

                                   val addresses: List<Address> =
                                       geocoder.getFromLocation(
                                           it[0].dataDetail[0].latitude.toDouble(),
                                           it[0].dataDetail[0].longitude.toDouble(),
                                           1
                                       )
                                   val cityName: String = addresses[0].getAddressLine(0)
                                   val stateName: String = addresses[0].getAddressLine(1)
                                   val countryName: String = addresses[0].getAddressLine(2)*/

                        //      Log.d("city_name", "$cityName : $stateName : $countryName")

                    }

                }
                hideProgressBar()
            })
    }

}
