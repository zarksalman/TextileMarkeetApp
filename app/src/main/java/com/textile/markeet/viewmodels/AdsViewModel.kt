package com.textile.markeet.viewmodels

import AdsDataContainer
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.textile.markeet.data.repository.Repository
import com.textile.markeet.data.repository.Repository.Companion.instance

class AdsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository = instance

    fun getLatestAds(sessionToken: String?): LiveData<AdsDataContainer> {
        return repository.getLatestAds(sessionToken!!)
    }

    fun getEndingSoonAds(sessionToken: String?): LiveData<AdsDataContainer> {
        return repository.getExpiryAds(sessionToken!!)
    }

}