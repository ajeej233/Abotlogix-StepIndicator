package com.abotlogix.stepindicator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.abotlogix.stepindicator.model.IndicatorVariant
import com.abotlogix.stepindicator.model.StepData
import com.abotlogix.stepindicator.model.StepIndicatorColors

@Composable
fun HorizontalStepProgress(
    steps: List<StepData>,
    currentStep: Int,
    variant: IndicatorVariant = IndicatorVariant.VARIANT_3,
    colors: StepIndicatorColors = StepIndicatorColors(),
    modifier: Modifier = Modifier,
    connectorHeight: Dp = 2.dp,
    connectorWidth: Dp = 40.dp
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        steps.forEachIndexed { index, step ->
            ProfessionalStepIndicator(
                number = step.number ?: (index + 1).toString(),
                title = step.title,
                isActive = index == currentStep,
                isCompleted = index < currentStep,
                variant = variant,
                colors = colors
            )

            // Add connector between steps (except after the last step)
            if (index < steps.size - 1) {
                Spacer(modifier = Modifier.width(8.dp))
                if (IndicatorVariant.VARIANT_6!=variant) {

                    Connector(
                        isCompleted = index < currentStep,
                        isNextActive = index + 1 == currentStep,
                        colors = colors,
                        height = connectorHeight,
                        width = connectorWidth
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Composable
private fun Connector(
    isCompleted: Boolean,
    isNextActive: Boolean,
    colors: StepIndicatorColors,
    height: Dp = 2.dp,
    width: Dp = 40.dp
) {
    Box(
        modifier = Modifier
            .width(width)
            .height(height)
            .clip(androidx.compose.foundation.shape.RoundedCornerShape(50))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        if (isCompleted) colors.completedColor else colors.inactiveColor,
                        if (isNextActive) colors.activeColor else colors.inactiveColor
                    )
                )
            )
    )
}
