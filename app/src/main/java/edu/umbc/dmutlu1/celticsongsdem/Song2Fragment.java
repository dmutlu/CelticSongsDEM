package edu.umbc.dmutlu1.celticsongsdem;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class Song2Fragment extends Fragment implements View.OnClickListener
{
    private ImageButton mediaBtn;
    private static MediaPlayer mediaPlayer;

    public Song2Fragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_song2, container, false);

        mediaBtn = view.findViewById(R.id.mediaCtrl2);
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.bagpipes);
        mediaPlayer.setLooping(true);
        mediaBtn.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    public void onClick(View v)
    {
        if (mediaPlayer.isPlaying())
        {
            mediaPlayer.pause();
            mediaBtn.setImageResource(android.R.drawable.ic_media_play);
        }
        else {
            mediaPlayer.start();
            mediaBtn.setImageResource(android.R.drawable.ic_media_pause);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}