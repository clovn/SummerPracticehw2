package ru.kpfu.itis.homework2

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import ru.kpfu.itis.homework2.databinding.ItemMusicAlbumBinding

class MusicHolder(
    private val binding: ItemMusicAlbumBinding,
    private val glide : RequestManager,
    private val onClick : (Int) -> Unit
) : ViewHolder(binding.root) {

    fun onBind(musicAlbum : MusicAlbum){
        binding.apply {
            nameTv.text = musicAlbum.name
            authorTv.text = musicAlbum.author

            glide
                .load(musicAlbum.imageUrl)
                .into(image)

            root.setOnClickListener{
                onClick(musicAlbum.id)
            }
        }
    }
}