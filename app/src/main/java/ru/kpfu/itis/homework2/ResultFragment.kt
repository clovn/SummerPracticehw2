package ru.kpfu.itis.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.kpfu.itis.homework2.databinding.FragmentMainBinding
import ru.kpfu.itis.homework2.databinding.FragmentResultBinding

class ResultFragment : Fragment(R.layout.fragment_result) {
    private var binding : FragmentResultBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultBinding.bind(view)

        var text = arguments?.getString("ARG_TEXT") ?: "ERROR"

        binding?.apply {
            tvTitle.text = text
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}