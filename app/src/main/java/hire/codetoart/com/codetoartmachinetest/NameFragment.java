package hire.codetoart.com.codetoartmachinetest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by linux on 2/9/17.
 */

public class NameFragment extends Fragment {

    private TextView txtName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_name, null);

        txtName = (TextView) view.findViewById(R.id.txtName);
        txtName.setText("SWAPNIL KHAMKAR");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

}
