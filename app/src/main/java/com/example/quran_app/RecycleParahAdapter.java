package com.example.quran_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quran_app.QDH;
import com.example.quran_app.QuranArabicText;
import com.example.quran_app.RecycleSurah;

public class RecycleParahAdapter extends RecyclerView.Adapter<RecycleParahAdapter.MyViewHolder> {

    String[] urdu, eng;
    Context context;

    QDH qdh = new QDH();
    QuranArabicText qat = new QuranArabicText();

    public RecycleParahAdapter(Context ct,String quranUrdu[],String quranEng[]){
        context = ct;
        urdu = quranUrdu;
        eng = quranEng;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.para_row,parent,false);
        return new MyViewHolder(view);
    }

    //    communicating with MyViewHolder Class
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        surah
        holder.paraUrdu.setText(urdu[position]);
        holder.paraEng.setText(eng[position]);
//        surah OnClick listener
        holder.para.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = qdh.PSP[position];
                int end;
                QuranArabicText qat = new QuranArabicText();
                if (start == 5747) {
                    end = qat.QuranArabicText.length; // 6348
                }
                else{
                    end = qdh.PSP[position+1];
                }
                Intent intent = new Intent(context, RecycleParah.class);
                intent.putExtra("start", start);
                intent.putExtra("end", end);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return urdu.length;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView paraUrdu,paraEng;
        ConstraintLayout para;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            paraUrdu = itemView.findViewById(R.id.paraTitle);
            paraEng = itemView.findViewById(R.id.paraEngTitle);
            para = itemView.findViewById(R.id.singlePara);
        }
    }
}
