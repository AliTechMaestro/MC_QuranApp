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

public class RecycleSurahAdapter extends RecyclerView.Adapter<RecycleSurahAdapter.MyViewHolder> {

    String[] urdu, eng;
    Context context;

    QDH qdh = new QDH();
    QuranArabicText qat = new QuranArabicText();

    public RecycleSurahAdapter(Context ct,String quranUrdu[],String quranEng[]){
        context = ct;
        urdu = quranUrdu;
        eng = quranEng;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.surah_row,parent,false);
        return new MyViewHolder(view);
    }

    //    communicating with MyViewHolder Class
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        surah
        holder.surahUrdu.setText(urdu[position]);
        holder.surahEng.setText(eng[position]);
//        surah OnClick listener
        holder.surah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = qdh.SSP[position];
                int end;
                QuranArabicText qat = new QuranArabicText();
                if(start==6342){
                    end = qat.QuranArabicText.length+1;
                }
                else{
                    end = qdh.SSP[position+1];
                }
                Intent intent = new Intent(context, RecycleSurah.class);
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

        TextView surahUrdu,surahEng;
        ConstraintLayout surah;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            surahUrdu = itemView.findViewById(R.id.surahTitle);
            surahEng = itemView.findViewById(R.id.surahEngTitle);
            surah = itemView.findViewById(R.id.singleSurah);
        }
    }
}
