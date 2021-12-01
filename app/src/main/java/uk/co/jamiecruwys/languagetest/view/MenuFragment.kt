package uk.co.jamiecruwys.languagetest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uk.co.jamiecruwys.languagetest.LanguageFlags
import uk.co.jamiecruwys.languagetest.R
import uk.co.jamiecruwys.languagetest.databinding.FragmentMainBinding

class MenuFragment: Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.reset.setOnClickListener { onResetClicked() }
        binding.spanish.setOnClickListener { onSpanishClicked() }
        binding.german.setOnClickListener { onGermanClicked() }
        binding.welsh.setOnClickListener { onWelshClicked() }
        binding.next.setOnClickListener { onNextClicked() }
    }

    private fun onResetClicked() {
        setLanguage(null)
    }

    private fun onSpanishClicked() {
        setLanguage("es")
    }

    private fun onGermanClicked() {
        setLanguage("de")
    }

    private fun onWelshClicked() {
        setLanguage("cy")
    }

    private fun onNextClicked() {
        // Pick whether you want to test with an activity or fragment:

        // Activity
        findNavController().navigate(R.id.action_menuFragment_to_secondActivity)

        // Fragment
        // findNavController().navigate(R.id.action_menuFragment_to_thirdFragment)
    }

    private fun setLanguage(language: String?) {
        LanguageFlags.set(requireContext(), language)
    }
}