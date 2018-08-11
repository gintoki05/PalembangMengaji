package com.mitkonsultan.palembangmengaji.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import com.mitkonsultan.palembangmengaji.jadwal.Member;
import com.mitkonsultan.palembangmengaji.jadwal.MemberListAdapter;
import com.mitkonsultan.palembangmengaji.R;

public class FragmentSatu extends Fragment {

    private RecyclerView listMember;
    private LinearLayoutManager linearLayoutManager;
    private MemberListAdapter memberListAdapter;
    protected Context context;

    public static FragmentSatu newInstance(){
        return new FragmentSatu();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_satu, container, false);
        listMember = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        linearLayoutManager = new LinearLayoutManager(context);
        memberListAdapter = new MemberListAdapter();
        listMember.setLayoutManager(linearLayoutManager);
        listMember.setAdapter(memberListAdapter);
        loadData();
    }

    private void loadData(){
        List<Member> memberList = new ArrayList<>();
        Member member;

        int thumb[] = {R.drawable.seninlist, R.drawable.selasalist, R.drawable.rabulist,
                R.drawable.kamislist, R.drawable.jumatlist, R.drawable.sabtulist,
                R.drawable.ahadlist};
        String name[] = {"Senin", "Selasa", "Rabu", "Kamis",
                "Jumat", "Sabtu", "Ahad"};

        for(int i=0; i < thumb.length; i++){
            member = new Member();
            member.setId(i+1);
            member.setName(name[i]);
            member.setThumb(thumb[i]);
            memberList.add(member);
        }

        memberListAdapter.addAll(memberList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
