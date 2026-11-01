package com.focus.guardian.engine

import android.content.Context
import android.os.SystemClock

/**
 * BehaviorAnalyzer - Engine for analyzing behavioral patterns to detect digital distraction.
 */
object BehaviorAnalyzer {

    // Map to store the last access time of each app to detect "Micro-Addiction" (rapid repeated opening)
    private val lastAccessMap = mutableMapOf<String, Long>()
    
    // Minimum threshold in milliseconds between app launches to consider it a distraction pattern (e.g., less than 2 minutes)
    private const val DISTRACTION_THRESHOLD_MS = 2 * 60 * 1000L

    /**
     * Check if opening the current app indicates a behavioral distraction pattern.
     */
    fun isDistractionPatternDetected(packageName: String): Boolean {
        val currentTime = SystemClock.elapsedRealtime()
        val lastAccessTime = lastAccessMap[packageName]

        if (lastAccessTime != null) {
            val timeDifference = currentTime - lastAccessTime
            // If the user opens the app again repeatedly in a short duration below the threshold
            if (timeDifference < DISTRACTION_THRESHOLD_MS) {
                lastAccessMap[packageName] = currentTime
                return true // Distraction pattern detected!
            }
        }
        
        // Update the last usage time
        lastAccessMap[packageName] = currentTime
        return false
    }
}
