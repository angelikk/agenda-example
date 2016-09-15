package com.icom.agenda;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by angelicazavala on 15/09/16.
 */
public class ContactsRecyclerViewAdapter extends RecyclerView.Adapter<ContactsRecyclerViewAdapter.ContactViewHolder> {

    private List<ContactBean> contactBeanList;

    public ContactsRecyclerViewAdapter(List<ContactBean> contactBeanList) {
        this.contactBeanList = contactBeanList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContactViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view_contacts, parent, false));
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

        holder.tvContactName.setText(contactBeanList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return contactBeanList.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPicture;
        private TextView tvContactName;

        public ContactViewHolder(View itemView) {
            super(itemView);

            ivPicture = (ImageView) itemView.findViewById(R.id.iv_contact);
            tvContactName = (TextView) itemView.findViewById(R.id.tv_contactName);
        }
    }
}
