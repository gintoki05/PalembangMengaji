/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mitkonsultan.palembangmengaji.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.NoConnectionError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.mitkonsultan.palembangmengaji.R;
import com.mitkonsultan.palembangmengaji.info.AppController;
import com.mitkonsultan.palembangmengaji.video.CustomListAdapter;
import com.mitkonsultan.palembangmengaji.video.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class FragmentEmpat extends Fragment {
    private static final String TAG = FragmentEmpat.class.getSimpleName();
    //private ProgressDialog pDialog;
    // Movies json url
    private static final String url = "http://palembangmengaji.forkismapalembang.com/video.php";
    private List<Movie> movieList = new ArrayList<Movie>();
    private ListView listView;
    private CustomListAdapter adapter;
//private TextView txtFragmentone;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    public static FragmentEmpat newInstance() {
        FragmentEmpat fragment = new FragmentEmpat();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fragment_empat, container, false);
        //txtFragmentone = (TextView) rootView.findViewById(R.id.txtFragmentOne);
        //txtFragmentone.setText(R.string.fragment_tab_one);

        listView = (ListView) rootView.findViewById(R.id.list3);
        //pDialog = new ProgressDialog(getActivity());
        adapter = new CustomListAdapter(getActivity(), movieList);
        listView.setAdapter(adapter);


        //pDialog.setMessage("“Dan, Allah mencintai orang-orang yang sabar”. [Ali Imran : 146]");
        //pDialog.show();
        movieList.clear();


        // Creating volley request obj
        if(movieList.isEmpty()) {
            JsonArrayRequest movieReq = new JsonArrayRequest(url,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Log.d(TAG, response.toString());
                            //pDialog.hide();
                            // Parsing json
                            for (int i = 0; i < response.length(); i++) {
                                try {

                                    JSONObject obj = response.getJSONObject(i);
                                    Movie movie = new Movie();
                                    movie.setTitle(obj.getString("judul"));
                                    movie.setVideo(obj.getString("video"));
                                    movie.setThumbnailUrl(obj.getString("gambar"));
                                    movie.setDurasi(obj.getString("durasi"));
                                    movie.setPemateri(obj.getString("pemateri"));



                                    // adding movie to movies array
                                    movieList.add(movie);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }

                            // notifying list adapter about data changes
                            // so that it renders the list view with updated data
                            adapter.notifyDataSetChanged();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof NoConnectionError) {
                        Toast.makeText(getActivity(), "Tidak Ada Koneksi Internet, Silahkan Coba Lagi", Toast.LENGTH_LONG).show();
                        //pDialog.hide();
                    }
                }

                ;


            });

            // Adding request to request queue
            AppController.getInstance().addToRequestQueue(movieReq);
        }
        return rootView;
    }


}