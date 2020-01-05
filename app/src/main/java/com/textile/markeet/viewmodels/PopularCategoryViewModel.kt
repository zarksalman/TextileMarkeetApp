package com.textile.markeet.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.textile.markeet.data.models.categories.PopularCategoryDataContainer
import com.textile.markeet.data.repository.Repository
import com.textile.markeet.data.repository.Repository.Companion.instance

class PopularCategoryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository = instance

    fun getAllParentCategories(sessionToken: String?): LiveData<PopularCategoryDataContainer> {
        return repository.getAllPopularCategory(sessionToken!!)
    }

}