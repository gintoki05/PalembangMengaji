package com.mitkonsultan.palembangmengaji.jadwal;

/**
 * Created by ajie on 24/09/17.
 */


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mitkonsultan.palembangmengaji.R;
import com.mitkonsultan.palembangmengaji.hari.Ahad;
import com.mitkonsultan.palembangmengaji.hari.Jumat;
import com.mitkonsultan.palembangmengaji.hari.Kamis;
import com.mitkonsultan.palembangmengaji.hari.Rabu;
import com.mitkonsultan.palembangmengaji.hari.Sabtu;
import com.mitkonsultan.palembangmengaji.hari.Selasa;
import com.mitkonsultan.palembangmengaji.hari.Senin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by docotel on 3/7/16.
 */
public class MemberListAdapter extends RecyclerView.Adapter<MemberListAdapter.MemberViewHolder>{

    private List<Member> memberList;

    public MemberListAdapter() {
        memberList = new ArrayList<>();
    }

    private void add(Member item) {
        memberList.add(item);
        notifyItemInserted(memberList.size() - 1);
    }

    public void addAll(List<Member> memberList) {
        for (Member member : memberList) {
            add(member);
        }
    }

    public void remove(Member item) {
        int position = memberList.indexOf(item);
        if (position > -1) {
            memberList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public Member getItem(int position){
        return memberList.get(position);
    }

    @Override
    public MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        MemberViewHolder memberViewHolder = new MemberViewHolder(view);
        return memberViewHolder;
    }

    @Override
    public void onBindViewHolder(MemberViewHolder holder, final int position) {
        final Member member = memberList.get(position);

        holder.memberThumb.setImageResource(member.getThumb());
        holder.memberName.setText(member.getName());
        holder.CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Senin.class);
                    context.startActivity(intent);
                }
                else if (position == 1) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Selasa.class);
                    context.startActivity(intent);
                }
                else if (position == 2) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Rabu.class);
                    context.startActivity(intent);
                }
                else if (position == 3) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Kamis.class);
                    context.startActivity(intent);
                }
                else if (position == 4) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Jumat.class);
                    context.startActivity(intent);
                }
                else if (position == 5) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Sabtu.class);
                    context.startActivity(intent);
                }
                else if (position == 6) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Ahad.class);
                    context.startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    static class MemberViewHolder extends RecyclerView.ViewHolder {
        CardView CardView;
        ImageView memberThumb;
        TextView memberName;

        public MemberViewHolder(View itemView) {
            super(itemView);

            CardView = (CardView) itemView.findViewById(R.id.card_view);
            memberThumb = (ImageView) itemView.findViewById(R.id.thumbnail);
            memberName = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }
}
