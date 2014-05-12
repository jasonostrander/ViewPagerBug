package com.example.pagerbug;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageFragment extends Fragment implements LoaderCallbacks<Void> {
    TextView mText;

    public static PageFragment newInstance(int page) {
        PageFragment frag = new PageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("page", page);
        frag.setArguments(bundle);
        return frag;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        mText = (TextView) view.findViewById(R.id.text);
        mText.setText("onViewCreated");
        return view;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fm = getFragmentManager();
        // Uncomment this to demonstrate working offscreen loading
//        if (getArguments().getInt("page") > 0)
        getLoaderManager().initLoader(0, null, this);
    }
    
    @Override
    public Loader<Void> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<Void>(getActivity()) {
            @Override
            public Void loadInBackground() {
                return null;
            }
            
            @Override
            protected void onStartLoading() {
                super.onStartLoading();
                forceLoad();
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<Void> loader, Void data) {
        mText.setText("Finished loading: " + getArguments().getInt("page"));
    }

    @Override
    public void onLoaderReset(Loader<Void> loader) {
    }
}