package br.digitalhouse.menuscardview.views.galeria.view;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;
import br.digitalhouse.menuscardview.R;
import br.digitalhouse.menuscardview.views.galeria.adapter.AlbumViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class GaleriaFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AlbumViewPagerAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_galeriafragment, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPagerAlbum);

        adapter = new AlbumViewPagerAdapter(getActivity().getSupportFragmentManager(), listaAlbum());

        viewPager.setAdapter(adapter);

        viewPager.setOffscreenPageLimit(listaAlbum().size());

        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private List<Album> listaAlbum(){
        List<Album> listaAlbum = new ArrayList<>();

        listaAlbum.add(new Album("Caetano Veloso", AlbumFragment.newInstance
                ("Caetano Veloso", R.drawable.caetanoveloso)));

        listaAlbum.add(new Album("The Rolling Stones", AlbumFragment.newInstance
                ("The Rolling Stones", R.drawable.rollingstones)));

        listaAlbum.add(new Album("Johnny Hooker", AlbumFragment.newInstance
                ("Johnny Hooker", R.drawable.johnnyhooker)));

        return listaAlbum;
    }
}
