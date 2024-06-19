package com.example.youtubeapi.ui.fragments.playlists_detail

import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapi.databinding.FragmentPlaylistDetailBinding
import com.example.youtubeapi.ui.base.BaseFragment
import com.example.youtubeapi.ui.fragments.playlists_detail.adapter.PlaylistDetailAdapter
import com.example.youtubeapi.utils.Resource
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

typealias FPDB = FragmentPlaylistDetailBinding

class PlaylistDetailFragment : BaseFragment<FPDB>(FPDB::inflate) {

    private val viewModel: PlaylistDetailViewModel by viewModel()
    private val playlistsDetailAdapter: PlaylistDetailAdapter by lazy { PlaylistDetailAdapter() }

    override fun setupViews() {
        super.setupViews()
        setupRecycler()
    }


    private fun setupRecycler() = with(binding.rvVideo) {
        adapter = playlistsDetailAdapter
        layoutManager = LinearLayoutManager(
            requireContext(),
            androidx.recyclerview.widget.LinearLayoutManager.VERTICAL,
            false
        )
    }

    override fun setupObservers() {
        super.setupObservers()
//        viewModel.getVideo().observe(viewLifecycleOwner) { pagingData ->
//            lifecycleScope.launch {
//                playlistsDetailAdapter.submitData(pagingData)
//            }
//        }
    }
}