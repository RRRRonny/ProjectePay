package com.chao117.projectepay.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.chao117.projectepay.R;
import com.chao117.projectepay.model.Goods;
import com.chao117.projectepay.presenter.account.base.ICheckBaseInfoPresenter;
import com.chao117.projectepay.presenter.browse.BaseBrowsePresenterImpl;
import com.chao117.projectepay.presenter.browse.CheckGoodsDetailPresenterImpl;
import com.chao117.projectepay.presenter.browse.IBaseBrowsePresenter;
import com.chao117.projectepay.presenter.browse.ICheckGoodsDetailPresenter;
import com.chao117.projectepay.view.IBaseBrowseView;
import com.chao117.projectepay.view.ICheckGoodsDetailView;
import com.chao117.projectepay.view.adapter.GoodsDetailsAdapter;
import com.chao117.projectepay.view.dialog.GoodsDetailDialog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements IBaseBrowseView, ICheckGoodsDetailView {


    @BindView(R.id.layGeneralListView)
    ListView layGeneralListView;
    Unbinder unbinder;

    private IBaseBrowsePresenter iBaseBrowsePresenter;
    private ICheckBaseInfoPresenter iCheckBaseInfoPresenter;
    private ICheckGoodsDetailPresenter iCheckGoodsDetailPresenter;
    private List<Goods> goodsList;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        iBaseBrowsePresenter = new BaseBrowsePresenterImpl(getContext(), this);
        iBaseBrowsePresenter.doBrowse();
        iCheckGoodsDetailPresenter = new CheckGoodsDetailPresenterImpl(getContext(), this);
        layGeneralListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                iCheckGoodsDetailPresenter.doCheckGoodsDetail(goodsList.get(position).getId());
                return true;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDoBaseBrowse(List<Goods> goodsList) {
        this.goodsList = goodsList;
        layGeneralListView.setAdapter(new GoodsDetailsAdapter(getContext(), goodsList));
    }

    @Override
    public void onDoCheckGoodsDetail(Goods goods) {
        GoodsDetailDialog goodsDialog = new GoodsDetailDialog(getContext(), goods);
        goodsDialog.show();
    }
}
