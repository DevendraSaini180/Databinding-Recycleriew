package com.saini.databindingapplication.views.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.saini.databindingapplication.BR;
import com.saini.databindingapplication.R;
import com.saini.databindingapplication.model.User;

import java.util.List;

public class UserAdapter  extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<User> mList;
    Context mContext;

    public UserAdapter(List<User> userList, Context context) {
        this.mList = userList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_user, parent, false);
        return new UserAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        User user = mList.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mBinding;

        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void bind(Object object) {
            mBinding.setVariable(BR.user, object);
            mBinding.executePendingBindings();
        }
    }
}
