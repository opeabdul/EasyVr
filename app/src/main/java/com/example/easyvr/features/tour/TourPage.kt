package com.example.easyvr.features.tour

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.easyvr.R
import com.example.easyvr.databinding.FragmentTourPageBinding
import com.example.easyvr.features.tour.bottomsheets.AdjustmentBottomSheet
import com.example.easyvr.features.tour.bottomsheets.FilterListBottomSheet
import com.example.easyvr.features.tour.bottomsheets.WebsiteBottomSheet
import com.example.easyvr.features.tour.dialogs.UploadDialog
import com.example.easyvr.utils.getFilterList
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass.
 */
class TourPage : Fragment(), AdjustmentBottomSheet.SheetClickListener, WebsiteBottomSheet.SheetClickListener{
    lateinit var mBinding: FragmentTourPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentTourPageBinding.inflate(inflater)
        mBinding.binocularsImageView.setOnClickListener {
            AdjustmentBottomSheet.instance(this)
                .show(requireActivity().supportFragmentManager, "AdjustmentSheet")
        }

        mBinding.cancel.setOnClickListener {
            WebsiteBottomSheet.instance(this)
                .show(requireActivity().supportFragmentManager, "WebsiteBottomSheet")
        }

        mBinding.icon360.setOnClickListener {
            FilterListBottomSheet.newInstance(getFilterList())
                .show(requireActivity().supportFragmentManager, "FilterSheet")
        }

        return mBinding.root
    }

    override fun onClick() {
        Snackbar.make(mBinding.root, "Adjustment Bottom Sheet Clicked", Snackbar.LENGTH_SHORT).show()
    }

    override fun onclick() {
        Snackbar.make(mBinding.root, "Website Bottom Sheet Clicked", Snackbar.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        requireActivity().actionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        requireActivity().actionBar?.show()
    }
}
