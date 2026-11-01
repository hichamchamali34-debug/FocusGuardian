package com.focus.guardian.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * MindfulPauseActivity - Interactive pause screen designed to break subconscious digital distraction.
 */
class MindfulPauseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Simple programmatic UI setup for the focus guardian pause screen
        val layout = android.widget.LinearLayout(this).apply {
            orientation = android.widget.LinearLayout.VERTICAL
            gravity = android.view.Gravity.CENTER
            setPadding(48, 48, 48, 48)
        }

        val titleTextView = TextView(this).apply {
            text = "Take a Deep Breath 🌿"
            textSize = 24f
            gravity = android.view.Gravity.CENTER
        }

        val subtitleTextView = TextView(this).apply {
            text = "FocusGuardian detected a rapid app switching pattern. Are you sure you want to proceed?"
            textSize = 16f
            gravity = android.view.Gravity.CENTER
            setPadding(0, 32, 0, 64)
        }

        val dismissButton = Button(this).apply {
            text = "Return to Focus"
            setOnClickListener {
                finish() // Close the pause screen and return
            }
        }

        layout.addView(titleTextView)
        layout.addView(subtitleTextView)
        layout.addView(dismissButton)

        setContentView(layout)
    }
}
