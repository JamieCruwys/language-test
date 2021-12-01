package uk.co.jamiecruwys.languagetest.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uk.co.jamiecruwys.languagetest.LanguageContextWrapper
import uk.co.jamiecruwys.languagetest.LanguageFlags
import uk.co.jamiecruwys.languagetest.databinding.FragmentThirdBinding

class ThirdFragment: Fragment() {
    private lateinit var binding: FragmentThirdBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentThirdBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun getContext(): Context? {
        return super.getContext()?.let { context ->
            val chosenLanguage = LanguageFlags.get(context)
            chosenLanguage?.let {
                LanguageContextWrapper.wrap(context, it)
            } ?: context
        }
    }
}
