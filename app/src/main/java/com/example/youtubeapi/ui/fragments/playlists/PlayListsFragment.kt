package com.example.youtubeapi.ui.fragments.playlists

import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.youtubeapi.databinding.FragmentPlayListsBinding
import com.example.youtubeapi.ui.adapters.PlaylistsAdapter
import com.example.youtubeapi.ui.base.BaseFragment
import com.example.youtubeapi.utils.Resource

class PlayListsFragment :
    BaseFragment<FragmentPlayListsBinding>(FragmentPlayListsBinding::inflate) {

    private val viewModel: PlayListsViewModel by viewModel()
    private val playlistsAdapter: PlaylistsAdapter by lazy { PlaylistsAdapter() }


    override fun setupViews() {
        super.setupViews()
        setupRecycler()
    }

    override fun setupObservers() {
        viewModel.getPlayLists().stateHandler(
            success = { data ->
                playlistsAdapter.submitList(data)
            },
            state = { state ->
                binding.pbLoading.isVisible = state is Resource.Loading
            }
        )
    }

    private fun setupRecycler() = with(binding.rvPlaylists) {
        adapter = playlistsAdapter
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
}