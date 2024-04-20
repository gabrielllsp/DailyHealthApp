package com.gabriel.dailyhealthapp.util


import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.gabriel.dailyhealthapp.R

fun Fragment.initToolbar(
    toolbar: Toolbar,
    showIconNavigation: Boolean = true,
    lightIcon: Boolean = false,
) {

    val iconBack = if (lightIcon) R.drawable.ic_back_white else R.drawable.ic_back

    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title = ""

    if (showIconNavigation) {
        (activity as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(iconBack)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    toolbar.setNavigationOnClickListener {
        activity?.onBackPressedDispatcher?.onBackPressed()
    }

}