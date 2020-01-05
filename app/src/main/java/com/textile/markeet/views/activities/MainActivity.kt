package com.textile.markeet.views.activities

import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.textile.markeet.R
import com.textile.markeet.views.fragments.DashboardFragment
import com.textile.markeet.views.fragments.HomeFragment
import com.textile.markeet.views.fragments.NotificationFragment

class MainActivity : BaseActivity() {
    private var mFragmentManager: FragmentManager? = null
    private var fragmentTransaction: FragmentTransaction? = null
    private var oldFragment: Fragment? = null
    private var fragment: Fragment? = null

    private lateinit var textMessage: TextView

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->

            var fragment: Fragment? = null
            val fragmentTransaction = mFragmentManager!!.beginTransaction()

            when (item.itemId) {


                R.id.navigation_home -> {
                    textMessage.setText(R.string.title_home)

                    fragment = mFragmentManager!!.findFragmentByTag(HomeFragment::class.java!!.getName())

                    if (fragment == null) {
                        fragment = HomeFragment(this)
                        fragmentTransaction.replace(R.id.dashboard_fragment_container, fragment)

                        fragmentTransaction.commit()
                    }

                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    textMessage.setText(R.string.title_dashboard)


                    fragment = mFragmentManager!!.findFragmentByTag(DashboardFragment::class.java!!.getName())

                    if (fragment == null) {
                        fragment = DashboardFragment(this)
                        fragmentTransaction.replace(R.id.dashboard_fragment_container, fragment)

                        fragmentTransaction.commit()
                    }

                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    textMessage.setText(R.string.title_notifications)
                    fragment = mFragmentManager!!.findFragmentByTag(NotificationFragment::class.java!!.getName())

                    if (fragment == null) {
                        fragment = NotificationFragment(this)
                        fragmentTransaction.replace(R.id.dashboard_fragment_container, fragment)

                        fragmentTransaction.commit()
                    }

//                    startActivity(Intent(this, SigninActivity::class.java))
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setLayout(R.layout.activity_main)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)


        mFragmentManager = supportFragmentManager
        fragmentTransaction = mFragmentManager!!.beginTransaction()

        if (savedInstanceState == null) {
            fragment =
                mFragmentManager!!.findFragmentByTag(HomeFragment::class.java!!.getName())
            if (fragment == null) {
                fragment = HomeFragment(this)
            }
            //    fragmentTransaction!!.setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            fragment?.let {
                fragmentTransaction!!.add(
                    R.id.dashboard_fragment_container, it, fragment!!.javaClass.getName()
                )
            }
            oldFragment = fragment
            fragmentTransaction!!.commit()
        }
    }


}
