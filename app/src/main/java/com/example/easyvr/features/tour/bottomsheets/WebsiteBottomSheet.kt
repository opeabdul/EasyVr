package com.example.easyvr.features.tour.bottomsheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easyvr.databinding.BottomSheetWebsiteBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class WebsiteBottomSheet: BottomSheetDialogFragment() {
    var mListener: SheetClickListener? = null
    lateinit var mBinding: BottomSheetWebsiteBinding

    companion object{
        fun instance(listener: SheetClickListener) =
            WebsiteBottomSheet().apply {
                mListener = listener
            }
    }

    interface SheetClickListener{
        fun onclick()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = BottomSheetWebsiteBinding.inflate(inflater)
        mBinding.confirmButton.setOnClickListener {
            mListener?.onclick()
        }
        return  mBinding.root
    }

}