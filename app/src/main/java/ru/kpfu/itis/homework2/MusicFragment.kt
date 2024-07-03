package ru.kpfu.itis.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import ru.kpfu.itis.homework2.databinding.FragmentMusicBinding


class MusicFragment : Fragment(R.layout.fragment_music) {

    private var binding : FragmentMusicBinding? = null
    private var adapter : MusicAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMusicBinding.bind(view)

        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter(){
        adapter = MusicAdapter(
            list =  MusicRepository.musicAlbums,
            glide = Glide.with(this),
            onClick = {id ->
                val bundle = Bundle()
                bundle.putInt("ID", id)
                findNavController().navigate(
                    resId = R.id.action_musicFragment_to_musicInfoFragment,
                    args = bundle
                )
            }
        )

        binding?.apply {
            rvMusicAlbum.adapter = adapter
            rvMusicAlbum.layoutManager = LinearLayoutManager(requireContext())
        }
    }

}