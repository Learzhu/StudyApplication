package com.learzhu.study.studyapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.learzhu.study.studyapplication.R;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListTitleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListTitleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListTitleFragment extends ListFragment {
    public static final int REQUEST_DETAIL = 0x110;
    private List<String> mTitles = Arrays.asList("Hello", "World", "Android");
    private int mCurrentPos;
    private ArrayAdapter<String> mAdapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private OnFragmentInteractionListener mListener;

    public ListTitleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mTitles));
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListTitleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListTitleFragment newInstance(String param1, String param2) {
        ListTitleFragment fragment = new ListTitleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_title, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    /**
     * 点击每一行
     *
     * @param l
     * @param v
     * @param position
     * @param id       在ListTitleFragment.onListItemClick，使用startActivityForResult（）跳转到目标Activity，
     *                 在目标Activity的Fragment（ContentFragment）中获取参数，然后调用getActivity().setResult(ListTitleFragment.REQUEST_DETAIL, intent);
     *                 进行设置返回的数据；最后在ListTitleFragment.onActivityResult（）拿到返回的数据进行回显；
     */
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mCurrentPos = position;
        Intent intent = new Intent(getActivity(), ContentActivity.class);
        intent.putExtra(ContentFragment.ARGUMENT, mTitles.get(position));
        startActivityForResult(intent, REQUEST_DETAIL);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("TAG", "onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_DETAIL) {
            mTitles.set(mCurrentPos, mTitles.get(mCurrentPos) + " -- " + data.getStringExtra(ContentFragment.RESPONSE));
            mAdapter.notifyDataSetChanged();
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
        void onFragmentInteraction(Uri uri);
    }
}
