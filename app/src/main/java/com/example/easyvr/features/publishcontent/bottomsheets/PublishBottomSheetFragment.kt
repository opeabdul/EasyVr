package com.example.easyvr.features.publishcontent.bottomsheets

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easyvr.databinding.BottomSheetPublishBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PublishBottomSheetFragment : BottomSheetDialogFragment() {
    private var mListener: BottomSheetListener? = null
    lateinit var mBinding: BottomSheetPublishBinding

    interface BottomSheetListener{

        fun onWhatsappClicked()
        fun onYoutubeClicked()
        fun onInstagramClicked()

    }

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        mBinding = BottomSheetPublishBinding.inflate(inflater)

        mBinding.instagramImageView.setOnClickListener {
            mListener!!.onInstagramClicked()
            dismiss()
        }

        mBinding.whatsappImageView.setOnClickListener {
            mListener!!.onWhatsappClicked()
            dismiss()
        }

        mBinding.youtubeImageView.setOnClickListener {
            mListener!!.onYoutubeClicked()
            dismiss()
        }

        mBinding.cancel.setOnClickListener {
            dismiss()
        }
        return mBinding.root
    }

    companion object{
        fun newInstance(listener: BottomSheetListener) =
            PublishBottomSheetFragment().apply {
            mListener = listener
        }
    }

}