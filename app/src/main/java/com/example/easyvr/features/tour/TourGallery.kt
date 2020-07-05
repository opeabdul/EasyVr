package com.example.easyvr.features.tour

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.easyvr.R
import com.example.easyvr.databinding.TourGalleryBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class TourGallery : Fragment() {
    lateinit var mBinding: TourGalleryBinding
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = TourGalleryBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.tuneImageView.setOnClickListener {
            findNavController().navigate(R.id.tour_gallery_to_add_description)
        }
    }
}
