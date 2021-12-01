package uk.co.jamiecruwys.languagetest

import android.os.Build

import android.annotation.TargetApi
import android.content.Context

import android.content.ContextWrapper
import android.content.res.Configuration
import java.util.Locale

class LanguageContextWrapper(base: Context?) : ContextWrapper(base) {
    companion object {
        fun wrap(context: Context, language: String): ContextWrapper {
            val config: Configuration = context.resources.configuration

            val systemLocale: Locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                getSystemLocale(config)
            } else {
                getSystemLocaleLegacy(config)
            }

            if (language.isNotEmpty() && !systemLocale.language.equals(language)) {
                val locale = Locale(language)
                Locale.setDefault(locale)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    setSystemLocale(config, locale)
                } else {
                    setSystemLocaleLegacy(config, locale)
                }
                context.resources.updateConfiguration(config, context.resources.displayMetrics)
            }
            return LanguageContextWrapper(context)
        }

        private fun getSystemLocaleLegacy(config: Configuration): Locale = config.locale

        @TargetApi(Build.VERSION_CODES.N)
        private fun getSystemLocale(config: Configuration): Locale = config.locales.get(0)

        private fun setSystemLocaleLegacy(config: Configuration, locale: Locale) {
            config.locale = locale
        }

        @TargetApi(Build.VERSION_CODES.N)
        private fun setSystemLocale(config: Configuration, locale: Locale?) {
            config.setLocale(locale)
        }
    }
}
