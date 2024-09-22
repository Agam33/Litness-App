package com.org.litness.ui.exercise.component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.TEXT_ALIGNMENT_CENTER
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.org.litness.R
import com.org.litness.base.MResult
import com.org.litness.data.repository.ExerciseRepository
import com.org.litness.databinding.DialogFragmentFilterExerciseBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FilterBottomSheet: BottomSheetDialogFragment() {

    @Inject lateinit var repository: ExerciseRepository

    private var _binding: DialogFragmentFilterExerciseBinding? = null
    private val binding get() = _binding

    interface OnSelectedChipsListener {
        fun onSelectedChips(list: List<Int>)
    }

    var onSelectedChipsListener: OnSelectedChipsListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when(val data = repository.getFocusAreas()) {
            is MResult.Success -> {
               for(focusArea in data.data ?: emptyList()) {
                   val chip = Chip(requireContext())
                   chip.text = focusArea.name
                   chip.isCheckable = true
                   chip.isChecked = false
                   chip.tag = focusArea.id
                   chip.textAlignment = TEXT_ALIGNMENT_CENTER
                   chip.chipStrokeWidth = 0f
                   chip.chipBackgroundColor = requireContext().getColorStateList(R.color.chip_bg)
                   binding?.chipGroup?.addView(chip)
               }
            }
            else -> Unit
        }

        with(binding!!) {
            btnDone.setOnClickListener {
                val chips = chipGroup.checkedChipIds.mapNotNull { chipId ->
                    val chip = root.findViewById<Chip>(chipId)
                    val id = chip.tag as Int
                    id
                }
                onSelectedChipsListener?.onSelectedChips(chips)
            }

            btnClear.setOnClickListener {
                chipGroup.clearCheck()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogFragmentFilterExerciseBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    companion object {
        const val FILTER_BOTTOM_SHEET = "filter-bottom-sheet"
    }
}