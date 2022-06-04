package com.example.contactassignmentwithrecyclerview.Adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.contactassignmentwithrecyclerview.Contact;
import com.example.contactassignmentwithrecyclerview.R;
import java.util.ArrayList;
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>
{

    private ArrayList<Contact> contactArrayList;
    public  ContactAdapter(ArrayList<Contact>contactArrayList){
        this.contactArrayList=contactArrayList;
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{
        ImageView imgContact;
        TextView txtName,txtEmail,txtPhno;

        public ContactViewHolder(View itemView) {
            super(itemView);
            imgContact=itemView.findViewById(R.id.imgContact);
            txtName=itemView.findViewById(R.id.txtContactName);
            txtPhno=itemView.findViewById(R.id.txtPhoneNumber);
            txtEmail=itemView.findViewById(R.id.txtEmailID);







        }
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.show_contact, null);

        ContactViewHolder contactViewHolder = new ContactViewHolder(view);


        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        Contact contact=contactArrayList.get(position);
        holder.imgContact.setImageResource(contact.getId());
        holder.txtEmail.setText(contact.getEdtEmailId());
        holder.txtPhno.setText(contact.getEdtPhNumber());
        holder.txtName.setText(contact.getEdtName());
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }


}
