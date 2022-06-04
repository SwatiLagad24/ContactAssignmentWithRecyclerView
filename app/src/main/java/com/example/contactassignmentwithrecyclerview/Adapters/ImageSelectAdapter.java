package com.example.contactassignmentwithrecyclerview.Adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.contactassignmentwithrecyclerview.R;
public class ImageSelectAdapter extends RecyclerView.Adapter<ImageSelectAdapter.ImageViewHolder>
{
    private int[]imageIds;

    private OnImageClickListener onImageClickListener;
    public void setOnImageClickListener(OnImageClickListener onImageClickListener){
        this.onImageClickListener=onImageClickListener;
    }
    public ImageSelectAdapter(int [] imageIds){
        this.imageIds=imageIds;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        ImageView imageSelect;
        public ImageViewHolder(View view)
        {
            super(view);
            imageSelect=(ImageView)view;
            imageSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onImageClickListener!=null)
                    {
                        onImageClickListener.onImageClickListener(
                                imageIds[getAdapterPosition()],
                                getAdapterPosition()
                        );

                    }
                }
            });
        }

    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ImageViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_image,null)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        holder.imageSelect.setImageResource(imageIds[position]);
    }

    @Override
    public int getItemCount() {
        return imageIds.length;
    }

    public interface OnImageClickListener {


        public void onImageClickListener(int imageId,int position);


    }



}
