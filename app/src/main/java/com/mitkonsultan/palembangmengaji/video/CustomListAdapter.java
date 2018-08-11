/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mitkonsultan.palembangmengaji.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.mitkonsultan.palembangmengaji.info.AppController;
import com.android.volley.toolbox.NetworkImageView;
import com.mitkonsultan.palembangmengaji.DetailActivityVideo;
import com.mitkonsultan.palembangmengaji.R;

import java.util.List;


public class CustomListAdapter extends BaseAdapter {
	private Activity activity;
	private LayoutInflater inflater;
	private List<Movie> movieItems;
	ImageLoader imageLoader = AppController.getInstance().getImageLoader();

	public CustomListAdapter(Activity activity, List<Movie> movieItems) {
		this.activity = activity;
		this.movieItems = movieItems;
	}

	public CustomListAdapter(Context context, Movie movie) {

	}

	@Override
	public int getCount() {
		return movieItems.size();
	}

	@Override
	public Object getItem(int location) {
		return movieItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (inflater == null)
			inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null)
			convertView = inflater.inflate(R.layout.list_info_video, null);

		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();
		NetworkImageView thumbNail = (NetworkImageView) convertView
				.findViewById(R.id.thumbnail);
		final TextView title = (TextView) convertView.findViewById(R.id.title);
		TextView durasi = (TextView) convertView.findViewById(R.id.releaseYear);
		//TextView pemateri = (TextView) convertView.findViewById(R.id.pemateri);
		// getting movie data for the row
		final Movie m = movieItems.get(position);

		// thumbnail image
		thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);

		// title
		title.setText(m.getTitle());
		durasi.setText(m.getDurasi());
		//pemateri.setText(m.getPemateri());


		convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Get the position
                //resultp = data.get(position);
                Intent intent = new Intent(activity, DetailActivityVideo.class);
				intent.putExtra("video", m.getVideo());




				// Start SingleItemView Class
               activity.startActivity(intent);

            }
        });

		return convertView;
	}
}
