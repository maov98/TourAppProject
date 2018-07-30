package com.example.miguelortiz.tourapp;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailFragment extends Fragment {

    public DetailFragment() {
    }

    Fragment currentFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView textboxTitle = view.findViewById(R.id.detaiFragmentTitle);
        TextView textboxDescription = view.findViewById(R.id.detailFragmentDescription );
        ImageView imageicon = view.findViewById(R.id.detailImageView);
        Bundle bundle = getArguments();

        if (bundle != null){

            Integer drawableid = bundle.getInt(getString(R.string.bundle2));



            if(bundle.getString(getString(R.string.bundle1)) != null){
                textboxTitle.setText(bundle.getString(getString(R.string.bundle1)));
            }

            if(bundle.getString(getString(R.string.bundle3)) != null){
                textboxDescription.setText(bundle.getString(getString(R.string.bundle3)));
            }

            if(drawableid != 0){

                imageicon.setImageResource(drawableid);
            }
        }

        final Button button = (Button) view.findViewById(R.id.hideFragment);

        if(button != null){

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Fragment manager = getActivity().getSupportFragmentManager().findFragmentById(R.id.detailedLayout);
                    FragmentManager manager2 = getFragmentManager();
                    manager2.beginTransaction().remove(manager).commit();
                }



            });
        }
        return view;
    }
}
