package com.mitkonsultan.palembangmengaji.info;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.mitkonsultan.palembangmengaji.DetailActivity;
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
			convertView = inflater.inflate(R.layout.list_info, null);

		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();
		NetworkImageView thumbNail = (NetworkImageView) convertView
				.findViewById(R.id.thumbnail);
		final TextView title = (TextView) convertView.findViewById(R.id.title);
		TextView deskripsi = (TextView) convertView.findViewById(R.id.genre);
		TextView tanggal = (TextView) convertView.findViewById(R.id.releaseYear);

		// getting movie data for the row
		final Movie m = movieItems.get(position);

		// thumbnail image
		thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);

		// title
		title.setText(m.getTitle());
		deskripsi.setText(m.getDeskripsi());
		tanggal.setText(m.getTanggal());

        convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Get the position
                //resultp = data.get(position);
                Intent intent = new Intent(activity, DetailActivity.class);
				intent.putExtra("judul", m.getTitle());
				intent.putExtra("deskripsi", m.getDeskripsi());
				intent.putExtra("tanggal", m.getTanggal());
				intent.putExtra("gambar", m.getThumbnailUrl());




				// Start SingleItemView Class
               activity.startActivity(intent);

            }
        });

		return convertView;
	}
}
