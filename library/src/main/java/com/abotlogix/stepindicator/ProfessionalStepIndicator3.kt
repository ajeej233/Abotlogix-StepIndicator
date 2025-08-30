package  com.abotlogix.stepindicator
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abotlogix.stepindicator.model.IndicatorVariant
import com.abotlogix.stepindicator.model.StepIndicatorColors

@Composable
fun ProfessionalStepIndicator(
    number: String,
    title: String,
    isActive: Boolean,
    isCompleted: Boolean,
    variant: IndicatorVariant = IndicatorVariant.VARIANT_3,
    colors: StepIndicatorColors = StepIndicatorColors(),
    modifier: Modifier = Modifier,
    size: Dp = when (variant) {
        IndicatorVariant.VARIANT_2 -> 56.dp
        IndicatorVariant.VARIANT_3 -> 72.dp
        IndicatorVariant.VARIANT_4 -> 70.dp
        IndicatorVariant.VARIANT_5 -> 80.dp
        IndicatorVariant.VARIANT_6 -> 72.dp
        IndicatorVariant.VARIANT_7 -> 80.dp
    },
    innerSize: Dp = when (variant) {
        IndicatorVariant.VARIANT_2 -> 56.dp
        IndicatorVariant.VARIANT_3 -> 56.dp
        else -> size
    }
) {
    when (variant) {
        IndicatorVariant.VARIANT_2 -> ProfessionalStepIndicator2(
            number, title, isActive, isCompleted, colors, modifier, size, innerSize
        )
        IndicatorVariant.VARIANT_3 -> ProfessionalStepIndicator3(
            number, title, isActive, isCompleted, colors, modifier, size, innerSize
        )
        IndicatorVariant.VARIANT_4 -> ProfessionalStepIndicator4(
            number, title, isActive, isCompleted, colors, modifier, size, innerSize
        )
        IndicatorVariant.VARIANT_5 -> ProfessionalStepIndicator5(
            number, title, isActive, isCompleted, colors, modifier, size, innerSize
        )
        IndicatorVariant.VARIANT_6 -> ProfessionalStepIndicator6(
            number, title, isActive, isCompleted, colors, modifier, size, innerSize
        )
        IndicatorVariant.VARIANT_7 -> ProfessionalStepIndicator7(
            number, title, isActive, isCompleted, colors, modifier, size, innerSize
        )
    }
}

@Composable
private fun ProfessionalStepIndicator2(
    number: String,
    title: String,
    isActive: Boolean,
    isCompleted: Boolean,
    colors: StepIndicatorColors,
    modifier: Modifier = Modifier,
    size: Dp = 56.dp,
    innerSize: Dp = 56.dp
) {
    val backgroundColor = when {
        isCompleted -> colors.completedColor
        isActive -> colors.activeColor
        else -> colors.inactiveColor
    }

    val contentColor = when {
        isCompleted -> Color.White
        isActive -> Color.White
        else -> colors.inactiveContentColor
    }

    val borderColor = when {
        isCompleted -> colors.completedColor
        isActive -> colors.activeColor
        else -> colors.inactiveBorderColor
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .width(IntrinsicSize.Max)
            .padding(horizontal = 8.dp)
    ) {
        // Use Surface to take advantage of Material elevation and shape system
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = backgroundColor,
            tonalElevation = if (isActive || isCompleted) 6.dp else 1.dp,
            shadowElevation = if (isActive) 8.dp else 2.dp,
            border = BorderStroke(1.dp, borderColor),
            modifier = Modifier.size(56.dp),
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                if (isCompleted) {
                    Icon(
                        imageVector = Icons.Rounded.Check,
                        contentDescription = "Completed",
                        tint = contentColor,
                        modifier = Modifier.size(24.dp)
                    )
                } else {
                    Text(
                        text = number,
                        color = contentColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }
        }

        // Step title
        Text(
            text = title,
            color = when {
                isCompleted -> MaterialTheme.colorScheme.primary
                isActive -> MaterialTheme.colorScheme.primary
                else -> MaterialTheme.colorScheme.onSurfaceVariant
            },
            fontWeight = if (isCompleted || isActive) FontWeight.SemiBold else FontWeight.Normal,
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.widthIn(max = 80.dp)
        )
    }
}

@Composable
private fun ProfessionalStepIndicator3(
    number: String,
    title: String,
    isActive: Boolean,
    isCompleted: Boolean,
    colors: StepIndicatorColors,
    modifier: Modifier = Modifier,
    size: Dp = 72.dp,
    innerSize: Dp = 56.dp
) {
    val backgroundColor by animateColorAsState(
        targetValue = when {
            isCompleted -> colors.completedColor
            isActive -> colors.activeColor
            else -> colors.inactiveColor
        },
        label = "BackgroundColor"
    )

    val contentColor by animateColorAsState(
        targetValue = when {
            isCompleted || isActive -> Color.White
            else -> colors.inactiveContentColor
        },
        label = "ContentColor"
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .drawBehind {
                    if (isActive) {
                        drawCircle(
                            color = colors.activeColor.copy(alpha = 0.3f),
                            radius = this.size.minDimension / 2
                        )
                    } else if (isCompleted) {
                        drawCircle(
                            color = colors.completedColor.copy(alpha = 0.25f),
                            radius = this.size.minDimension / 2
                        )
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = backgroundColor,
                shadowElevation = if (isActive) 10.dp else 2.dp,
                tonalElevation = if (isCompleted) 4.dp else 0.dp,
                modifier = Modifier.size(innerSize)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    if (isCompleted) {
                        Icon(
                            imageVector = Icons.Rounded.Check,
                            contentDescription = "Completed",
                            tint = contentColor,
                            modifier = Modifier.size(24.dp)
                        )
                    } else {
                        Text(
                            text = number,
                            color = contentColor,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }

        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = if (isActive || isCompleted) FontWeight.SemiBold else FontWeight.Normal,
                color = when {
                    isActive -> colors.activeTextColor
                    isCompleted -> colors.completedTextColor
                    else -> colors.inactiveTextColor
                }
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.widthIn(max = 100.dp)
        )
    }
}

@Composable
private fun ProfessionalStepIndicator4(
    number: String,
    title: String,
    isActive: Boolean,
    isCompleted: Boolean,
    colors: StepIndicatorColors,
    modifier: Modifier = Modifier,
    size: Dp = 70.dp,
    innerSize: Dp = 70.dp
) {
    val backgroundColor by animateColorAsState(
        targetValue = when {
            isCompleted -> colors.completedColor
            isActive -> colors.activeColor
            else -> colors.inactiveColor
        },
        label = "BackgroundColor"
    )

    val contentColor by animateColorAsState(
        targetValue = when {
            isCompleted || isActive -> Color.White
            else -> colors.inactiveContentColor
        },
        label = "ContentColor"
    )

    val borderColor by animateColorAsState(
        targetValue = when {
            isCompleted -> colors.completedColor
            isActive -> colors.activeColor
            else -> colors.inactiveBorderColor
        },
        label = "BorderColor"
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .graphicsLayer {
                    shadowElevation = 12.0f
                    shape = RoundedCornerShape(16.dp)
                    clip = true
                }
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(16.dp)
                )
                .border(
                    width = 2.dp,
                    color = borderColor,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(12.dp)
              ,
            contentAlignment = Alignment.Center
        ) {
            if (isCompleted) {
                Icon(
                    imageVector = Icons.Rounded.Check,
                    contentDescription = "Completed",
                    tint = contentColor,
                    modifier = Modifier.size(24.dp)
                )
            } else {
                Text(
                    text = number,
                    color = contentColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = if (isCompleted || isActive) FontWeight.SemiBold else FontWeight.Normal,
                color = when {
                    isCompleted -> colors.completedTextColor
                    isActive -> colors.activeTextColor
                    else -> colors.inactiveTextColor
                }
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Composable
private fun ProfessionalStepIndicator5(
    number: String,
    title: String,
    isActive: Boolean,
    isCompleted: Boolean,
    colors: StepIndicatorColors,
    modifier: Modifier = Modifier,
    size: Dp = 80.dp,
    innerSize: Dp = 80.dp
) {
    val backgroundColor by animateColorAsState(
        targetValue = when {
            isCompleted -> colors.completedColor
            isActive -> colors.activeColor
            else -> colors.inactiveColor
        },
        label = "BackgroundColor"
    )

    val contentColor by animateColorAsState(
        targetValue = when {
            isCompleted || isActive -> Color.White
            else -> colors.inactiveContentColor
        },
        label = "ContentColor"
    )

    val borderColor by animateColorAsState(
        targetValue = when {
            isCompleted -> colors.completedColor
            isActive -> colors.activeColor
            else -> colors.inactiveBorderColor
        },
        label = "BorderColor"
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .graphicsLayer {
                    shadowElevation = if (isActive || isCompleted) 12.0f else 12.0f
                    shape = CircleShape
                    clip = true
                }
                .background(
                    brush = when {
                        isCompleted -> Brush.linearGradient(
                            colors = listOf(colors.completedColor, colors.completedColor.copy(alpha = 0.8f))
                        )
                        isActive -> Brush.linearGradient(
                            colors = listOf(colors.activeColor, colors.activeColor.copy(alpha = 0.8f))
                        )
                        else -> Brush.linearGradient(
                            colors = listOf(colors.inactiveColor, colors.inactiveColor.copy(alpha = 0.8f))
                        )
                    },
                    shape = CircleShape
                )
                .border(
                    width = 3.dp,
                    color = borderColor,
                    shape = CircleShape
                )
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            if (isCompleted) {
                Icon(
                    imageVector = Icons.Rounded.Check,
                    contentDescription = "Completed",
                    tint = contentColor,
                    modifier = Modifier.size(28.dp)
                )
            } else {
                Text(
                    text = number,
                    color = contentColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = if (isActive || isCompleted) FontWeight.SemiBold else FontWeight.Normal
            ),
            color = when {
                isCompleted -> colors.completedTextColor
                isActive -> colors.activeTextColor
                else -> colors.inactiveTextColor
            },
            textAlign = TextAlign.Center,
            modifier = Modifier.widthIn(max = 90.dp)
        )
    }
}

@Composable
private fun ProfessionalStepIndicator6(
    number: String,
    title: String,
    isActive: Boolean,
    isCompleted: Boolean,
    colors: StepIndicatorColors,
    modifier: Modifier = Modifier,
    size: Dp = 72.dp,
    innerSize: Dp = 72.dp
) {
    val backgroundColor by animateColorAsState(
        targetValue = when {
            isCompleted -> colors.completedColor
            isActive -> colors.activeColor
            else -> colors.inactiveColor
        }
    )

    val contentColor by animateColorAsState(
        targetValue = when {
            isCompleted || isActive -> Color.White
            else -> colors.inactiveContentColor
        }
    )

    val borderColor by animateColorAsState(
        targetValue = when {
            isCompleted -> colors.completedColor
            isActive -> colors.activeColor
            else -> colors.inactiveBorderColor
        }
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Outer container with shadow
        Box(
            modifier = Modifier
                .size(size)
                .graphicsLayer {
                    // Elevation (dynamic based on state)
                    shadowElevation = if (isActive || isCompleted) 12.0f else 4.0f
                    shape = CircleShape
                    clip = true
                },
            contentAlignment = Alignment.Center
        ) {
            // Inner circle with content
            Box(
                modifier = Modifier
                    .size(innerSize)
                    .background(
                        color = backgroundColor,
                        shape = CircleShape
                    )
                    .border(
                        width = 3.dp,
                        color = borderColor,
                        shape = CircleShape
                    )
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                // Check Icon for completed steps
                if (isCompleted) {
                    Icon(
                        imageVector = Icons.Rounded.Check,
                        contentDescription = "Completed",
                        tint = contentColor,
                        modifier = Modifier.size(24.dp)
                    )
                } else {
                    // Number for active/inactive steps
                    Text(
                        text = number,
                        color = contentColor,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // Step Title with Material Typography and Adaptive Color
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = if (isActive || isCompleted) FontWeight.SemiBold else FontWeight.Normal,
                color = when {
                    isCompleted -> colors.completedTextColor
                    isActive -> colors.activeTextColor
                    else -> colors.inactiveTextColor
                }
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.widthIn(max = 100.dp)
        )
        Box(
            modifier = Modifier
                .height(2.dp)
                .width(40.dp)
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFD1D5DB),
                            Color(0xFF6366F1) // Blue line for active progress
                        )
                    )
                )
        )
    }
}
@Composable
private fun ProfessionalStepIndicator7(
    number: String,
    title: String,
    isActive: Boolean,
    isCompleted: Boolean,
    colors: StepIndicatorColors,
    modifier: Modifier = Modifier,
    size: Dp = 80.dp,
    innerSize: Dp = 80.dp
) {
    val backgroundColor by animateColorAsState(
        targetValue = when {
            isCompleted -> colors.completedColor
            isActive -> colors.activeColor
            else -> colors.inactiveColor
        },
        label = "BackgroundColor"
    )

    val contentColor by animateColorAsState(
        targetValue = when {
            isCompleted || isActive -> Color.White
            else -> colors.inactiveContentColor
        },
        label = "ContentColor"
    )

    val borderColor by animateColorAsState(
        targetValue = when {
            isCompleted -> colors.completedColor
            isActive -> colors.activeColor
            else -> colors.inactiveBorderColor
        },
        label = "BorderColor"
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .graphicsLayer {
                    shadowElevation = if (isActive || isCompleted) 12.0f else 6.0f
                    shape = CircleShape
                    clip = true
                }
                .background(
                    brush = when {
                        isCompleted -> Brush.linearGradient(
                            colors = listOf(colors.completedColor, colors.completedColor.copy(alpha = 0.8f))
                        )
                        isActive -> Brush.linearGradient(
                            colors = listOf(colors.activeColor, colors.activeColor.copy(alpha = 0.8f))
                        )
                        else -> Brush.linearGradient(
                            colors = listOf(colors.inactiveColor, colors.inactiveColor.copy(alpha = 0.8f))
                        )
                    },
                    shape = CircleShape
                )
                .border(
                    width = 3.dp,
                    color = borderColor,
                    shape = CircleShape
                )
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            if (isCompleted) {
                Icon(
                    imageVector = Icons.Rounded.Check,
                    contentDescription = "Completed",
                    tint = contentColor,
                    modifier = Modifier.size(24.dp)
                )
            } else {
                Text(
                    text = number,
                    color = contentColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = if (isActive || isCompleted) FontWeight.SemiBold else FontWeight.Normal,
                color = when {
                    isCompleted -> colors.completedTextColor
                    isActive -> colors.activeTextColor
                    else -> colors.inactiveTextColor
                }
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.widthIn(max = 100.dp)
        )
    }
}