package com.textile.markeet.data.repository

import AdsDataContainer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.textile.markeet.data.models.categories.CategoriesDataContainer
import com.textile.markeet.data.models.categories.PopularCategoryDataContainer
import com.textile.markeet.data.models.signinup.SignInUpDataContainer
import com.textile.markeet.data.retrofit.RetrofitClient
import com.textile.markeet.data.retrofit.ServiceApi
import com.textile.markeet.helpers.AppConstants
import com.textile.markeet.helpers.AppPreference
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repository private constructor() {
    private val serviceApi: ServiceApi = RetrofitClient.getInstance().createClient()
    internal lateinit var signInUpDataContainerMutableLiveData: MutableLiveData<SignInUpDataContainer>
    internal lateinit var categoriesDataContainer: MutableLiveData<CategoriesDataContainer>
    internal lateinit var popularCategoryDataContainer: MutableLiveData<PopularCategoryDataContainer>
    internal lateinit var adsDataContainer: MutableLiveData<AdsDataContainer>
    internal lateinit var latestAdsDataContainer: MutableLiveData<AdsDataContainer>


    companion object {

        private var repository: Repository? = null

        internal var token: String? = null

        val instance: Repository
            get() {
                if (repository == null) {
                    repository = Repository()
                }

                return repository!!
            }
    }

    fun signinForm(parameters: Map<String, String>): LiveData<SignInUpDataContainer> {

        signInUpDataContainerMutableLiveData = MutableLiveData()

        serviceApi.signinForm(parameters).enqueue(object : Callback<SignInUpDataContainer> {
            override fun onResponse(
                call: Call<SignInUpDataContainer>,
                response: Response<SignInUpDataContainer>
            ) {
                if (response.isSuccessful) {
                    signInUpDataContainerMutableLiveData.postValue(response.body())
                } else
                    signInUpDataContainerMutableLiveData.postValue(null)
            }

            override fun onFailure(call: Call<SignInUpDataContainer>, t: Throwable) {
                signInUpDataContainerMutableLiveData.postValue(null)
            }
        })

        return signInUpDataContainerMutableLiveData
    }

    fun signupForm(parameters: Map<String, String>): LiveData<SignInUpDataContainer> {

        signInUpDataContainerMutableLiveData = MutableLiveData()

        serviceApi.signupForm(parameters).enqueue(object : Callback<SignInUpDataContainer> {
            override fun onResponse(
                call: Call<SignInUpDataContainer>,
                response: Response<SignInUpDataContainer>
            ) {

                if (response.isSuccessful) {
                    signInUpDataContainerMutableLiveData.postValue(response.body())
                } else
                    signInUpDataContainerMutableLiveData.postValue(null)
            }

            override fun onFailure(call: Call<SignInUpDataContainer>, t: Throwable) {
                signInUpDataContainerMutableLiveData.postValue(null)
            }
        })

        return signInUpDataContainerMutableLiveData
    }

    fun getAllParentCategories(parameters: String): LiveData<CategoriesDataContainer> {

        categoriesDataContainer = MutableLiveData()

        serviceApi.getCategories(parameters).enqueue(object : Callback<CategoriesDataContainer> {

            override fun onResponse(
                call: Call<CategoriesDataContainer>,
                response: Response<CategoriesDataContainer>
            ) {

                if (response.isSuccessful) {
                    categoriesDataContainer.postValue(response.body())
                } else {
                    categoriesDataContainer.postValue(null)
                }
            }

            override fun onFailure(call: Call<CategoriesDataContainer>, t: Throwable) {
                categoriesDataContainer.postValue(null)
            }
        })

        return categoriesDataContainer
    }

    fun getAllPopularCategory(parameters: String): LiveData<PopularCategoryDataContainer> {

        popularCategoryDataContainer = MutableLiveData()

        serviceApi.getpopularCategories(parameters)
            .enqueue(object : Callback<PopularCategoryDataContainer> {

                override fun onResponse(
                    call: Call<PopularCategoryDataContainer>,
                    response: Response<PopularCategoryDataContainer>
                ) {

                    if (response.isSuccessful) {
                        popularCategoryDataContainer.postValue(response.body())
                    } else {
                        popularCategoryDataContainer.postValue(null)
                    }
                }

                override fun onFailure(call: Call<PopularCategoryDataContainer>, t: Throwable) {
                    popularCategoryDataContainer.postValue(null)
                }
            })


        return popularCategoryDataContainer

    }

    fun getExpiryAds(sessionToken: String): LiveData<AdsDataContainer> {

        adsDataContainer = MutableLiveData()

        serviceApi.getExpiryAds(sessionToken).enqueue(object : Callback<AdsDataContainer> {

            override fun onResponse(
                call: Call<AdsDataContainer>, response: Response<AdsDataContainer>
            ) {

                if (response.isSuccessful) {
                    adsDataContainer.postValue(response.body())
                } else {
                    adsDataContainer.postValue(null)
                }
            }


            override fun onFailure(call: Call<AdsDataContainer>, t: Throwable) {
                adsDataContainer.postValue(null)
            }
        })


        return adsDataContainer

    }

    fun getLatestAds(sessionToken: String): LiveData<AdsDataContainer> {

        latestAdsDataContainer = MutableLiveData()

        serviceApi.getlatestAds(sessionToken).enqueue(object : Callback<AdsDataContainer> {

            override fun onResponse(
                call: Call<AdsDataContainer>, response: Response<AdsDataContainer>
            ) {

                if (response.isSuccessful) {
                    latestAdsDataContainer.postValue(response.body())
                } else {
                    latestAdsDataContainer.postValue(null)
                }
            }


            override fun onFailure(call: Call<AdsDataContainer>, t: Throwable) {
                latestAdsDataContainer.postValue(null)
            }
        })


        return latestAdsDataContainer

    }

}