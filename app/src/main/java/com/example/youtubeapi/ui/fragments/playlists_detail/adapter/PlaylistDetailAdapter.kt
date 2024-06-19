package com.example.youtubeapi.ui.fragments.playlists_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtubeapi.data.model.Item
import com.example.youtubeapi.databinding.ItemPlaylistDetailBinding
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class PlaylistDetailAdapter  :
    PagingDataAdapter<Item, PlaylistDetailAdapter.PlaylistDetailViewHolder>(PlaylistItemCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlaylistDetailViewHolder {
        return PlaylistDetailViewHolder(
            ItemPlaylistDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistDetailViewHolder, position: Int) {
        holder.onBind(getItem(position)!!)
    }

    class PlaylistDetailViewHolder(private val binding: ItemPlaylistDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(playlists: Item) {
            with(binding) {
                tvNamePlaylist.text = playlists.snippet.title
                imgPlaylists.load(playlists.snippet.thumbnails.medium.url)
            }
        }
    }
}

class PlaylistItemCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem
}