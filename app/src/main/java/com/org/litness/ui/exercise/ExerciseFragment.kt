package com.org.litness.ui.exercise

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.org.litness.R
import com.org.litness.databinding.FragmentExerciseBinding
import com.org.litness.ui.exercise.adapter.ExerciseAdapter
import com.org.litness.ui.exercise.component.DetailExerciseBottomSheet
import com.org.litness.ui.exercise.component.FilterBottomSheet
import com.org.litness.ui.exercise.component.FilterBottomSheet.Companion.FILTER_BOTTOM_SHEET
import com.org.litness.ui.exercise.model.Exercise
import com.org.litness.ui.exercise.viewmodel.ExercisesViewModel
import com.org.litness.util.DrawerMenuToolbarListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ExerciseFragment : Fragment(),
    ExerciseAdapter.OnItemClickListener,
    FilterBottomSheet.OnSelectedChipsListener {

    private var binding: FragmentExerciseBinding? = null

    private val viewModel: ExercisesViewModel by viewModels()

    var drawerMenuToolbarListener: DrawerMenuToolbarListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.toolbar?.setNavigationOnClickListener { drawerMenuToolbarListener?.onDrawerMenuClicked() }
        observer()
        setupActionBar()
    }

    private fun setupAdapter(list: List<Exercise>) {
        val exerciseAdapter = ExerciseAdapter(this@ExerciseFragment)
        binding?.rvExercise?.apply {
            adapter = exerciseAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
        exerciseAdapter.submitList(list)
    }

    private fun setupActionBar() {
        binding?.toolbar?.setOnMenuItemClickListener { menu ->
            when(menu.itemId) {
                R.id.menu_filter ->  {
                    val filter = FilterBottomSheet().apply {
                        onSelectedChipsListener = this@ExerciseFragment
                    }
                    filter.show(childFragmentManager, FILTER_BOTTOM_SHEET)
                }
            }
            true
        }
    }

    private fun observer() {
        viewModel.getExercises(emptyList())

        lifecycleScope.launch {
            viewModel.uiState.collect {
                // filters
                setupAdapter(it.exercises)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentExerciseBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    override fun onItemClicked(exercise: Exercise) {
        // to detail
        val bundle = Bundle()
        bundle.putParcelable(EXTRA_ID, exercise)
        val btmSheet =  DetailExerciseBottomSheet().apply {
            arguments = bundle
        }
        btmSheet.show(childFragmentManager, "Detail Exercise")
    }

    companion object {
        const val EXTRA_ID = "extra-id"
    }

    override fun onSelectedChips(list: List<Long>) {
        // handle filter
        viewModel.getExercises(filters = list)
    }
}