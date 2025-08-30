package com.abotlogix.indicatorsample// In your MainActivity.kt or any Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abotlogix.stepindicator.HorizontalStepProgress
import com.abotlogix.stepindicator.VerticalStepProgress
import com.abotlogix.stepindicator.model.StepData
import com.abotlogix.stepindicator.model.IndicatorVariant
import com.abotlogix.stepindicator.model.StepIndicatorColors

@Preview(showBackground = true, name = "Horizontal Progress - Variant 3")
@Composable
fun SampleS() {
    val scrollState = rememberScrollState()
    Column(   modifier = Modifier
        .verticalScroll(scrollState)
        .padding(16.dp)) {
        HorizontalAllVariantsPreview()
        Text("Vertical Progress Bar",modifier = Modifier.padding(top = 10.dp))
        VerticalStepProgressPreview()
        }
}

@Composable
fun HorizontalAllVariantsPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            // Variant 2
            Text("Variant 2", style = MaterialTheme.typography.titleMedium)
            HorizontalStepProgress(
                steps = listOf(
                    StepData("Details"),
                    StepData("Payment"),
                    StepData("Confirmation")
                ),
                currentStep = 0,
                variant = IndicatorVariant.VARIANT_2,
                colors = StepIndicatorColors(
                    activeColor = Color(0xFFFF6B35),
                    completedColor = Color(0xFF4CAF50),
                    inactiveColor = Color(0xFFE0E0E0),
                    inactiveContentColor = Color(0xFF757575),
                    inactiveBorderColor = Color(0xFF520B0B),
                    activeTextColor = Color(0xFFFF6B35),
                    completedTextColor = Color(0xFF4CAF50),
                    inactiveTextColor = Color(0xFF9E9E9E)
                )
            )

            // Variant 3
            Text("Variant 3", style = MaterialTheme.typography.titleMedium)
            HorizontalStepProgress(
                steps = listOf(
                    StepData("Details"),
                    StepData("Payment"),
                    StepData("Confirmation")
                ),
                currentStep = 1,
                variant = IndicatorVariant.VARIANT_3
            )

            // Variant 4
            Text("Variant 4", style = MaterialTheme.typography.titleMedium)
            HorizontalStepProgress(
                steps = listOf(
                    StepData("Details"),
                    StepData("Payment"),
                    StepData("Confirmation")
                ),
                currentStep = 1,
                variant = IndicatorVariant.VARIANT_4
            )

            // Variant 5
            Text("Variant 5", style = MaterialTheme.typography.titleMedium)
            HorizontalStepProgress(
                steps = listOf(
                    StepData("Details"),
                    StepData("Payment"),
                    StepData("Confirmation")
                ),
                currentStep = 1,
                variant = IndicatorVariant.VARIANT_5
            )

            // Variant 6
            Text("Variant 6", style = MaterialTheme.typography.titleMedium)
            HorizontalStepProgress(
                steps = listOf(
                    StepData("Details"),
                    StepData("Payment"),
                    StepData("Confirmation")
                ),
                currentStep = 1,
                variant = IndicatorVariant.VARIANT_6
            )

            // Variant 7

        }
    }
}


@Composable
fun VerticalStepProgressPreview() {
    MaterialTheme {
        VerticalStepProgress(
            steps = listOf(
                StepData("Step 1", "1", isCompleted = true),
                StepData("Step 2", "2", isActive = true),
                StepData("Step 3", "3")
            ),
            currentStep = 1,
            variant = IndicatorVariant.VARIANT_3,
            colors = StepIndicatorColors(
                activeColor = Color(0xFFFF6B35),
                completedColor = Color(0xFF4CAF50),
                inactiveColor = Color(0xFFE0E0E0),
                inactiveContentColor = Color(0xFF757575),
                inactiveBorderColor = Color(0xFFBDBDBD),
                activeTextColor = Color(0xFFFF6B35),
                completedTextColor = Color(0xFF4CAF50),
                inactiveTextColor = Color(0xFF9E9E9E)
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}


