package ru.kpfu.itis.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isNotEmpty
import ru.kpfu.itis.homework2.databinding.FragmentMainBinding
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar


class MainFragment : Fragment(R.layout.fragment_main) {

    private var viewBinding : FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentMainBinding.bind(view)

        viewBinding?.apply {

            sendBtn.setOnClickListener{
                if(input.editText?.text.toString().isNotEmpty()){
                    val bundle = Bundle()
                    bundle.putString("ARG_TEXT", input.editText?.text.toString())

                    findNavController().navigate(
                        resId = R.id.action_mainFragment_to_resultFragment,
                        args = bundle
                    )
                } else {
                    Snackbar.make(view, "Для отправки текста требуется заполнить поле", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}