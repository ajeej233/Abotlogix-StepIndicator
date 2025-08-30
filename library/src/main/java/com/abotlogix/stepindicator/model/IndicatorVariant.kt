package com.abotlogix.stepindicator.model

import androidx.compose.ui.graphics.Color

enum class IndicatorVariant {
    VARIANT_2, VARIANT_3, VARIANT_4, VARIANT_5, VARIANT_6, VARIANT_7
}

data class StepData(
    val title: String,
    val number: String? = null,
    val isActive: Boolean = false,
    val isCompleted: Boolean = false
)

data class StepIndicatorColors(
    val activeColor: Color = Color(0xFF6366F1),
    val completedColor: Color = Color(0xFF10B981),
    val inactiveColor: Color = Color(0xFFE0E0E0),
    val inactiveContentColor: Color = Color(0xFF6B7280),
    val inactiveBorderColor: Color = Color(0xFFD1D5DB),
    val activeTextColor: Color = Color(0xFF6366F1),
    val completedTextColor: Color = Color(0xFF10B981),
    val inactiveTextColor: Color = Color(0xFF9CA3AF)
)