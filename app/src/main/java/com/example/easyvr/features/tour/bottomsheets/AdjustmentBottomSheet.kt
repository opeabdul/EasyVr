package com.example.easyvr.features.tour.bottomsheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.DialogFragment
import com.example.easyvr.databinding.BottomSheetAdjustmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AdjustmentBottomSheet : BottomSheetDialogFragment(){
    var mListener: SheetClickListener? = null
    lateinit var mBinding: BottomSheetAdjustmentBinding

    companion object{
        fun instance(listener: SheetClickListener) =
            AdjustmentBottomSheet().apply {
                mListener = listener
            }
    }


    interface SheetClickListener{
        fun onClick()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = BottomSheetAdjustmentBinding.inflate(inflater)
        mBinding.minimiseImageView.setOnClickListener {
            dismiss()
        }

        mBinding.add.setOnClickListener{
            mListener?.onClick()
        }
        return mBinding.root
    }

    override fun onResume() {
        super.onResume()
        val actionBar = requireActivity().actionBar
        actionBar?.apply {
            hide()
        }
    }

    override fun onStop() {
        super.onStop()
        requireActivity().actionBar?.apply {
            show()
        }
    }
}