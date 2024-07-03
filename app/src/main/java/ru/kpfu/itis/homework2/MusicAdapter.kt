package ru.kpfu.itis.homework2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.RequestManager
import ru.kpfu.itis.homework2.databinding.ItemMusicAlbumBinding

class MusicAdapter(
    private val list : List<MusicAlbum>,
    private val glide : RequestManager,
    private val onClick : (Int) -> Unit
) : Adapter<MusicHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicHolder {
        return MusicHolder(
            ItemMusicAlbumBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide,
            onClick
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MusicHolder, position: Int) {
        holder.onBind(list[position])
    }

}