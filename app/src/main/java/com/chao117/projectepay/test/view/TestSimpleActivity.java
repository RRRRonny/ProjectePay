package com.chao117.projectepay.test.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.chao117.projectepay.R;
import com.chao117.projectepay.base.BaseActivity;
import com.chao117.projectepay.test.presenter.ITestSimplePresenter;
import com.chao117.projectepay.test.presenter.TestSimplePresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestSimpleActivity extends BaseActivity implements ITestSimpleView {
    private ITestSimplePresenter iTestSimplePresenter;


    @BindView(R.id.lvTestSimGoods)
    ListView lvTestSimGoods;
    @BindView(R.id.btnTestSimCommit)
    Button btnTestSimCommit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_simple);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        iTestSimplePresenter = new TestSimplePresenterImpl(this, this);
    }

    @Override
    public void onDoCommit(List<String> names, List<Double> prices) {
        MyAdapter myAdapter = new MyAdapter(names, prices);
        lvTestSimGoods.setAdapter(myAdapter);
    }

    @OnClick(R.id.btnTestSimCommit)
    public void onViewClicked() {
        iTestSimplePresenter.doCommit();
    }

    class MyAdapter extends BaseAdapter {
        private List<String> names;
        private List<Double> prices;


        public MyAdapter(List<String> names, List<Double> prices) {
            this.names = names;
            this.prices = prices;
        }


        @Override
        public int getCount() {
            return names.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            Holder holder;
            if (convertView == null) {
                holder = new Holder();
                convertView = inflater.inflate(R.layout.layout_test_simple_browse, null);
                holder.name = (TextView) convertView.findViewById(R.id.tvLayTestSimName);
                holder.price = (TextView) convertView.findViewById(R.id.tvLayTestSimPrice);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }
            holder.name.setText(names.get(position));
            holder.price.setText(Double.valueOf(prices.get(position)).toString());
            return convertView;
        }

        class Holder {
            TextView name;
            TextView price;
        }
    }
}
