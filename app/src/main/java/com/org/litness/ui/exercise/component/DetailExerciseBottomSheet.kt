package com.org.litness.ui.exercise.component

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.org.litness.base.MResult
import com.org.litness.data.repository.UserRepository
import com.org.litness.databinding.DialogFragmentDetailExerciseBinding
import com.org.litness.ui.exercise.ExerciseFragment
import com.org.litness.ui.exercise.model.Exercise
import com.org.litness.ui.profile.model.User
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class DetailExerciseBottomSheet: BottomSheetDialogFragment() {

    @Inject lateinit var userRepository: UserRepository

    private var _binding: DialogFragmentDetailExerciseBinding? = null
    private val binding get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arguments?.getParcelable(ExerciseFragment.EXTRA_ID) ?: Exercise()

        Glide.with(this@DetailExerciseBottomSheet)
            .load(data.imgUrl)
            .into(binding?.ivExercise!!)

        binding?.tvExerciseTitle?.text = data.title

        binding?.tvSteps?.text = Html.fromHtml(data.steps, Html.FROM_HTML_MODE_LEGACY)

        binding?.btnDone?.setOnClickListener {
            calculateCaloriesBurned()
        }
    }

    private fun calculateCaloriesBurned() {
        lifecycleScope.launch {
            when(val data = userRepository.getUserInfo().first()) {
                is MResult.Success -> {
                    val exercise = arguments?.getParcelable(ExerciseFragment.EXTRA_ID) ?: Exercise()
                    val user = data.data ?: User()

                    val result = exercise.metScore * user.weight * 0.167 // calories burned

                    val dialog = AlertDialog.Builder(requireContext())
                    dialog
                        .setMessage("Kalori terbakar: $result")
                        .create()
                        .show()
                }
                else -> Unit
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