package com.example.youtubeapi.ui.fragments.playlists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.youtubeapi.data.model.Item
import com.example.youtubeapi.databinding.FragmentPlayListsBinding
import com.example.youtubeapi.ui.adapters.PlaylistsAdapter

class PlayListsFragment : Fragment() {

    private lateinit var binding: FragmentPlayListsBinding
    private val viewModel: PlayListsViewModel by viewModel()
    private var playlists = arrayListOf<Item>()
    private val playlistsAdapter: PlaylistsAdapter by lazy {
        PlaylistsAdapter(
            playlists
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayListsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.getPlayLists().observe(viewLifecycleOwner) {
            binding.pbLoading.isVisible = false
        }
    }

    private fun initialize() {
        binding.rvPlaylists.adapter = playlistsAdapter
    }
}