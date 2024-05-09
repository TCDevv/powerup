package com.horizon.powerup.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Domain Colors
val Transparent25Color = Color(0x3F000000)
val Transparent50Color = Color(0x7F000000)
val Transparent75Color = Color(0xBD000000)

val ErrorColor = Color(0xFFCD5C5C)
val SuccessColor = Color(0xFF018786)

val LongColor = Color(0xFF018786)
val ShortColor = Color(0xFFCD5C5C)

val OpenColor = Color(0xFF018786)
val CloseColor = Color(0xFFCD5C5C)

val ProfitColor = Color(0xFF018786)
val LossColor = Color(0xFFCD5C5C)

val UpColor = Color(0xFF018786)
val DownColor = Color(0xFFCD5C5C)

val OnlineColor = Color(0xFF018786)
val OfflineColor = Color(0xFFCD5C5C)

val DimColor = Color(0xff636e72)

//Dark Theme Color Set
private val AppDarkPalette = darkColors(
    primary = Color(0xFF9DA3FA),
    primaryVariant = Color(0xFF4860F7),
    onPrimary = Color.Black,
    secondary = Color(0xff38ada9),
    secondaryVariant = Color(0xff079992),
    onSecondary = Color.Black,
    onSurface = Color.White,
    onBackground = Color.White,
    error = Color(0xFFEA6D7E),
    onError = Color.Black
)

//Light Theme Color Set
private val AppLightPalette = lightColors(
    primary = Color(0xff60a3bc),
    primaryVariant = Color(0xff3c6382),
    onPrimary = Color.White,
    secondary = Color(0xff38ada9),
    secondaryVariant = Color(0xff079992),
    onSecondary = Color.Black,
    onSurface = Color.Black,
    onBackground = Color.Black,
    error = Color(0xFFD00036),
    onError = Color.White
)

//App Shapes
val AppShapes = Shapes(
    small = RoundedCornerShape(50),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(0.dp)
)

//App Typography
val AppTypography = Typography(
    defaultFontFamily = FontFamily.SansSerif,
    h1 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 96.sp,
        letterSpacing = (-1.5).sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 60.sp,
        letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp,
        letterSpacing = 0.sp
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 30.sp,
        letterSpacing = 0.sp
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        letterSpacing = 0.sp
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        letterSpacing = 0.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        letterSpacing = 0.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.sp,
        lineHeight = 24.sp
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 1.25.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        letterSpacing = 0.15.sp
    ),
    overline = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        letterSpacing = 1.sp
    )
)

@Composable
fun MainTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val myColors = if (isDarkTheme) AppDarkPalette else AppLightPalette

    MaterialTheme(
        colors = myColors,
        content = content,
        typography = AppTypography,
        shapes = AppShapes
    )
}