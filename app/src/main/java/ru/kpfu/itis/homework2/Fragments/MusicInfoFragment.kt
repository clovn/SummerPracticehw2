package ru.kpfu.itis.homework2.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.kpfu.itis.homework2.MusicRepository
import ru.kpfu.itis.homework2.R
import ru.kpfu.itis.homework2.databinding.FragmentMusicInfoBinding


class MusicInfoFragment : Fragment(R.layout.fragment_music_info) {

    private var binding : FragmentMusicInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMusicInfoBinding.bind(view)

        val musicAlbum = MusicRepository.musicAlbums.find { musicAlbum ->
            musicAlbum.id == arguments?.getInt("ID")
        }

        binding?.apply {
            musicAlbum?.apply {
                nameTv.text = name
                authorTv.text = author
                descriptionTv.text = description

                Glide.with(view.context)
                    .load(musicAlbum.imageUrl)
                    .into(image)

                backIv.setOnClickListener{
                    findNavController().navigateUp()
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}