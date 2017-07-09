package hackathon.gsma.com.rupay.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import hackathon.gsma.com.rupay.R;
import hackathon.gsma.com.rupay.datasets.StatementData;
import hackathon.gsma.com.rupay.ui.Statements;

/**
 * Created by fred on 09/07/2017.
 */

public class StatementAdapter extends RecyclerView.Adapter<StatementAdapter.ViewHolder> {

    ArrayList<StatementData> mValues;
    Context mContext;
    private int lastAnimatedPosition = -1;


    public StatementAdapter(Context context, ArrayList<StatementData> list){
        mContext = context;
        mValues = list;
    }



    @Override
    public StatementAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.statement_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StatementAdapter.ViewHolder holder, int position) {

        holder.mItem = mValues.get(position);

        holder.mAmount.setText(holder.mItem.getAmount());
        holder.mSendTo.setText(holder.mItem.getTransaction_to());
        holder.mRefNo.setText(holder.mItem.getTransactionReference());


        animateView(holder.mView,position);


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final LinearLayout mView;
        TextView mAmount, mSendTo,mRefNo;
        StatementData mItem;


        public ViewHolder(View itemView) {
            super(itemView);

            mView = (LinearLayout)itemView;
            mAmount = (TextView)itemView.findViewById(R.id.amount);
            mSendTo = (TextView)itemView.findViewById(R.id.to);
            mRefNo = (TextView)itemView.findViewById(R.id.ref_no);

        }
    }


    //Animate view after its attached to window
    private void animateView(View view, int position){
        if(position > lastAnimatedPosition){
            lastAnimatedPosition = position;
            view.setTranslationY(300);
            view.animate()
                    .translationY(0.0f)
                    .setInterpolator(new DecelerateInterpolator(3.0f))
                    .setDuration(700)
                    .start();
        }
    }
}
