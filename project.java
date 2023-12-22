import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText taskInput;
    private ListView taskList;
    private ArrayList<String> tasks;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskInput = findViewById(R.id.taskInput);
        taskList = findViewById(R.id.taskList);

        tasks = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        taskList.setAdapter(adapter);
    }

    public void addTask(View view) {
        String task = taskInput.getText().toString();
        if (!task.isEmpty()) {
            tasks.add(task);
            adapter.notifyDataSetChanged();
            taskInput.setText("");
        }
    }

    public void deleteTask(View view) {
        int position = taskList.getPositionForView(view);
        tasks.remove(position);
        adapter.notifyDataSetChanged();
    }
}
