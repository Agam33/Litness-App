package com.org.litness.ui.exercise.component

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.org.litness.base.MResult
import com.org.litness.data.repository.ExerciseRepository
import com.org.litness.databinding.DialogFragmentDetailExerciseBinding
import com.org.litness.ui.exercise.ExerciseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class DetailExerciseBottomSheet: BottomSheetDialogFragment() {

    @Inject lateinit var exerciseRepository: ExerciseRepository

    private var _binding: DialogFragmentDetailExerciseBinding? = null
    private val binding get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val id = arguments?.getInt(ExerciseFragment.EXTRA_ID) ?: -1
             exerciseRepository.getDetail(id).collect { res ->
                 when(res) {
                     is MResult.Success -> {
                         val data = res.data

                         Glide.with(this@DetailExerciseBottomSheet)
                             .load(data?.imgUrl)
                             .load(binding?.ivExercise)

                         binding?.tvExerciseTitle?.text = data?.title

                         binding?.tvSteps?.text = Html.fromHtml(data?.steps, Html.FROM_HTML_MODE_LEGACY)
                     }
                     else -> {}
                 }
             }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogFragmentDetailExerciseBinding.inflate(inflater, container, false)
        return _binding?.root
    }
}