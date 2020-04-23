package com.example.coolassignment.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

import com.example.coolassignment.Fragment.FlickrFragment
import com.example.coolassignment.Fragment.UserFragment
import com.example.coolassignment.Fragment.InfoFragment

class PagerAdapter
(fm: FragmentManager,
 internal var tabCount: Int)
    : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                fragment =  UserFragment()
            }
            1 -> {
                fragment =  FlickrFragment()
            }
            2 -> {
                fragment = InfoFragment()
            }

        }
        return fragment!!
    }

    override fun getCount(): Int {
        return tabCount
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "User"
            1 -> return "Flickr"
            2 -> return "Info"
            else -> return null
        }

    }
}
