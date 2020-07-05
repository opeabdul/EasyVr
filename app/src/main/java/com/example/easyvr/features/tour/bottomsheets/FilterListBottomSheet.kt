package com.example.easyvr.features.tour.bottomsheets

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.easyvr.R
import com.example.easyvr.features.tour.adapters.FilterAdapter
import com.example.easyvr.model.Filter
import kotlinx.android.synthetic.main.fragment_filter_list_bottom_sheet.*
import kotlinx.android.synthetic.main.item_filter_list_bottom_sheet.view.*

// TODO: Customize parameter argument names
const val ARG_ITEM_COUNT = "item_count"

/**
 *
 * A fragment that shows a list of items as a modal bottom sheet.
 *
 */
class FilterListBottomSheet : BottomSheetDialogFragment() {

    var mFilterList = listOf<Filter>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filter_list_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = FilterAdapter()
        adapter.submitList(mFilterList)
        list.adapter = adapter
    }


    companion object {

        // TODO: Customize parameters
        fun newInstance(filters: List<Filter>): FilterListBottomSheet =
            FilterListBottomSheet().apply {
                    mFilterList = filters
            }

    }
}
