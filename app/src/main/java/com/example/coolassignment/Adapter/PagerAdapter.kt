package com.example.coolassignment.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

import com.example.coolassignment.Fragment.FlickrFragment
import com.example.coolassignment.Fragment.UserFragment

class PagerAdapter//Constructor to the class
(fm: FragmentManager, //integer to count number of tabs
 internal var tabCount: Int)//Initializing tab count
    : FragmentStatePagerAdapter(fm) {

    //Overriding method getItem
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                fragment =  UserFragment()
            }
            1 -> {
                fragment =  FlickrFragment()
            }
            /*2 -> {
                // val movieFragment = MovieFragment()
                return MovieFragment()
            }*/

        }
        return fragment!!
    }

    //Overriden method getCount to get the number of tabs
    override fun getCount(): Int {
        return tabCount
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "User"
            1 -> return "Flickr"
            /*case 2:
                Tab3 tab3 = new Tab3();
                return tab3;*/
            else -> return null
        }

    }
}
