package edu.umbc.dmutlu1.celticsongsdem;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Song1Fragment extends Fragment implements View.OnClickListener
{
    private ImageButton mediaBtn;
    private static MediaPlayer mediaPlayer;
    private OnFragmentInteractionListener mCallback;

    public Song1Fragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_song1, container, false);

        mediaBtn = view.findViewById(R.id.mediaCtrl1);
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.jig);
        mediaPlayer.setLooping(true);
        mediaBtn.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public void onClick(View v)
    {
        if (mediaPlayer.isPlaying())
        {
            mediaPlayer.pause();
            mediaBtn.setImageResource(android.R.drawable.ic_media_play);
            mCallback.onFragmentInteraction(true);
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
        void onFragmentInteraction(Boolean mediaPlaying);
    }
}