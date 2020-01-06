package com.textile.markeet.data.retrofit

import AdsDataContainer
import com.textile.markeet.data.models.categories.CategoriesDataContainer
import com.textile.markeet.data.models.categories.PopularCategoryDataContainer
import com.textile.markeet.data.models.signinup.SignInUpDataContainer

import retrofit2.Call
import retrofit2.http.*

interface ServiceApi {

    @GET
    fun testResponse(@Url url: String): Call<String>

    @POST("login")
    fun signinForm(@QueryMap parameters: Map<String, String>?): Call<SignInUpDataContainer>

    @POST("register")
    fun signupForm(@QueryMap parameters: Map<String, String>?): Call<SignInUpDataContainer>

    @GET("get_categories")
    fun getCategories(@Header("Authorization") auth: String): Call<CategoriesDataContainer>

    @GET("get_popular_categories")
    fun getpopularCategories(@Header("Authorization") auth: String): Call<PopularCategoryDataContainer>

    @GET("get_expiray_ads")
    fun getExpiryAds(@Header("Authorization") auth: String): Call<AdsDataContainer>

    @GET("get_latest_ads")
    fun getlatestAds(@Header("Authorization") auth: String): Call<AdsDataContainer>

}
