package com.captainhampton.android.lightsout.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;
import com.captainhampton.android.lightsout.LOUtils;
import com.captainhampton.android.lightsout.R;

public class FragmentMenu extends Fragment implements OnClickListener {


    public static final String TAG = "FragmentMenu";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button btnPlay, btnTodo, btnHowToPlay, btnAbout;
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    public FragmentMenu() {
        // Required empty public constructor
    }

    public static FragmentMenu newInstance(String param1, String param2) {
        FragmentMenu fragment = new FragmentMenu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);
        setupVariables(rootView);
        return rootView;
    }

    private void setupVariables(View rootView) {

        btnPlay = (Button) rootView.findViewById(R.id.button_play);
        btnPlay.setOnClickListener(this);

        btnTodo = (Button) rootView.findViewById(R.id.button_todo);
        btnTodo.setOnClickListener(this);

        btnHowToPlay = (Button) rootView.findViewById(R.id.button_howtoplay);
        btnHowToPlay.setOnClickListener(this);

        btnAbout = (Button) rootView.findViewById(R.id.button_about);
        btnAbout.setOnClickListener(this);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LOUtils.applyFont(getActivity(), R.id.menu_screen_title, LOUtils.FONT_GEAR);

    }

    public void onButtonPressed(int i) {
        if (mListener != null) {
            mListener.onFragmentInteraction(i);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener interface");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

        if (btnPlay.isPressed()) {

            // use the activity callback interface to switch fragments
            if (mListener != null) {
                mListener.onStartButtonPressed();
            }
//
        } else if (btnAbout.isPressed()) {
            
            new MaterialDialog.Builder(getContext())
                    .title(R.string.about_title)
                    .content(R.string.about_content)
                    .show();
        } else if (btnHowToPlay.isPressed()) {
            new MaterialDialog.Builder(getContext())
                    .title(R.string.howToPlay_title)
                    .content(R.string.howToPlay_content)
                    .show();
        }


    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(int i);

        void onStartButtonPressed();
    }
}
