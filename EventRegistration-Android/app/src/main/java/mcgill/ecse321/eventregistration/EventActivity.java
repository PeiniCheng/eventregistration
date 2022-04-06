package mcgill.ecse321.eventregistration;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class EventActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    private String error = null;
    private ArrayList<Event> events = new ArrayList<>();;
    private ArrayAdapter<Event> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        final ListView listview = (ListView) findViewById(R.id.listView);
        adapter = new EventAdapter(this, events);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                view.animate().setDuration(200).alpha(0);
            }

        });
        refreshLists(this.getCurrentFocus());
    }

    public void refreshLists(View view) {
        loadEvents(adapter ,events);
    }

    class Event {
        public String name;
        public String time;

        public Event(String name, String eventDate, String startTime, String endTime) {
            this.name = name;
            this.time = eventDate + "   " + startTime + "-" + endTime;
        }
    }

    class EventAdapter extends ArrayAdapter<Event> {
        public EventAdapter(Context context, ArrayList<Event> users) {
            super(context, 0, users);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Event event = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.event, parent, false);
            }
            // Lookup view for data population
            TextView tvName = (TextView) convertView.findViewById(R.id.eventName);
            TextView tvHome = (TextView) convertView.findViewById(R.id.eventTime);
            // Populate the data into the template view using the data object
            tvName.setText(event.name);
            tvHome.setText(event.time);
            // Return the completed view to render on screen
            return convertView;
        }
    }

    private void loadEvents(final ArrayAdapter<Event> adapter, final List<Event> events) {
        HttpUtils.get("events/", new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject eventJSON = response.getJSONObject(i);
                        events.add(new Event(eventJSON.getString("name"),
                                eventJSON.getString("eventDate"),
                                eventJSON.getString("startTime"),
                                eventJSON.getString("endTime")));
                    } catch (Exception e) {
                        error += e.getMessage();
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                try {
                    error += errorResponse.get("message").toString();
                } catch (JSONException e) {
                    error += e.getMessage();
                }
            }
        });
    }
}