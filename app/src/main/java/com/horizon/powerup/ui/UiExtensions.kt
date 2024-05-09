package com.horizon.powerup.ui

import android.content.Context
import android.content.res.Configuration
import android.text.Html
import android.text.Html.ImageGetter
import android.text.Html.TagHandler
import android.text.Spanned
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager

fun fromHtml(
    source: String,
    flags: Int = Html.FROM_HTML_MODE_LEGACY,
    imageGetter: ImageGetter? = null,
    tagHandler: TagHandler? = null
): Spanned = Html.fromHtml(source, flags, imageGetter, tagHandler)

fun <T> String?.whenNotNullOrEmpty(block: (String) -> T): T? =
    takeIf { !it.isNullOrEmpty() }?.let(block)

fun View.setShow(show: Boolean) {
    visibility = if (show) VISIBLE else GONE
}

fun View.hideKeyboard() {
    try {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (!imm.isActive) return
        imm.hideSoftInputFromWindow(windowToken, 0)
    } catch (e: Exception) {
    }
}

fun String.isDoubleOrEmpty(): Boolean {
    return isEmpty() || toDoubleOrNull() != null
}

fun Context.isDarkTheme(): Boolean {
    val uiMode = resources.configuration.uiMode
    return (uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
}
