package com.abotlogix.stepindicator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.abotlogix.stepindicator.model.IndicatorVariant
import com.abotlogix.stepindicator.model.StepData
import com.abotlogix.stepindicator.model.StepIndicatorColors

@Composable
fun VerticalStepProgress(
    steps: List<StepData>,
    currentStep: Int,
    variant: IndicatorVariant = IndicatorVariant.VARIANT_3,
    colors: StepIndicatorColors = StepIndicatorColors(),
    modifier: Modifier = Modifier,
    connectorHeight: Dp = 40.dp,
    connectorWidth: Dp = 2.dp
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        steps.forEachIndexed { index, step ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                ProfessionalStepIndicator(
                    number = step.number ?: (index + 1).toString(),
                    title = step.title,
                    isActive = index == currentStep,
                    isCompleted = index < currentStep,
                    variant = variant,
                    colors = colors
                )
            }

            // Add connector between steps (except after the last step)
            if (index < steps.size - 1) {
                Spacer(modifier = Modifier.height(8.dp))
                VerticalConnector(
                    isCompleted = index < currentStep,
                    isNextActive = index + 1 == currentStep,
                    colors = colors,
                    height = connectorHeight,
                    width = connectorWidth
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
private fun VerticalConnector(
    isCompleted: Boolean,
    isNextActive: Boolean,
    colors: StepIndicatorColors,
    height: Dp = 40.dp,
    width: Dp = 2.dp
) {
    Box(
        modifier = Modifier
            .width(width)
            .height(height)
            .clip(androidx.compose.foundation.shape.RoundedCornerShape(50))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        if (isCompleted) colors.completedColor else colors.inactiveColor,
                        if (isNextActive) colors.activeColor else colors.inactiveColor
                    )
                )
            )
    )
}