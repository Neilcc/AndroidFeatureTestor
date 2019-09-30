package com.zcc.myapplication.rv;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zcc.myapplication.R;

import java.util.Arrays;
import java.util.List;

public class RvTestActivity extends AppCompatActivity {

    private static final int[] colors = new int[]{
            Color.BLACK,
            Color.BLUE,
            Color.RED,
            Color.YELLOW
    };
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_test);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        SimpleAD simpleAD = new SimpleAD();
        simpleAD.setDatas(Arrays.asList(
                "1", "2", "3", "4", "5", "^", "1", "2", "3", "4", "5", "^"

        ));
        rv.setAdapter(simpleAD);
        rv.setClipToPadding(false);
        rv.setClipChildren(false);

    }

    public static class SimplVH extends RecyclerView.ViewHolder {

        public SimplVH(@NonNull View itemView) {
            super(itemView);
        }
    }

    public static class SimpleAD extends RecyclerView.Adapter<SimplVH> {

        private List<String> datas;

        public void setDatas(List<String> datas) {
            this.datas = datas;
        }

        @NonNull
        @Override
        public SimplVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            TextView textView = new TextView(parent.getContext());
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(300, 300);
            textView.setLayoutParams(lp);
            return new SimplVH(textView);
        }

        @Override
        public void onBindViewHolder(@NonNull SimplVH holder, int position) {
            ((TextView) holder.itemView).setText(position + "");

            holder.itemView.setBackgroundColor(colors[position % colors.length]);
        }

        @Override
        public int getItemCount() {
            return datas == null ? 0 : datas.size();
        }
    }
}
