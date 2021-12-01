package uk.co.jamiecruwys.languagetest.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uk.co.jamiecruwys.languagetest.LanguageContextWrapper
import uk.co.jamiecruwys.languagetest.LanguageFlags
import uk.co.jamiecruwys.languagetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun attachBaseContext(newBase: Context?) {
        val baseContext = newBase?.let {
            val chosenLanguage = LanguageFlags.get(newBase)
            chosenLanguage?.let {
                LanguageContextWrapper.wrap(newBase, chosenLanguage)
            } ?: newBase
        }
        super.attachBaseContext(baseContext)
    }
}
