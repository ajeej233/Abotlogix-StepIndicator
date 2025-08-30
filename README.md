
# abotlogix Step Indicator 🚀

A beautiful, customizable step indicator library for Jetpack Compose with multiple different visual variants. Perfect for onboarding flows, multi-step forms, and progress tracking.

## Features

- 📱 **Multiple Styles Available** - Choose from various visual designs
- ➡️ **Horizontal & Vertical Layouts** - Flexible progress displays  
- 🎨 **Fully Customizable** - Colors, sizes, and animations
- ⚡ **Smooth Animations** - Polished transition effects
- 🎯 **Material Design 3** - Modern Android design system
- 🔧 **Easy Integration** - Simple API with sensible defaults

  **🛠️ Additional styles and enhancements will be released in upcoming updates — and that’s just the beginning. Expect more cool stuff soon!**

---
## 📸 Screenshots

![Horizontal Progress](https://github.com/ajeej233/abotlogix-stepindicator/raw/main/screenshots/horizontal.png)
![Vertical Progress](https://github.com/ajeej233/abotlogix-stepindicator/raw/main/screenshots/vertical.png)

## Installation

### Add JitPack Repository

Add this to your **project-level** `build.gradle.kts`:

```kotlin
allprojects {
    repositories {
        // ... other repositories
        maven { url = uri("https://jitpack.io") }
    }
}
```

### Add Dependency

Add this to your **app-level** `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.ajeej233:abotlogix-stepindicator:latest")
}
```

## Quick Start

### 1. Horizontal Progress Bar

```kotlin
HorizontalStepProgress(
    steps = listOf(
        StepData("Details"),
        StepData("Payment"),
        StepData("Confirmation")
    ),
    currentStep = 1, // 0-based index
    variant = IndicatorVariant.VARIANT_3
)
```

### 2. Vertical Progress Bar

```kotlin
VerticalStepProgress(
    steps = listOf(
        StepData("Step 1", "1", isCompleted = true),
        StepData("Step 2", "2", isActive = true),
        StepData("Step 3", "3")
    ),
    currentStep = 1,
    variant = IndicatorVariant.VARIANT_5
)
```

### 3. Single Indicator

```kotlin
ProfessionalStepIndicator(
    number = "1",
    title = "Single Step",
    isActive = true,
    isCompleted = false,
    variant = IndicatorVariant.VARIANT_7
)
```

## Customization Guide

### Custom Colors

```kotlin
val customColors = StepIndicatorColors(
    activeColor = Color(0xFFFF6B35),      // Orange
    completedColor = Color(0xFF4CAF50),   // Green
    inactiveColor = Color(0xFFE0E0E0),    // Light Gray
    activeTextColor = Color(0xFFFF6B35),  // Orange text
    completedTextColor = Color(0xFF4CAF50), // Green text
    inactiveTextColor = Color(0xFF9E9E9E) // Gray text
)

HorizontalStepProgress(
    steps = listOf(StepData("Step 1"), StepData("Step 2")),
    currentStep = 0,
    variant = IndicatorVariant.VARIANT_3,
    colors = customColors
)
```

### Custom Sizes

```kotlin
ProfessionalStepIndicator(
    number = "1",
    title = "Custom Size",
    isActive = true,
    isCompleted = false,
    variant = IndicatorVariant.VARIANT_6,
    size = 80.dp,      // Outer size including shadow
    innerSize = 64.dp  // Inner circle size
)
```

### All Available Variants

```kotlin
enum class IndicatorVariant {
    VARIANT_2, 
    VARIANT_3,
    VARIANT_4, 
    VARIANT_5, 
    VARIANT_6, 
    VARIANT_7 
}
```

### StepData Parameters

```kotlin
data class StepData(
    val title: String,           // Required: Step title
    val number: String? = null,  // Optional: Custom number (defaults to index+1)
    val isActive: Boolean = false, // Optional: Force active state
    val isCompleted: Boolean = false // Optional: Force completed state
)
```

## Complete Example

```kotlin
@Composable
fun CheckoutProgress() {
    val steps = listOf(
        StepData("Cart"),
        StepData("Shipping"),
        StepData("Payment"),
        StepData("Confirmation")
    )
    
    Column {
        // Horizontal progress
        HorizontalStepProgress(
            steps = steps,
            currentStep = 1,
            variant = IndicatorVariant.VARIANT_3,
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Vertical progress
        VerticalStepProgress(
            steps = steps,
            currentStep = 1,
            variant = IndicatorVariant.VARIANT_5,
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

## API Reference

### HorizontalStepProgress
- `steps: List<StepData>` - List of steps to display
- `currentStep: Int` - Current active step (0-based index)
- `variant: IndicatorVariant` - Visual style variant
- `colors: StepIndicatorColors` - Custom color scheme
- `modifier: Modifier` - Layout modifier
- `connectorHeight: Dp` - Height of connecting lines
- `connectorWidth: Dp` - Width of connecting lines

### VerticalStepProgress
- Same parameters as HorizontalStepProgress
- Automatically arranges steps vertically

### ProfessionalStepIndicator (Single)
- `number: String` - Step number or content
- `title: String` - Step title
- `isActive: Boolean` - Active state
- `isCompleted: Boolean` - Completed state
- `variant: IndicatorVariant` - Visual style
- `colors: StepIndicatorColors` - Custom colors
- `size: Dp` - Total indicator size
- `innerSize: Dp` - Inner content size

## Sample App

This repository includes a sample app demonstrating all features. Check the `app/` directory for complete usage examples.


## About

Developed by [Ajeej](https://www.linkedin.com/in/ajeej-s-23b75a231) - creating innovative mobile solutions.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contributing

We welcome contributions! Please feel free to submit issues, feature requests, or pull requests.

## Support

For support and questions:
- Create an issue on GitHub
- Visit: [https://www.abotlogix.com](https://www.abotlogix.com)
- linkedien: [Ajeej S](https://www.linkedin.com/in/ajeej-s-23b75a231)
- linkedien: [Abotlogix](https://www.linkedin.com/company/abotlogix)
- Instagram: [Abotlogix](https://www.instagram.com/abotlogix)




```

