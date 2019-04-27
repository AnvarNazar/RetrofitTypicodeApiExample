package com.anvar.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anvar.example.R;
import com.anvar.example.model.Todo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private Context mContext;
    private List<Todo> todos;

    public TodoAdapter(Context mContext, List<Todo> todos) {
        this.mContext = mContext;
        this.todos = todos;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.todo_item, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        if (todos.get(position) == null) return;
        holder.checkBox.setText(todos.get(position).title);
        holder.checkBox.setChecked(todos.get(position).isCompleted);
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.todo_checkbox)
        CheckBox checkBox;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
