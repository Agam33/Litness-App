package com.org.litness.ui.main

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.org.litness.R
import com.org.litness.databinding.ActivityMainNavigationBinding
import com.org.litness.ui.exercise.ExerciseFragment
import com.org.litness.ui.profile.ProfileFragment
import com.org.litness.util.DrawerMenuToolbarListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainNavigationActivity : AppCompatActivity(), DrawerMenuToolbarListener {

    private val binding: ActivityMainNavigationBinding by lazy { ActivityMainNavigationBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupSystemBar()
        setupNavigation()
    }

    private fun setupNavigation() {
        binding.navigationDrawerView.setCheckedItem(R.id.menu_exercise)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ExerciseFragment().apply { drawerMenuToolbarListener = this@MainNavigationActivity })
            .commit()

        binding.navigationDrawerView.setNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.menu_exercise -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ExerciseFragment().apply { drawerMenuToolbarListener = this@MainNavigationActivity }, "Menu Exercise")
                        .commit()
                }

                R.id.menu_profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ProfileFragment().apply { drawerMenuToolbarListener = this@MainNavigationActivity }, "Menu Profile")
                        .commit()
                }
            }

            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun setupSystemBar() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        window.statusBarColor = Color.WHITE
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true
    }

    override fun onDrawerMenuClicked() {
        binding.drawerLayout.open()
    }
}