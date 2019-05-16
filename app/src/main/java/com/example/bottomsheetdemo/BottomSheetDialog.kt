package com.example.bottomsheetdemo

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_bottom_sheet.*

class BottomSheetDialog : BottomSheetDialogFragment() {
    private lateinit var bottomSheetInterface: BottomSheetInterface

    fun setBottomSheetInterface(bottomSheetInterface: BottomSheetInterface) {
        this.bottomSheetInterface = bottomSheetInterface
    }

//    @SuppressLint("RestrictedApi")
//    override fun setupDialog(dialog: Dialog?, style: Int) {
//        super.setupDialog(dialog, style)
//        val contentView = View.inflate(context!!, R.layout.layout_bottom_sheet, null)
//        dialog!!.setContentView(contentView)
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val contentView = inflater.inflate(R.layout.layout_bottom_sheet, container, false)
        return contentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() {
        idBtEnableMultiSelect.setOnClickListener {
            bottomSheetInterface.onButtonClick(0)
            dismiss()
        }

        idBtDeleteAll.setOnClickListener {
            bottomSheetInterface.onButtonClick(1)
            dismiss()
        }
    }
}