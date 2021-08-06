package com.balqis.wetalklatest;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SavePageAdapter extends RecyclerView.Adapter<SavePageAdapter.PageViewHolder> {
    Context context;
    Activity activity;
    ArrayList<wordData> arrayList;
    DBHelper db = new DBHelper(context);

    public SavePageAdapter(Context context, Activity activity, ArrayList<wordData> arrayList){
        this.context = context;
        this.activity = activity;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public PageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vieawadapter_ui,parent,false);
        return new PageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SavePageAdapter.PageViewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).getName());
        holder.wordDescription.setText(arrayList.get(position).getWord());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deletedata(arrayList.get(position).getID());
                arrayList.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editHere(position);
            }
        });
    }

    private void editHere(final int pos) {
        final EditText title, description;
        Button submit;
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        dialog.setContentView(R.layout.edit_layout);
        params.copyFrom(dialog.getWindow().getAttributes());
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(params);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        title       = dialog.findViewById(R.id.updateTitle);
        description = dialog.findViewById(R.id.updateDescription);
        submit      = dialog.findViewById(R.id.updateBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(title.getText().toString().isEmpty()){
                    title.setError("Please Mention Your Name");
                }else if(description.getText().toString().isEmpty()){
                    description.setError("Please enter your word");
                }else{
                    db.updateuserdata(title.getText().toString(),description.getText().toString(),arrayList.get(pos).getID());
                    arrayList.get(pos).setName(title.getText().toString());
                    arrayList.get(pos).setWord(description.getText().toString());
                    dialog.cancel();
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class PageViewHolder extends RecyclerView.ViewHolder{
        TextView name, wordDescription;
        ImageView delete, edit;
        public PageViewHolder(@NonNull View itemView) {
            super(itemView);

            name            = itemView.findViewById(R.id.title);
            wordDescription = itemView.findViewById(R.id.worddescription);
            delete          = itemView.findViewById(R.id.deleteWordBtn);
            edit            = itemView.findViewById(R.id.editWordBtn);
        }
    }
}
