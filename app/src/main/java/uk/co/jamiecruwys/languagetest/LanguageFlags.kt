package uk.co.jamiecruwys.languagetest

import android.content.Context

object LanguageFlags {

    fun get(context: Context?): String? = context?.let {
        sharedPreferences(context).getString(LANGUAGE_KEY, null)
    }

    fun set(context: Context, language: String?) {
        sharedPreferences(context).edit().putString(LANGUAGE_KEY, language).apply()
    }

    private fun sharedPreferences(context: Context) =
        context.getSharedPreferences(LANGUAGE_SHARED_PREFS, Context.MODE_PRIVATE)

    private const val LANGUAGE_SHARED_PREFS = "in-app-languages"
    private const val LANGUAGE_KEY = "language"
}
