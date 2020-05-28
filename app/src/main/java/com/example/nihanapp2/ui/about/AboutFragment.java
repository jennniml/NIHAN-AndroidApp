package com.example.nihanapp2.ui.about;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.InputFilter;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.nihanapp2.R;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.util.Util;

public class AboutFragment extends Fragment {

    private AboutViewModel aboutViewModel;
    private PlayerView playerView;
    private Uri uri;

    private DataSource.Factory dataSourceFactory;
    private SimpleExoPlayer player;
    private MediaSource mediaSource;
    private DefaultTrackSelector trackSelector;
    private DefaultTrackSelector.Parameters trackSelectorParameters;

    private boolean playWhenReady = true;
    private int currentWindow = 0;
    private long playbackPosition = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutViewModel =
                ViewModelProviders.of(this).get(AboutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_about, container, false);
        /*final TextView textView = root.findViewById(R.id.text_share);
        aboutViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/


        // Play video in Video view
        /*String videoPath = "android.resource://" + getContext().getPackageName() + "/" + R.raw.rush4ms;
        uri = Uri.parse(videoPath);
        VideoView videoView = (VideoView) root.findViewById(R.id.video_view_4ms);
        videoView.setVideoURI(uri);
        videoView.setMediaController(new MediaController(getContext()));
        videoView.start();*/


        // Play video using Exoplayer
        playerView = root.findViewById(R.id.player_view);   // creating player view


        // Display icon attributions list
        TextView attributeTextView = root.findViewById(R.id.about_attributions);
        String[] iconArray = getResources().getStringArray(R.array.nav_icons);
        String attributeString = "";
        for (int i = 0; i<iconArray.length; i++) {
            attributeString = attributeString + Html.fromHtml("<li>" + iconArray[i] + "</li>");
        }
        attributeTextView.setText(attributeString);
        Linkify.addLinks(attributeTextView, Linkify.ALL);


        return root;
    }

    // initialize exoplayer player
    @Override
    public void onStart() {
        super.onStart();

        if (Util.SDK_INT >= 24) {
            initializePlayer();
        }
    }

    private void initializePlayer() {
        player = ExoPlayerFactory.newSimpleInstance(getContext(), new DefaultTrackSelector());
        playerView.setPlayer(player);

        String vidPath = RawResourceDataSource.buildRawResourceUri(R.raw.rush4ms).toString();
        Uri viduri = RawResourceDataSource.buildRawResourceUri(R.raw.rush4ms);

        mediaSource = buildMediaSource(viduri);

        player.setPlayWhenReady(playWhenReady);
        player.seekTo(currentWindow, playbackPosition);
        player.prepare(mediaSource, false, false);
    }

    private MediaSource buildMediaSource(Uri uri) {
        dataSourceFactory = new DefaultDataSourceFactory(getContext(),
                Util.getUserAgent(getContext(), "NIHANapp2"));

        return new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
    }

    @Override
    public void onResume() {
        super.onResume();

        //hideSystemUi();
        if ((Util.SDK_INT < 24 || player == null)) {
            initializePlayer();
        }
    }

    @SuppressLint("InlinedApi")
    private void hideSystemUi() {
        playerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
        | View.SYSTEM_UI_FLAG_FULLSCREEN
        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }


    @Override
    public void onPause() {
        super.onPause();

        if (Util.SDK_INT < 24) {
            releasePlayer();
        }
    }

    // clear player reference in player view
    @Override
    public void onStop() {
        super.onStop();

        if (Util.SDK_INT >= 24) {
            releasePlayer();
        }
    }

    private void releasePlayer() {
        if (player != null) {
            playWhenReady = player.getPlayWhenReady();
            playbackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            player.release();
            player = null;
        }
    }
}