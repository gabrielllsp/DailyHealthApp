package com.gabriel.dailyhealthapp.util


import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.gabriel.dailyhealthapp.R
import com.gabriel.dailyhealthapp.databinding.LayoutBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

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

fun Fragment.showButtonSheet(
    titleDialog: Int? = null,
    titleButton: Int? = null,
    message: String?,
    onClick: () -> Unit = {}
) {
    val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)
    val bottomSheetBinding: LayoutBottomSheetBinding =
        LayoutBottomSheetBinding.inflate(layoutInflater, null, false)

    bottomSheetBinding.textTitle.text = getString(titleDialog ?: R.string.text_title_bottom_sheet)
    bottomSheetBinding.textMessage.text = message
    bottomSheetBinding.btnOk.text = getString(titleDialog ?: R.string.text_button_bottom_sheet)

    bottomSheetBinding.btnOk.setOnClickListener {
        bottomSheetDialog.dismiss()
        onClick()
    }

    bottomSheetDialog.setContentView(bottomSheetBinding.root)
    bottomSheetDialog.show()
}