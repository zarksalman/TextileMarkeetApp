package com.textile.markeet.data.models.categories

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PopularCategory {

    @SerializedName("category")
    @Expose
    var categoryString: String? = null
    @SerializedName("category_icon")
    @Expose
    var categoryIcon: String? = null
    @SerializedName("count")
    @Expose
    var count: String? = null

}