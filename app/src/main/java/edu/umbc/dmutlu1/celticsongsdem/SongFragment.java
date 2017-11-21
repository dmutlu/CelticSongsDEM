package edu.umbc.dmutlu1.celticsongsdem;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;


public class SongFragment extends Fragment implements View.OnClickListener
{
    private ImageButton mediaBtn;
    private MediaPlayer mediaPlayer;
    private OnFragmentInteractionListener mCallback;

    public SongFragment()
    {
        // Required empty public constructor
    }

    public static SongFragment newInstance(int audio, int image)
    {
        SongFragment fragment = new SongFragment();
        Bundle bundle = new Bundle(2);
        bundle.putInt("imageID", image);
        bundle.putInt("audioID", audio);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_song1, container, false);
        ImageView image = view.findViewById(R.id.imageDance);

        image.setImageResource(getArguments().getInt("imageID"));

        mediaPlayer = MediaPlayer.create(getActivity(), getArguments().getInt("audioID"));
        mediaPlayer.setLooping(true);
        mediaBtn = view.findViewById(R.id.mediaCtrl);
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
            pause();
        }
        else {
            mCallback.onFragmentInteraction(this);

            mediaPlayer.start();
            mediaBtn.setImageResource(android.R.drawable.ic_media_pause);
        }
    }

    public void pause()
    {
        mediaPlayer.pause();
        mediaBtn.setImageResource(android.R.drawable.ic_media_play);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnFragmentInteractionListener
    {
        void onFragmentInteraction(SongFragment fragment);
    }
}