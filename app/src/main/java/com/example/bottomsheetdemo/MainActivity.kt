package com.example.bottomsheetdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_bottom_sheet.*

class MainActivity : AppCompatActivity(), BottomSheetInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
    }

    private fun setListener() {
        idFabShowSheet.setOnClickListener {
            //Commented lines are used to show BottomSheet with the help of BottomSheetHelper class
//            val bottomSheet = BottomSheetDialog()
//            bottomSheet.setBottomSheetInterface(this)
//            bottomSheet.show(supportFragmentManager, bottomSheet.tag)

            val bottomSheetDialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.layout_bottom_sheet, null)
            bottomSheetDialog.setContentView(view)
            bottomSheetDialog.setOnShowListener { dialog ->
                val bottomSheet = (dialog as BottomSheetDialog).findViewById<View>(android.support.design.R.id.design_bottom_sheet) as FrameLayout?
                val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet!!)
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
            bottomSheetDialog.show()

            bottomSheetDialog.idBtEnableMultiSelect.setOnClickListener {
                Toast.makeText(applicationContext, "|-/", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()
            }
            bottomSheetDialog.idBtDeleteAll.setOnClickListener {
                Toast.makeText(applicationContext, "||-//", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()
            }
        }
    }

    override fun onButtonClick(option: Int) {
        when (option) {
            0 -> Toast.makeText(applicationContext, "|-/", Toast.LENGTH_SHORT).show()
            1 -> Toast.makeText(applicationContext, "||-//", Toast.LENGTH_SHORT).show()
        }
    }
}
