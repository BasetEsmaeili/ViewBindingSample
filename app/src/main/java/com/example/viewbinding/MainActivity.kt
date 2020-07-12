package com.example.viewbinding

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.*
import com.example.viewbinding.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(getRootView())
        setupProfileAnimation()
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnAccept.setOnClickListener {
            Snackbar.make(getRootView(),resources.getString(R.string.message_accept),Snackbar.LENGTH_LONG).show()
        }
        binding.btnDecline.setOnClickListener {
            Snackbar.make(
                getRootView(),
                resources.getString(R.string.message_decline),
                Snackbar.LENGTH_LONG
            ).setAction(
                resources.getString(R.string.label_confirm)
            ) { finish() }.show()
        }
    }

    private fun setupProfileAnimation() {
        val scaleAnimation = ScaleAnimation(
            1.1f,
            1.3f,
            1.1f,
            1.3.toFloat(),
            ScaleAnimation.RELATIVE_TO_SELF,
            0.5f,
            ScaleAnimation.RELATIVE_TO_SELF,
            0.5f
        ).apply {
            duration = 600
            repeatCount = ScaleAnimation.INFINITE
            repeatMode = ScaleAnimation.REVERSE
            interpolator = AccelerateInterpolator()
        }
        val scaleBorderAnimation = ScaleAnimation(
            1f,
            1.1f,
            1f,
            1.1.toFloat(),
            ScaleAnimation.RELATIVE_TO_SELF,
            0.5f,
            ScaleAnimation.RELATIVE_TO_SELF,
            0.5f
        ).apply {
            duration = 600
            repeatCount = ScaleAnimation.INFINITE
            repeatMode = ScaleAnimation.REVERSE
            interpolator = AccelerateInterpolator()
        }
        binding.frameProfileBackground.startAnimation(scaleAnimation)
        binding.frameProfileBorder.startAnimation(scaleBorderAnimation)
    }

    private fun getRootView(): View = binding.root
}