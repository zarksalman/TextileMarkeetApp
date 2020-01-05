package com.textile.markeet.data.models.categories

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PopularCategoryDataContainer {
    @SerializedName("data")
    @Expose
    var popularCategory: List<PopularCategory>? = null
    @SerializedName("code")
    @Expose
    var code: Int? = null
    @SerializedName("message")
    @Expose
    var message: String? = null

}