package com.textile.markeet.views.fragments

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.textile.markeet.helpers.AppPreference

open class BaseFragment : Fragment() {

    var appPreference: AppPreference? = null
    var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appPreference = AppPreference.getInstance(context)
        mProgressDialog = ProgressDialog(context)
        mProgressDialog?.setMessage("Loading")
        mProgressDialog?.setCancelable(false)
    }
//
//    fun setLayout(layout: Int) {
//        setContentView(layout)
//    }

    fun saveString(key: String, value: String) {
        appPreference?.setString(key, value)
    }

    fun getString(key: String): String? {
        return appPreference?.getString(key)
    }

    fun showProgressBar() {
        mProgressDialog?.show()
    }

    fun hideProgressBar() {
        mProgressDialog?.hide()
    }

}
